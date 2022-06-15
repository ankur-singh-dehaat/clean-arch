import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("kotlinAndroidLibraryPlugin") {
            id = "kotlinAndroidLibraryPlugin"
            implementationClass = "ModulePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
}
