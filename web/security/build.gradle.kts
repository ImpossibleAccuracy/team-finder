plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.teamfinder.api.security"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":web:jwt"))
    implementation(project(":database"))

    // COROUTINES DEPENDENCIES
    implementation(libs.kotlin.coroutine.core)
    implementation(libs.kotlin.coroutine.reactive)
    implementation(libs.kotlin.coroutine.reactor)

    // SPRING DEPENDENCIES
    implementation(libs.spring.starter.web)
    implementation(libs.spring.starter.security)

    // GRAPHQL DEPENDENCIES
    implementation(libs.graphql.kickstart.starter)
}
