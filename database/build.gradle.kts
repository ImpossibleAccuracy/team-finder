plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.teamfinder.data"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao)
    implementation(libs.exposed.datetime)

    implementation(libs.mysql.connector)

    testImplementation(libs.kotlin.test)
}
