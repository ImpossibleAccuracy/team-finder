pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

rootProject.name = "team-finder"

include(
    ":database",
    ":database:repository"
)

include(
    ":web",
    ":web:api",
    ":web:jwt",
    ":web:schema",
    ":web:security",
    ":web:security:validator"
)
