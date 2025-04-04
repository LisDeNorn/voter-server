plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinx.serialization)
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.hasProperty("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven("https://repo.ktor.io")  // Репозиторий для зависимостей Ktor
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.content.negotiation)

    implementation(libs.ktor.server.serialization)
    implementation(libs.kotlinx.serialization.json)
//    implementation("io.ktor:ktor-server-serialization:3.1.0")  // Для сериализации
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")  // Для работы с JSON

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)

    implementation("ru.yandex.clickhouse:clickhouse-jdbc:0.2.6")
    implementation(kotlin("stdlib-jdk8"))


}
kotlin {
    jvmToolchain(17)
}