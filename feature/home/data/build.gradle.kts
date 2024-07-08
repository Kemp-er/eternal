plugins {
    id("uhit.android.library")
}

android {
    namespace = "com.eternal.home.data"
}

dependencies {
    implementation(project(":core:feature:data"))
}
