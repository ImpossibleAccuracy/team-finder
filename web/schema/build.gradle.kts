import io.github.ermadmi78.kobby.kobby

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kobby)
}

group = "org.teamfinder.api.schema"
version = "0.0.1-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

kobby {
    schema {
        files = null

        scan {
            dir = "src/main/resources"

            includes = listOf("**/*.graphqls")
        }
    }

    kotlin {
        packageName = group as String

        scalars = mapOf(
            "Date" to typeOf("java.time", "LocalDate"),
            "DateTime" to typeOf("java.time", "LocalDateTime")
        )
    }
}

dependencies {
    // PLATFORM DEPENDENCIES
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)

    implementation(libs.jackson.annotations)
    implementation(libs.graphql.kickstart.tools)
    implementation(libs.reactive.streams)
}
