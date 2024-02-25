package org.teamfinder.api.config.graphql.scalar

import graphql.GraphQLContext
import graphql.execution.CoercedVariables
import graphql.language.StringValue
import graphql.language.Value
import graphql.schema.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*


@Configuration
class DateTimeScalarConfiguration {
    companion object {
        private val dateTimeTypes = arrayOf(
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            DateTimeFormatter.ISO_INSTANT
        )
    }

    @Bean
    fun dateTimeScalar(): GraphQLScalarType =
        GraphQLScalarType.newScalar()
            .name("DateTime")
            .description("Date with time")
            .coercing(object : Coercing<LocalDateTime, String> {
                override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String =
                    (dataFetcherResult as? LocalDateTime)?.toString()
                        ?: throw CoercingSerializeException("Expected a LocalDateTime object")

                override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): LocalDateTime {
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
                ): LocalDateTime {
                    if (input !is StringValue) {
                        throw CoercingParseLiteralException("Expected a StringValue")
                    }

                    return parseString(input.value)
                        ?: throw CoercingParseLiteralException("Not a valid date: \"$input\".")
                }
            }).build()

    private fun parseString(value: String): LocalDateTime? {
        for (format in dateTimeTypes) {
            try {
                return LocalDateTime.parse(value, format)
            } catch (e: DateTimeParseException) {
                println(e)
            }
        }

        return null
    }
}
