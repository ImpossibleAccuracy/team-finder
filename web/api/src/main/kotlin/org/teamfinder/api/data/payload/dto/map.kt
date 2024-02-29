package org.teamfinder.api.data.payload.dto

import org.teamfinder.api.schema.dto.AccountDto
import org.teamfinder.data.account.Account

//fun LoginResult.toDto(): AuthResponseDto =
//    AuthResponseDto(
//        id = this.id,
//        email = this.email,
//        token = this.token
//    )

fun Account.toDto(): AccountDto =
    AccountDto(
        id = pk,
        createdAt = createdAt,
        email = email
    )
