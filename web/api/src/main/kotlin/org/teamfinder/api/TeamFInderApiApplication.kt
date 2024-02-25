package org.teamfinder.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ConfigurationPropertiesScan("org.teamfinder.api", "org.springframework.boot.autoconfigure.graphql")
@ComponentScan("org.teamfinder.api.*")
class RestApiApplication

fun main(args: Array<String>) {
    runApplication<RestApiApplication>(*args)
}
