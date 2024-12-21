plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(23)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-crypto:5.7.1")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
//	implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
//	testImplementation("ch.qos.logback:logback-classic:1.4.14")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
