package org.teamfinder.api.api.security

import com.powerplace.web.service.account.AccountService
import org.springframework.stereotype.Service
import org.teamfinder.api.jwt.JwtUtils
import org.teamfinder.api.security.auth.SecurityService
import org.teamfinder.data.model.account.Account
import kotlin.jvm.optionals.getOrNull

@Service
class SecurityServiceImpl(
    private val jwtUtils: JwtUtils,
    private val accountService: AccountService
) : SecurityService {
    override suspend fun authUserByRequestToken(token: String): Account? =
        jwtUtils.parseSubject(token)?.let {
            accountService
                .getAccountByEmail(it)
                .getOrNull()
        }
}
