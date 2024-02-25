package org.teamfinder.api.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.security.Key
import java.util.*

class JwtUtils(
    secret: String
) {
    private val signInKey: Key = Decoders.BASE64.decode(secret).let {
        Keys.hmacShaKeyFor(it)
    }

    fun generateToken(data: Token): String =
        Jwts.builder()
            .setClaims(data.extras ?: mapOf<String, Any>())
            .setSubject(data.subject)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + data.timeToLive))
            .signWith(signInKey, SignatureAlgorithm.HS256)
            .compact()

    fun parseSubject(jwt: String): String? =
        extractClaim(jwt) {
            it.subject
        }

    fun parseToken(jwt: String): Token {
        val claims = extractAllClaims(jwt)

        return Token(
            subject = claims.subject,
            extras = claims.toSortedMap(),
            timeToLive = claims.expiration.time
        )
    }

    private fun <T> extractClaim(jwt: String, claimsResolver: (claims: Claims) -> T): T? =
        try {
            val claims = extractAllClaims(jwt)
            claimsResolver(claims)
        } catch (e: JwtException) {
            null
        }

    private fun extractAllClaims(jwt: String) =
        Jwts.parserBuilder()
            .setSigningKey(signInKey)
            .build()
            .parseClaimsJws(jwt)
            .body
}
