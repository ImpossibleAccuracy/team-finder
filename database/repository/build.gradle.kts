plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)

    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

group = "org.teamfinder.data.repo"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":database"))

    implementation(libs.spring.starter.jpa)
    implementation(libs.mysql.connector)

    testImplementation(libs.kotlin.test)
}
