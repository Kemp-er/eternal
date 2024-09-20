plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.feature.product.presentation.detail"
}

dependencies {
    implementation(project(":core:feature:presentation"))
}
