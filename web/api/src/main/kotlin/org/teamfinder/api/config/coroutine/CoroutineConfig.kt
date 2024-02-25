package org.teamfinder.api.config.coroutine

import graphql.kickstart.tools.CoroutineContextProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import org.apache.commons.lang3.concurrent.BasicThreadFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

@Configuration
class CoroutineConfig {
    @Bean
    fun resolverDispatcher(): CoroutineDispatcher =
        Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors(),
            BasicThreadFactory.Builder()
                .namingPattern("coroutine-thread-%d")
                .daemon(true)
                .build()
        ).asCoroutineDispatcher()

    @Bean
    fun coroutineContextProvider(resolverDispatcher: CoroutineDispatcher): CoroutineContextProvider =
        object : CoroutineContextProvider {
            override fun provide(): CoroutineContext {
                return resolverDispatcher
            }
        }
}
