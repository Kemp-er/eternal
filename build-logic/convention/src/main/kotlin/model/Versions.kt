package model

import extension.findVersionOrThrow
import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.VersionCatalog

class Versions(catalog: VersionCatalog) {
    val composeCompiler: String = catalog.findVersionOrThrow("composeCompiler")
    val minSdk: Int = catalog.findVersionOrThrow("minSdk").toInt()
    val compileSdk: Int = catalog.findVersionOrThrow("compileSdk").toInt()
    val targetSdk: Int = catalog.findVersionOrThrow("targetSdk").toInt()

    val sourceCompatibility: JavaVersion =
        JavaVersion.toVersion(catalog.findVersionOrThrow("sourceCompatibility"))
    val targetCompatibility: JavaVersion =
        JavaVersion.toVersion(catalog.findVersionOrThrow("targetCompatibility"))
    val jdk: JavaVersion =
        JavaVersion.toVersion(catalog.findVersionOrThrow("jdk"))
}
