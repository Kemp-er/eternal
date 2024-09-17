plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.home.navigation"
}

dependencies {
    implementation(project(":feature:home:presentation"))

    implementation(libs.androidx.navigation.common.ktx)
}
