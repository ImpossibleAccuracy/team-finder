package org.teamfinder.api.data.model

import org.teamfinder.api.data.exception.items.ResourceNotFoundException
import org.teamfinder.data.model.account.Account
import java.util.*

fun <T> Optional<T>.required(message: String): T =
    orElseThrow {
        ResourceNotFoundException("$message not found")
    }

fun Optional<Account>.required() = required("Account")
