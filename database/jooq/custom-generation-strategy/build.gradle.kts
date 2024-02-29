plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

group = "org.teamfinder.data"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(libs.jooq)
    implementation(libs.jooq.codegen)
}
