package org.teamfinder.api.jwt

data class Token(
    val subject: String,
    val timeToLive: Long,
    val extras: Map<String, Any>?
) {
    companion object {
        fun build(subject: String, daysToLive: Int, extras: Map<String, Any>?): Token =
            Token(
                subject = subject,
                timeToLive = daysToLive * 1000L * 60 * 60 * 24,
                extras = extras
            )
    }
}
