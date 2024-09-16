package plugin

import com.ecardero.eternal.configureKotlinJvm
import extension.findLibraryOrThrow
import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class KotlinLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply {
            plugin(libs.findPluginOrThrow("kotlin-jvm").get().pluginId)
            plugin(libs.findPluginOrThrow("kotlin-serialization").get().pluginId)
        }

        extensions.configure<JavaPluginExtension> {
            configureKotlinJvm()
        }

        dependencies {
            add("implementation", libs.findLibraryOrThrow("javax.inject").get())
        }
    }
}
