package org.teamfinder.api.service.token

interface TokenService {
    suspend fun extractSubject(token: String): String?

    suspend fun generateToken(subject: String, extra: Map<String, Any>? = null): String
}
