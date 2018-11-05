plugins {
    application
    java
}

application {
    mainClassName = "com.websigni.mars.MarsRoversAppMain"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.named<Jar>("jar") {
    manifest.attributes(mapOf(
        "Implementation-Title" to "Mars Rovers Challenge",
        "Main-Class" to "com.websigni.mars.MarsRoversAppMain"
    ))
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