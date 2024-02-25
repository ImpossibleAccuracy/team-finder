package org.teamfinder.api.config.graphql.setup

import graphql.execution.AsyncExecutionStrategy
import graphql.execution.ExecutionStrategy
import graphql.execution.SubscriptionExecutionStrategy
import graphql.kickstart.execution.config.ExecutionStrategyProvider
import org.springframework.stereotype.Component
import org.teamfinder.api.data.exception.handler.GraphQlExceptionHandler

@Component
class AsyncExecutionStrategyProvider(
    private val exceptionHandler: GraphQlExceptionHandler
) : ExecutionStrategyProvider {
    override fun getQueryExecutionStrategy(): ExecutionStrategy =
        AsyncExecutionStrategy(exceptionHandler)

    override fun getMutationExecutionStrategy(): ExecutionStrategy =
        AsyncExecutionStrategy(exceptionHandler)

    override fun getSubscriptionExecutionStrategy(): ExecutionStrategy =
        SubscriptionExecutionStrategy(exceptionHandler)
}
