package org.teamfinder.api.config.token

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.teamfinder.api.jwt.JwtUtils

@Configuration
class TokenConfiguration {
    @Bean
    fun jwtUtils(tokenProperties: TokenProperties) =
        JwtUtils(tokenProperties.secret)
}
