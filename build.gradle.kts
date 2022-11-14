import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
    id("io.ktor.plugin") version "2.1.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.cdimascio:dotenv-kotlin:6.3.1")
    implementation("net.dv8tion:JDA:5.0.0-alpha.20")
    implementation("ch.qos.logback:logback-classic:1.4.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("com.github.mrtuxa.core.Main")
}

ktor {
    fatJar {
        archiveFileName.set("chicken.jar")
    }
}
