package org.teamfinder.api.security.scope

import org.teamfinder.api.security.hasAnyAuthority
import org.teamfinder.api.security.model.AccountAuthentication

class PossibleAuthorizedScope(
    private val authentication: AccountAuthentication?
) : SecurityScope() {
    val account = authentication?.account

    override fun hasAnyRole(vararg roles: String): Boolean =
        authentication?.let {
            hasAnyAuthority(
                it.authorities,
                AccountAuthentication.ROLE_PREFIX,
                *roles
            )
        } ?: false

    override fun hasAnyPrivilege(vararg privileges: String): Boolean =
        authentication?.let {
            hasAnyAuthority(
                it.authorities,
                AccountAuthentication.PRIVILEGE_PREFIX,
                *privileges
            )
        } ?: false
}
