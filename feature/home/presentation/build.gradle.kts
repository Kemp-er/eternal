plugins {
    id("uhit.android.library")
}

android {
    namespace = "com.eternal.home.presentation"
}

dependencies {
    implementation(project(":core:feature:presentation"))
}
