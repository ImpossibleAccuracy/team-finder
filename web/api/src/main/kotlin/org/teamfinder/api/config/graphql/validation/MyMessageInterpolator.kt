package org.teamfinder.api.config.graphql.validation

import graphql.GraphQLError
import graphql.validation.interpolation.MessageInterpolator
import graphql.validation.rules.ValidationEnvironment
import org.springframework.stereotype.Component

@Component
class MyMessageInterpolator : MessageInterpolator {
    override fun interpolate(
        message: String,
        messageParams: MutableMap<String, Any>,
        validationEnvironment: ValidationEnvironment
    ): GraphQLError {

        val location = validationEnvironment.location
        val argumentName = validationEnvironment.argument.name
        val messageWithArgumentName = String.format(message, argumentName)

        return GraphQLError.newError()
            .message(messageWithArgumentName)
            .location(location)
            .build()
    }
}
