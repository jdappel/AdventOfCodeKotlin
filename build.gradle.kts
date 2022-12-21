plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    maven {
        url = uri("https://artifacts-read.gkp.jpmchase.net/artifactory/maven")
    }
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }

    wrapper {
        gradleVersion = "7.6"
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
