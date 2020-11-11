import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}
group = "me.reza"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val ktorVersion = "1.4.1"
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")

    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")

    testImplementation(kotlin("test-junit5"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}