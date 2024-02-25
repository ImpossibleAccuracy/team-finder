package org.teamfinder.api.security.context

import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebSocketSessionContext
import kotlinx.coroutines.CoroutineScope
import org.springframework.security.core.Authentication
import org.springframework.web.reactive.socket.WebSocketSession

class GraphQLSpringWebSocketSessionScope(
    webSocketSession: WebSocketSession,
    provider: suspend () -> Authentication? = { null }
) : DefaultGraphQLSpringWebSocketSessionContext(webSocketSession),
    CoroutineScope by CoroutineScope(AuthenticationContext(provider))
