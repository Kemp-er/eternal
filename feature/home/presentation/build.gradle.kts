plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.home.presentation"
}

dependencies {
    implementation(project(":core:feature:presentation"))
}
