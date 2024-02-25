package org.teamfinder.api.service.auth

import com.powerplace.web.models.repository.account.AccountRepository
import com.powerplace.web.models.repository.account.RoleRepository
import com.powerplace.web.security.constants.Roles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.teamfinder.api.data.exception.items.OperationRejectedException
import org.teamfinder.api.data.exception.items.ResourceNotFoundException
import org.teamfinder.api.service.token.TokenService
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.account.security.Role

@Service
class AuthServiceImpl(
    private val tokenService: TokenService,
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
//    private val authManager: AuthenticationManager
) : AuthService {
    override suspend fun checkExistsAccountByEmail(email: String): Boolean =
        withContext(Dispatchers.IO) {
            accountRepository.existsByEmailIgnoreCase(email)
        }

    override suspend fun signin(email: String, password: String): LoginResult {
        val cleanEmail = email.trim()
        val cleanPassword = password.trim()

        val account: Account =
            withContext(Dispatchers.IO) {
                accountRepository
                    .findByEmailIgnoreCase(cleanEmail)
                    .orElseThrow {
                        ResourceNotFoundException("Account not found")
                    }
            }

        if (!passwordEncoder.matches(cleanPassword, account.password)) {
            throw OperationRejectedException("Password mismatch")
        }

        return authenticate(account)
    }

    override suspend fun signup(email: String, phone: String?, password: String): LoginResult {
        val cleanEmail = email.trim()
        val cleanPhone = phone?.trim()
        val cleanPassword = password.trim()

        val exists = withContext(Dispatchers.IO) {
            accountRepository.existsByEmailIgnoreCase(cleanEmail)
        }

        if (exists) {
            throw OperationRejectedException("Account with such credentials already exists")
        }

        val account = Account(
            _id = null,
            email = cleanEmail,
            accountPassword = passwordEncoder.encode(cleanPassword),
            phone = cleanPhone,
            roles = getRoles(Roles.User)
        )

        val savedAccount = withContext(Dispatchers.IO) {
            accountRepository.save(account)
        }

        return authenticate(
            savedAccount
        )
    }

    override suspend fun generateEnterToken(account: Account): String =
        tokenService.generateToken(account.email)

    private suspend fun getRoles(vararg roles: String): Set<Role> =
        withContext(Dispatchers.IO) {
            roleRepository.findAllByTitleIn(roles.toSet()).toSet()
        }

    private suspend fun authenticate(account: Account): LoginResult {
        return LoginResult(
            id = account.id,
            email = account.email,
            token = generateEnterToken(account)
        )
    }
}
