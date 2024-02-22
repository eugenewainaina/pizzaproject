import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication


plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.serialization.plugin)
}

group = "com.example.pizzaproject"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
        }
    }
}

kotlin {
    configAsKobwebApplication("pizzaproject", includeServer = true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.kotlinx.serialization)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(libs.silk.icons.fa)
                implementation(libs.kobwebx.markdown)

                // for Kotlin Bootstrap
                implementation("com.github.stevdza-san:KotlinBootstrap:0.1.0")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.kobweb.api)

                // added
                implementation(libs.kotlinx.serialization)
                implementation("org.jetbrains.exposed:exposed-core:0.44.1")
                implementation("org.jetbrains.exposed:exposed-dao:0.44.1")
                implementation("org.jetbrains.exposed:exposed-jdbc:0.44.1")
                implementation("mysql:mysql-connector-java:8.0.33")

                implementation("org.jetbrains.exposed:exposed-kotlin-datetime:0.44.1")

                // implementation("dev.gitlive:firebase-firestore:1.11.1")
            }
        }
    }
}
