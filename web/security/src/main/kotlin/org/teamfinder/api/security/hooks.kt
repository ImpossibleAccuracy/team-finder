@file:Suppress("unused")

package org.teamfinder.api.security

import org.teamfinder.api.security.model.AccountAuthentication
import org.teamfinder.api.security.scope.AuthorizedScope
import org.teamfinder.api.security.scope.PossibleAuthorizedScope

suspend fun <T> tryAuthenticate(block: suspend PossibleAuthorizedScope.() -> T): T {
    val authentication = getAccountAuthentication()

    return PossibleAuthorizedScope(authentication).block()
}

suspend fun <T> requireAuthenticated(block: suspend AuthorizedScope.() -> T): T {
    val authentication = requireAccountAuthentication()

    return AuthorizedScope(authentication).block()
}

suspend fun <T> requireAnyRole(vararg roles: String, block: suspend AuthorizedScope.() -> T): T {
    if (roles.isEmpty()) {
        throwAccessDenied<Unit>("Call denied")
    }

    val authentication = requireAccountAuthentication()

    if (hasAnyAuthority(
            authentication.authorities,
            AccountAuthentication.ROLE_PREFIX,
            *roles
        )
    ) {
        return AuthorizedScope(authentication).block()
    }

    return throwAccessDenied("Not enough rights")
}

suspend fun <T> requireAnyPermission(vararg privileges: String, block: suspend AuthorizedScope.() -> T): T {
    if (privileges.isEmpty()) {
        throwAccessDenied<Unit>("Call denied")
    }

    val authentication = requireAccountAuthentication()

    if (hasAnyAuthority(
            authentication.authorities,
            AccountAuthentication.PRIVILEGE_PREFIX,
            *privileges
        )
    ) {
        return AuthorizedScope(authentication).block()
    }

    return throwAccessDenied("Not enough rights")
}

suspend fun <T> requireAnyPermissionOrDefault(
    vararg privileges: String,
    default: T,
    block: suspend AuthorizedScope.() -> T
): T {
    return try {
        requireAnyPermission(*privileges) {
            block.invoke(this)
        }
    } catch (t: Throwable) {
        default
    }
}
