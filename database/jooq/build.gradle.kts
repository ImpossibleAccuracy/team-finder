import nu.studer.gradle.jooq.JooqEdition
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jooq.gradle)
    alias(libs.plugins.spring.dependency.management)
}

group = "org.teamfinder.data"
version = "1.0-SNAPSHOT"

jooq {
    version.set("3.19.0")
    edition = JooqEdition.OSS

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation = true

            jooqConfiguration.apply {
                logging = Logging.WARN

                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"

                    strategy.apply {
                        name = "org.teamfinder.data.TableGeneratorStrategy"
                    }

                    generate.apply {
                        isRelations = true
                        isDeprecated = false
                        isRecords = false
                        isImmutablePojos = true
                        isPojosEqualsAndHashCode = true
                        isPojosAsKotlinDataClasses = true
                        isKotlinNotNullPojoAttributes = true
                        isFluentSetters = true
                        isDaos = false
                        isJavaTimeTypes = true
                    }

                    target.apply {
                        packageName = group.toString()
                    }

                    database.apply {
                        name = "org.jooq.meta.extensions.ddl.DDLDatabase"

                        properties.apply {
                            add(Property().apply {
                                key = "scripts"
                                value = "src/main/resources/database.sql"
                            })

                            add(Property().apply {
                                key = "sort"
                                value = "semantic"
                            })

                            add(Property().apply {
                                key = "unqualifiedSchema"
                                value = "none"
                            })

                            // The default name case for unquoted objects:
                            //
                            // - as_is: unquoted object names are kept unquoted
                            // - upper: unquoted object names are turned into upper case (most databases)
                            // - lower: unquoted object names are turned into lower case (e.g. PostgreSQL)
                            add(Property().apply {
                                key = "defaultNameCase"
                                value = "as_is"
                            })
                        }
                    }
                }
            }
        }
    }
}

dependencies {
    jooqGenerator(project(":database:jooq:custom-generation-strategy"))

    jooqGenerator(libs.jooq)
    jooqGenerator(libs.jooq.meta)
    jooqGenerator(libs.jooq.meta.extensions)
    jooqGenerator(libs.jooq.codegen)

    implementation(libs.jooq)
    implementation(libs.jooq.codegen)
    implementation(libs.jooq.kotlin)
    implementation(libs.jooq.kotlin.coroutines)

    testImplementation(libs.kotlin.test)
}
