plugins {
    id("uhit.android.application")
    id("uhit.code.quality")
}

if (file("google-services.json").exists()) {
    plugins {
        alias(libs.plugins.google.services)
        alias(libs.plugins.google.crashlytics)
    }
}

android {
    namespace = "com.ecardero.eternal.showcase"
    defaultConfig {
        applicationId = "com.ecardero.eternal.showcase"
        versionCode = 1
        versionName = "1.0"
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
