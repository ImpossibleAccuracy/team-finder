package org.teamfinder.api.security.context

import graphql.kickstart.spring.GraphQLSpringServerWebExchangeContext
import kotlinx.coroutines.CoroutineScope
import org.springframework.security.core.Authentication
import org.springframework.web.server.ServerWebExchange

class GraphQLSpringServerWebExchangeScope(
    serverWebExchange: ServerWebExchange,
    provider: suspend () -> Authentication? = { null }
) : GraphQLSpringServerWebExchangeContext(serverWebExchange),
    CoroutineScope by CoroutineScope(AuthenticationContext(provider))
