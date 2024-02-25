plugins {
    alias(libs.plugins.kotlin.jvm)

    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)

    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

group = "org.teamfinder.api"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":database"))
    implementation(project(":web:jwt"))
    implementation(project(":web:schema"))
    implementation(project(":web:security"))

    // PLATFORM DEPENDENCIES
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)

    // COROUTINES DEPENDENCIES
    implementation(libs.kotlin.coroutine.core)
    implementation(libs.kotlin.coroutine.reactive)
    implementation(libs.kotlin.coroutine.reactor)

    // SPRING DEPENDENCIES
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.starer.web)
    implementation(libs.spring.starer.security)
    implementation(libs.spring.starer.actuator)
    runtimeOnly(libs.spring.devtools)

    // EXPOSED DEPENDENCIES
    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)

    // GRAPHQL DEPENDENCIES
    implementation(libs.graphql.kickstart.starer)
    implementation(libs.graphql.kickstart.tools)
    implementation(libs.graphql.validation)
    implementation(libs.jackson.module)
}
