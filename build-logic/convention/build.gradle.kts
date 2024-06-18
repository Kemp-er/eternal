import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.ecardero.eternal.buildlogic"

java {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.java.get())
    targetCompatibility = JavaVersion.toVersion(libs.versions.java.get())
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = libs.versions.java.get()
    }
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)

    // Static code analysis / Code Quality
    implementation(libs.spotless.plugin)
    implementation(libs.detekt.plugin)
    implementation(libs.ktlint.plugin)
    implementation(libs.gradle.versions.plugin)
}

gradlePlugin {
    plugins {
        register("code-quality-plugin") {
            id = "uhit.code.quality"
            implementationClass = "CodeQualityPlugin"
        }

        register("android-application-plugin") {
            id = "uhit.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }

//        register("android-library-plugin") {
//            id = "uhit.android.library"
//            implementationClass = "AndroidLibraryPlugin"
//        }

        register("compose-plugin") {
            id = "uhit.compose"
            implementationClass = "ComposePlugin"
        }
    }
}
