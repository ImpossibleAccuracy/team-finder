plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.teamfinder.api.jwt"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.jjwt.api)
    implementation(libs.jjwt.impl)
    implementation(libs.jjwt.jackson)
}
