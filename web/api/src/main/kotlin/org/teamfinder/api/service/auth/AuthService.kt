package org.teamfinder.api.service.auth

import org.teamfinder.api.data.exception.items.OperationRejectedException
import org.teamfinder.api.data.exception.items.ResourceNotFoundException
import org.teamfinder.data.model.account.Account

interface AuthService {
    suspend fun checkExistsAccountByEmail(email: String): Boolean

    @Throws(ResourceNotFoundException::class, OperationRejectedException::class)
    suspend fun signin(email: String, password: String): LoginResult

    @Throws(OperationRejectedException::class)
    suspend fun signup(email: String, phone: String?, password: String): LoginResult

    suspend fun generateEnterToken(account: Account): String
}
