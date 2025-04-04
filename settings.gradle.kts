pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    // Подключение libs.versions.toml
    includeBuild("gradle")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "ktor-sample"
