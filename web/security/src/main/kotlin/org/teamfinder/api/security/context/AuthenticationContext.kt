package org.teamfinder.api.security.context

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.springframework.security.core.Authentication
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class AuthenticationContext(
    private val provider: suspend () -> Authentication? = { null }
) : AbstractCoroutineContextElement(AuthenticationContext) {
    companion object Key : CoroutineContext.Key<AuthenticationContext>

    private val mutex = Mutex()
    private var provided = false
    private var authentication: Authentication? = null

    suspend fun getAuthentication(): Authentication? = mutex.withLock {
        if (!provided) {
            authentication = provider()
            provided = true
        }

        authentication
    }
}
