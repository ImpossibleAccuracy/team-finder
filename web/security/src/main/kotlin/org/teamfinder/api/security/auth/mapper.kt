package org.teamfinder.api.security.auth

import org.teamfinder.api.security.model.AccountAuthentication.Companion.PRIVILEGE_PREFIX
import org.teamfinder.api.security.model.AccountAuthentication.Companion.ROLE_PREFIX
import org.teamfinder.data.account.Account

fun buildAuthoritiesRaw(account: Account): List<String> =
    account.roles.map { ROLE_PREFIX + it.title }
        .plus(
            account.roles
                .flatMap { it.privileges }
                .map { PRIVILEGE_PREFIX + it.title }
        )
