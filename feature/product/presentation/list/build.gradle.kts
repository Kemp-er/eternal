plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.feature.product.presentation.list"
}

dependencies {
    implementation(project(":core:feature:presentation"))
}
