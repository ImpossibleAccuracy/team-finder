package org.teamfinder.api.security.auth

import org.teamfinder.data.account.Account

interface SecurityService {
    suspend fun authUserByRequestToken(token: String): Account?
}
