plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:quarkus-camel-bom:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-mongodb-rest-data-panache")
    implementation("io.quarkus:quarkus-mongodb-panache")
    implementation("org.apache.camel.quarkus:camel-quarkus-mongodb")
    implementation("io.quarkus:quarkus-mongodb-panache-kotlin")
    implementation("io.quarkus:quarkus-arc")
    testImplementation("io.quarkus:quarkus-junit5")
}

group = "io.truthencode"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
