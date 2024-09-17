plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.feature.news.presentation.detail"
}

dependencies {
    implementation(project(":core:feature:presentation"))
}
