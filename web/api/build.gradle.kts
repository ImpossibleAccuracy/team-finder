plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "org.teamfinder.api"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":database:jpa"))
    implementation(project(":database:jpa:repository"))
    implementation(project(":web:jwt"))
    implementation(project(":web:schema"))
    implementation(project(":web:security"))

    // PLATFORM DEPENDENCIES
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.serialization)

    // COROUTINES DEPENDENCIES
    implementation(libs.kotlin.coroutine.core)
    implementation(libs.kotlin.coroutine.reactive)
    implementation(libs.kotlin.coroutine.reactor)

    // SPRING DEPENDENCIES
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.starter.web)
    implementation(libs.spring.starter.security)
    implementation(libs.spring.starter.jpa)
    implementation(libs.spring.starter.actuator)
    runtimeOnly(libs.spring.devtools)

    // GRAPHQL DEPENDENCIES
    implementation(libs.graphql.kickstart.starter)
    implementation(libs.graphql.kickstart.tools)
    implementation(libs.graphql.validation)
    implementation(libs.reactive.streams)

    // TESTS
    testImplementation(libs.kotlin.test)
    testImplementation(libs.spring.test)
    testImplementation(libs.h2.connector)
    testImplementation(libs.junit.api)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.params)
    testRuntimeOnly(libs.junit.engine.jupiter)
}
