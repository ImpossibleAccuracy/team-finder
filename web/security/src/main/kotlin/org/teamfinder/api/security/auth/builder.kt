package org.teamfinder.api.security.auth

import graphql.kickstart.spring.webflux.GraphQLSpringWebfluxContextBuilder
import org.teamfinder.api.security.context.SecuredContextBuilder
import org.teamfinder.api.security.model.AccountAuthentication

fun createContextBuilder(
    authService: SecurityService
): GraphQLSpringWebfluxContextBuilder =
    SecuredContextBuilder { jwt ->
        authService.authUserByRequestToken(jwt)?.let {
            AccountAuthentication(it, jwt, null)
        }
    }
