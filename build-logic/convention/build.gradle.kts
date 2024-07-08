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
        register("android-application-plugin") {
            id = "uhit.android.application"
            implementationClass = "plugin.android.AndroidApplicationPlugin"
        }

        register("android-library-plugin") {
            id = "uhit.android.library"
            implementationClass = "plugin.android.AndroidLibraryPlugin"
        }

        register("kotlin-library-plugin") {
            id = "uhit.kotlin.library"
            implementationClass = "plugin.KotlinLibraryPlugin"
        }

        register("compose-android-feature-application") {
            id = "uhit.compose.application"
            implementationClass = "plugin.android.compose.ComposeAndroidApplicationPlugin"
        }

        register("compose-android-feature-library") {
            id = "uhit.compose.library"
            implementationClass = "plugin.android.compose.ComposeAndroidLibraryPlugin"
        }

        register("compose-android-feature-plugin") {
            id = "uhit.compose.feature"
            implementationClass = "plugin.android.compose.ComposeAndroidFeaturePlugin"
        }

        register("code-quality-plugin") {
            id = "uhit.code.quality"
            implementationClass = "plugin.CodeQualityPlugin"
        }

        register("hilt-plugin") {
            id = "uhit.hilt"
            implementationClass = "plugin.android.HiltPlugin"
        }
    }
}
