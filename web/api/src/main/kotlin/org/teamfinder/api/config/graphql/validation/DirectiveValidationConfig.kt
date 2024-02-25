package org.teamfinder.api.config.graphql.validation

import graphql.validation.rules.OnValidationErrorStrategy
import graphql.validation.rules.ValidationRules
import graphql.validation.schemawiring.ValidationSchemaWiring
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DirectiveValidationConfig {
    @Bean
    fun validationSchemaWiring(): ValidationSchemaWiring =
        ValidationRules.newValidationRules()
            .onValidationErrorStrategy(OnValidationErrorStrategy.RETURN_NULL)
            .build()
            .let {
                ValidationSchemaWiring(it)
            }
}
