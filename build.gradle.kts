// import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.sonarqube) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.google.hilt) apply false
    alias(libs.plugins.google.crashlytics) apply false
    alias(libs.plugins.ksp) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.spotless.plugin)
    }
}

// subprojects {
//    apply(plugin = "io.gitlab.arturbosch.detekt")
//    afterEvaluate {
//        apply("uhit.code.quality")
//    }
// }
