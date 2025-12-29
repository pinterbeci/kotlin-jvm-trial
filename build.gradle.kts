plugins {
    kotlin("jvm") version "2.0.0"
}

group = "hu.pinterbela.kotlin.documentation"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.6.1")
    implementation(kotlin("stdlib"))
}

tasks.test {
    useJUnitPlatform()
}