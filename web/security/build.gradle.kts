plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.teamfinder.api.security"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":web:jwt"))
    implementation(project(":database"))

    implementation(libs.spring.starer.web)
    implementation(libs.spring.starer.security)

    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)

    implementation(libs.graphql.kickstart.starer)
}
