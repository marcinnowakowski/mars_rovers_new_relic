plugins {
    application
    java
}

application {
    mainClassName = "samples.HelloWorld"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.getByName<Test>("test"){
    testLogging.showStandardStreams = true
}

dependencies {
    testCompile("junit:junit:4.12")
    testCompile("org.assertj:assertj-core:3.11.1")
}

repositories {
    jcenter()
}