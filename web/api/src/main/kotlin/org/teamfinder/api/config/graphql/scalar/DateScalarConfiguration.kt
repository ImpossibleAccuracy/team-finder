package org.teamfinder.api.config.graphql.scalar

import graphql.GraphQLContext
import graphql.execution.CoercedVariables
import graphql.language.StringValue
import graphql.language.Value
import graphql.schema.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.format.DateTimeParseException
import java.util.*

@Configuration
class DateScalarConfiguration {
    @Bean
    fun dateScalar(): GraphQLScalarType =
        GraphQLScalarType.newScalar()
            .name("Date")
            .description("Date without time")
            .coercing(object : Coercing<LocalDate, String> {
                override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String =
                    (dataFetcherResult as? LocalDate)?.toString()
                        ?: throw CoercingSerializeException("Expected a LocalDate object")

                override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): LocalDate {
                    if (input !is String) {
                        throw CoercingParseValueException("Expected a String")
                    }

                    return parseString(input)
                        ?: throw CoercingParseValueException("Not a valid date: \"$input\".")
                }

                override fun parseLiteral(
                    input: Value<*>,
                    variables: CoercedVariables,
                    graphQLContext: GraphQLContext,
                    locale: Locale
                ): LocalDate {
                    if (input !is StringValue) {
                        throw CoercingParseLiteralException("Expected a StringValue")
                    }

                    return parseString(input.value)
                        ?: throw CoercingParseLiteralException("Not a valid date: \"$input\".")
                }
            }).build()

    private fun parseString(value: String): LocalDate? =
        try {
            LocalDate.parse(value)
        } catch (_: DateTimeParseException) {
            null
        }
}
