plugins {
    application
}

application {
    mainClassName = "samples.HelloWorld"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    testCompile("junit:junit:4.12")
    testCompile("org.assertj:assertj-core:3.11.1")
}

repositories {
    jcenter()
}