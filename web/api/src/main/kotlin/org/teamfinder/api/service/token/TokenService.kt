package org.teamfinder.api.service.token

interface TokenService {
    suspend fun extractEmail(token: String): String?

    suspend fun generateToken(subject: String, extra: Map<String, Any>? = null): String
}