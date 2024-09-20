plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.product.navigation"
}

dependencies {
    implementation(project(":feature:product:presentation:list"))
    implementation(project(":feature:product:presentation:detail"))

    implementation(libs.androidx.navigation.common.ktx)
}
