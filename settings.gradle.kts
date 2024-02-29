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
    ":database:exposed",
    ":database:jooq",
    ":database:jooq:custom-generation-strategy",
    ":database:jpa",
    ":database:jpa:repository"
)
include(":web", ":web:api", ":web:jwt", ":web:schema", ":web:security", ":web:security:validator")
