package org.teamfinder.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@ConfigurationPropertiesScan("org.teamfinder.api", "org.springframework.boot.autoconfigure.graphql")
@ComponentScan("org.teamfinder.*")
@EnableJpaRepositories("org.teamfinder.data")
@EntityScan("org.teamfinder.data")
class RestApiApplication

fun main(args: Array<String>) {
    runApplication<RestApiApplication>(*args)
}
