plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.teamfinder.api.security"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":web:security"))
    implementation(project(":database"))
    implementation(project(":database:repository"))

    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)
}
