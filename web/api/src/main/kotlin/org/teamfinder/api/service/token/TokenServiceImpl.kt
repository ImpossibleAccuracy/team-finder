package org.teamfinder.api.service.token

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.teamfinder.api.config.token.TokenProperties
import org.teamfinder.api.jwt.JwtUtils
import org.teamfinder.api.jwt.Token

@Service
class TokenServiceImpl(
    private val tokenProperties: TokenProperties,
    private val jwtUtils: JwtUtils
) : TokenService {
    override suspend fun extractEmail(token: String) =
        withContext(Dispatchers.Default) {
            jwtUtils.parseSubject(token)
        }

    override suspend fun generateToken(subject: String, extra: Map<String, Any>?) =
        withContext(Dispatchers.Default) {
            Token.build(subject, tokenProperties.expirationTime, extra).let {
                jwtUtils.generateToken(it)
            }
        }
}
