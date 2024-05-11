plugins {
    java
    checkstyle
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.ec4j.editorconfig") version "0.1.0"
}


group = "com.hat.hereandthere"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// [editorconfig]
editorconfig {
    excludes = listOf("build")
}

tasks.check {
    dependsOn("editorconfigCheck")
}

// [checkstyle]
checkstyle {
    maxWarnings = 0
    configFile = file("${rootDir}/config/checkstyle-rules.xml")
    configProperties = mapOf("suppressionFile" to "${rootDir}/config/checkstyle-suppressions.xml")
    toolVersion = "10.13.0"
}

