plugins {
    kotlin("jvm") version "2.0.20"
    application // Plugin para rodar o projeto
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

// Configuração da tarefa de execução
application {
    mainClass.set("org.example.MainKt") // Define o ponto de entrada da aplicação
}
