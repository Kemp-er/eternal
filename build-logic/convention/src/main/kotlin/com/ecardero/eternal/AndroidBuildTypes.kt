package com.ecardero.eternal

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project

internal fun Project.configureAndroidBuildTypes(
    appModuleExtension: BaseAppModuleExtension,
) {
    appModuleExtension.apply {
        buildTypes {
            release {
                isMinifyEnabled = true
                isShrinkResources = true
                isDebuggable = false
                enableUnitTestCoverage = true
                enableAndroidTestCoverage = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                signingConfig = signingConfigs.findByName("release")

                manifestPlaceholders["enableCrashReporting"] = true
//            buildConfigField("long", "FIREBASE_FETCH_INTERVAL", "${TimeUnit.HOURS.toSeconds(1)}L") // Extract to firebase plugin
            }
            debug {
                isMinifyEnabled = false
                isShrinkResources = false
                isDebuggable = true
                enableUnitTestCoverage = false
                enableAndroidTestCoverage = false
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                signingConfig = signingConfigs.getByName("debug")

                manifestPlaceholders["enableCrashReporting"] = true
//            buildConfigField("long", "FIREBASE_FETCH_INTERVAL", "${TimeUnit.HOURS.toSeconds(10)}L") // Extract to firebase plugin
            }
        }
    }
}

internal fun Project.configureAndroidEnvironments(
    appModuleExtension: BaseAppModuleExtension,
) {
    appModuleExtension.apply {
        flavorDimensions.add("environment")
        productFlavors {
            create("dev") {
                applicationId = "dev.ecardero.eternal"

                dimension = "environment"
            }

            create("pre") {
                applicationId = "pre.ecardero.eternal"

                dimension = "environment"
            }

            create("pro") {
                applicationId = "com.ecardero.eternal"
                dimension = "environment"
            }
        }
    }
}
