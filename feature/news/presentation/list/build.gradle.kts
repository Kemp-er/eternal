plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.feature.news.presentation.list"
}

dependencies {
    implementation(project(":core:feature:presentation"))
}
