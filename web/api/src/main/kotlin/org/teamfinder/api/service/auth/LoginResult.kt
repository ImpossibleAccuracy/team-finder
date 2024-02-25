package org.teamfinder.api.service.auth

data class LoginResult(
    val id: Long,
    val email: String,
    val token: String,
)
