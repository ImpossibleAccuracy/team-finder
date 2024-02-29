package org.teamfinder.api.security.model

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.teamfinder.data.account.Account

class AccountAuthentication(
    val account: Account,
    authorities: List<String>,
    private val credentials: Any?,
    private val details: Any?
) : Authentication {
    companion object {
        const val ROLE_PREFIX = "ROLE_"
        const val PRIVILEGE_PREFIX = "PRIVILEGE_"
    }

    private val authorities = authorities
        .map { SimpleGrantedAuthority(it) }

    override fun getName(): String =
        account.email

    override fun getAuthorities(): List<GrantedAuthority> =
        authorities

    override fun getCredentials(): Any =
        credentials ?: ""

    override fun getDetails(): Any =
        details ?: ""

    override fun getPrincipal(): Any =
        account

    override fun isAuthenticated(): Boolean =
        true

    override fun setAuthenticated(isAuthenticated: Boolean) {
        throw UnsupportedOperationException("AccountAuthentication.setAuthenticated")
    }

    /*private fun getRoleAuthorities(role: Role): List<GrantedAuthority> = role.privileges
        .map {
            SimpleGrantedAuthority(PRIVILEGE_PREFIX + it.title)
        }
        .plus(
            SimpleGrantedAuthority(ROLE_PREFIX + role.title)
        )*/
}
