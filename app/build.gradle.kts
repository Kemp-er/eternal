plugins {
    id("uhit.android.application")
    id("uhit.code.quality")
    //id("uhit.compose")
}

if (file("google-services.json").exists()) {
    plugins {
        alias(libs.plugins.google.services)
        alias(libs.plugins.google.crashlytics)
    }
}

android {
    namespace = "com.ecardero.eternal"
    defaultConfig {
        applicationId = "com.ecardero.eternal"
        versionCode = 1
        versionName = "1.0"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary = true
//        }
    }

    buildTypes {
//        release {
//            isMinifyEnabled = true
//            isShrinkResources = true
//            isDebuggable = false
//            enableUnitTestCoverage = true
//            enableAndroidTestCoverage = true
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs.findByName("release")
//
//            manifestPlaceholders["enableCrashReporting"] = true
//            buildConfigField("long", "FIREBASE_FETCH_INTERVAL", "${TimeUnit.HOURS.toSeconds(1)}L")
//        }
//        debug {
//            isMinifyEnabled = false
//            isShrinkResources = false
//            isDebuggable = true
//            enableUnitTestCoverage = false
//            enableAndroidTestCoverage = false
//            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs.getByName("debug")
//
//            manifestPlaceholders["enableCrashReporting"] = true
//            buildConfigField("long", "FIREBASE_FETCH_INTERVAL", "${TimeUnit.HOURS.toSeconds(10)}L")
//        }
    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//
//    hilt {
//        enableAggregatingTask = true
//    }
//
//    buildFeatures {
//        compose = true
//    }
//
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }

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

dependencies {

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // DI
    implementation(libs.bundles.hilt)
    ksp(libs.bundles.hilt.ksp)

    // UI
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Network
//    implementation(libs.bundles.ktor)

    // Debug
    implementation(libs.logger)
    implementation(libs.timber)
    debugImplementation(libs.leakcanary)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
