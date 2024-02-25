package org.teamfinder.api.config.graphql

import graphql.kickstart.execution.config.ExecutionStrategyProvider
import graphql.kickstart.execution.config.GraphQLBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQlConfiguration {
    @Bean
    fun graphQLBuilder(executionStrategyProvider: ExecutionStrategyProvider): GraphQLBuilder {
        val builder = GraphQLBuilder()

        builder.executionStrategyProvider { executionStrategyProvider }

        return builder
    }
}
