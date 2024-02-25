package org.teamfinder.api.api.security

import graphql.kickstart.spring.webflux.GraphQLSpringWebfluxContextBuilder
import org.springframework.boot.autoconfigure.graphql.GraphQlCorsProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import org.teamfinder.api.security.auth.SecurityService
import org.teamfinder.api.security.auth.createContextBuilder


@Configuration
@EnableWebFluxSecurity
class SecurityConfig(
    private val corsProperties: GraphQlCorsProperties
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder =
        BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
        http
            .csrf {
                it.disable()
            }
            .cors {
                it.configurationSource {
                    val source = UrlBasedCorsConfigurationSource()
                    val config = CorsConfiguration()

                    config.allowCredentials = corsProperties.allowCredentials
                    config.allowedMethods = corsProperties.allowedMethods
                    config.allowedOrigins = corsProperties.allowedOrigins
                    config.allowedOriginPatterns = corsProperties.allowedOriginPatterns
                    config.exposedHeaders = corsProperties.exposedHeaders

                    config.addAllowedHeader("*")

                    source.registerCorsConfiguration("/**", config)

                    config
                }
            }
            .authorizeExchange {
                // TODO: fix
                it.anyExchange().permitAll()
//                it.pathMatchers("/subscriptions").permitAll()
//                it.pathMatchers("/graphql").permitAll()

//                it.anyExchange().authenticated()
            }
            .httpBasic {
                it.disable()
            }
            .formLogin {
                it.disable()
            }
            .build()

    @Bean
    fun contextBuilder(securityService: SecurityService): GraphQLSpringWebfluxContextBuilder =
        createContextBuilder(securityService)
}
