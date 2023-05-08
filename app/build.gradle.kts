group = rootProject.group
version = rootProject.version
java.sourceCompatibility = JavaVersion.VERSION_17

val kotlinVersion: String by project
val kordVersion: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/ya0igoddess/skaard")
        credentials {
            username = System.getenv("USERNAME")
            password = System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    //skaard dependencies
    implementation("su.skaard:core:0.0.1-SNAPSHOT")
    implementation("su.skaard:channel-presence:0.0.1-SNAPSHOT")

    runtimeOnly("org.postgresql:postgresql:42.3.8")
}


