package org.teamfinder.api.api.controller.auth

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.teamfinder.api.data.exception.items.OperationRejectedException
import org.teamfinder.api.data.utils.required
import org.teamfinder.api.schema.dto.AuthResponseDto
import org.teamfinder.api.service.account.AccountService
import org.teamfinder.api.service.token.TokenService
import org.teamfinder.data.account.Account

@Service
class AuthController(
    private val accountService: AccountService,
    private val tokenService: TokenService,
    private val passwordEncoder: PasswordEncoder
) {
    suspend fun isEmailUsed(email: String): Boolean =
        accountService.getAccountByEmail(email).isPresent

    suspend fun signIn(email: String, password: String): AuthResponseDto {
        val account = accountService
            .getAccountByEmail(email)
            .required()

        if (!passwordEncoder.matches(password, account.password)) {
            throw OperationRejectedException("Password mismatch")
        }

        return AuthResponseDto(
            id = account.pk,
            token = tokenService.generateToken(account.email)
        )
    }

    suspend fun signUp(email: String, password: String): AuthResponseDto {
        accountService.getAccountByEmail(email)
            .ifPresent {
                throw OperationRejectedException("User with such email already exists")
            }

        val account = Account(
            email = email,
            password = passwordEncoder.encode(password)
        ).let {
            accountService.save(it)
        }

        return AuthResponseDto(
            id = account.pk,
            token = tokenService.generateToken(account.email)
        )
    }
}
