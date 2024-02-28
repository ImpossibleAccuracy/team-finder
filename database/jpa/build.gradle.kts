plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)

    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)

    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.kotlin.allopen)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

group = "org.teamfinder.data"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(libs.kotlin.datetime)

    implementation(libs.spring.starter.jpa)
    implementation(libs.mysql.connector)

    testImplementation(libs.kotlin.test)
}
