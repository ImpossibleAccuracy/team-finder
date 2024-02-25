package org.teamfinder.api.security.context

import graphql.kickstart.execution.subscriptions.SubscriptionSession
import graphql.kickstart.execution.subscriptions.apollo.ApolloSubscriptionConnectionListener
import graphql.kickstart.execution.subscriptions.apollo.OperationMessage
import graphql.kickstart.spring.GraphQLSpringContext
import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebfluxContextBuilder
import graphql.kickstart.spring.webflux.GraphQLSpringWebSocketSessionContext
import graphql.kickstart.spring.webflux.ReactiveWebSocketSubscriptionSession
import graphql.kickstart.spring.webflux.apollo.ReactiveApolloSubscriptionSession
import kotlinx.coroutines.runBlocking
import org.springframework.http.HttpHeaders
import org.springframework.security.core.Authentication
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.web.server.ServerWebExchange

class SecuredContextBuilder(
    private val authorize: suspend (String) -> Authentication?
) : DefaultGraphQLSpringWebfluxContextBuilder(), ApolloSubscriptionConnectionListener {

    companion object {
        private const val HTTP_HEADERS_AUTH_TOKEN_NAME = "Authorization"
        private const val APOLLO_AUTH_TOKEN_NAME = "authToken"
        private const val PRE_AUTHORIZED_AUTHENTICATION = "PRE_AUTHORIZED_AUTHENTICATION"
    }

    private val OperationMessage?.authToken: String?
        get() = (this?.payload as? Map<*, *>)?.let {
            (it[HTTP_HEADERS_AUTH_TOKEN_NAME] ?: it[APOLLO_AUTH_TOKEN_NAME]) as? String
        }

    private val WebSocketSession?.authToken: String?
        get() = this?.handshakeInfo?.headers?.get(HttpHeaders.AUTHORIZATION)?.firstOrNull()


    //******************************************************************************************************************
    //                                      Web Socket Authentication
    //******************************************************************************************************************
    override fun onConnect(session: SubscriptionSession, message: OperationMessage) {
        val token = message.authToken ?: when (session) {
            is ReactiveApolloSubscriptionSession ->
                session.unwrap().authToken

            is ReactiveWebSocketSubscriptionSession ->
                session.unwrap().authToken

            else -> null
        }

        if (token != null) {
            val authentication = runBlocking {
                authorize(token)
            }

            session.userProperties[PRE_AUTHORIZED_AUTHENTICATION] = authentication
        }
    }

    override fun build(webSocketSession: WebSocketSession): GraphQLSpringWebSocketSessionContext {
        val authentication = webSocketSession.attributes[PRE_AUTHORIZED_AUTHENTICATION]
                as? Authentication

        return GraphQLSpringWebSocketSessionScope(webSocketSession) {
            authentication
        }
    }

    //******************************************************************************************************************
    //                                      HTTP Authentication
    //******************************************************************************************************************

    override fun build(serverWebExchange: ServerWebExchange): GraphQLSpringContext =
        GraphQLSpringServerWebExchangeScope(serverWebExchange) {
            serverWebExchange.request.headers.getFirst(HttpHeaders.AUTHORIZATION)?.let {
                authorize(it)
            }
        }
}
