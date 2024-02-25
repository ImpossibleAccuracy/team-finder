package org.teamfinder.api.security.auth

import org.teamfinder.data.model.account.Account

interface SecurityService {
    suspend fun authUserByRequestToken(token: String): Account?
}
