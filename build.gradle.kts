plugins {
    id("base")

    alias(libs.plugins.kotlin.jvm)
}

allprojects {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

group = "org.teamfinder"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}
