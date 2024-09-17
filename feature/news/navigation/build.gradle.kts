plugins {
    id("uhit.compose.feature")
}

android {
    namespace = "com.eternal.news.navigation"
}

dependencies {
    implementation(project(":feature:news:presentation:list"))
    implementation(project(":feature:news:presentation:detail"))

    implementation(libs.androidx.navigation.common.ktx)
}
