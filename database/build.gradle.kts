plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.teamfinder.data"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.datetime)
    implementation(libs.kotlin.serialization)

    implementation(libs.mysql.connector)
}
