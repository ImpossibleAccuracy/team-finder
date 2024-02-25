package org.teamfinder.api.security

import org.springframework.security.core.GrantedAuthority
import org.teamfinder.api.security.context.AuthenticationContext
import org.teamfinder.api.security.model.AccountAuthentication
import kotlin.coroutines.coroutineContext

fun <T> throwAccessDenied(message: String? = null): T {
    throw SecurityException(message ?: "Unauthorized")
}

suspend fun getAccountAuthentication(): AccountAuthentication? =
    coroutineContext[AuthenticationContext.Key]?.getAuthentication() as? AccountAuthentication

suspend fun requireAccountAuthentication(): AccountAuthentication =
    coroutineContext[AuthenticationContext.Key]?.getAuthentication() as? AccountAuthentication
        ?: throwAccessDenied("Authorization required")

fun hasAnyAuthority(
    authorities: Collection<GrantedAuthority>,
    prefix: String,
    vararg strings: String
): Boolean =
    authorities.asSequence()
        .map { it.authority }
        .filterNotNull()
        .filter { it.startsWith(prefix) }
        .map { it.substring(prefix.length) }
        .filter { it.isNotEmpty() }
        .any { s ->
            strings.any {
                it.equals(s, true)
            }
        }
