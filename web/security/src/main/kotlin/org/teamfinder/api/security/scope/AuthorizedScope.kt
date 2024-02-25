package org.teamfinder.api.security.scope

import org.teamfinder.api.security.hasAnyAuthority
import org.teamfinder.api.security.model.AccountAuthentication

class AuthorizedScope(
    private val authentication: AccountAuthentication
) : SecurityScope() {
    val account = authentication.account

    override fun hasAnyRole(vararg roles: String): Boolean =
        hasAnyAuthority(
            authentication.authorities,
            AccountAuthentication.ROLE_PREFIX,
            *roles
        )

    override fun hasAnyPrivilege(vararg privileges: String): Boolean =
        hasAnyAuthority(
            authentication.authorities,
            AccountAuthentication.PRIVILEGE_PREFIX,
            *privileges
        )
}
