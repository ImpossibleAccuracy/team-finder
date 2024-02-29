package org.teamfinder.api.api.resolvers

import org.springframework.stereotype.Service
import org.teamfinder.api.api.controller.auth.AuthController
import org.teamfinder.api.schema.dto.AuthResponseDto
import org.teamfinder.api.schema.resolver.IMutationResolver

@Service
class MutationResolver(
    private val authController: AuthController
) : IMutationResolver {
    override suspend fun isEmailUsed(email: String): Boolean =
        authController.isEmailUsed(email)

    override suspend fun signIn(email: String, password: String): AuthResponseDto =
        authController.signIn(email, password)

    override suspend fun signUp(email: String, password: String): AuthResponseDto =
        authController.signUp(email, password)
}
