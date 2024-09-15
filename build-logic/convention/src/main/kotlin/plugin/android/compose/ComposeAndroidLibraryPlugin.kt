package plugin.android.compose

import com.android.build.api.dsl.LibraryExtension
import com.ecardero.eternal.configureCompose
import extension.findLibraryOrThrow
import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import plugin.CodeQualityPlugin

class ComposeAndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<CodeQualityPlugin>()

        apply {
            plugin(libs.findPluginOrThrow("jetbrains.kotlin.android").get().pluginId)
            plugin(libs.findPluginOrThrow("kotlin.serialization").get().pluginId)
            plugin(libs.findPluginOrThrow("compose.compiler").get().pluginId)
        }

        extensions.configure<LibraryExtension> {
            configureCompose(this)
        }

        dependencies {
            add("implementation", libs.findLibraryOrThrow("kotlinx-serialization-core").get())
            add("implementation", platform(libs.findLibraryOrThrow("androidx-compose-bom").get()))
            add("implementation", libs.findBundle("compose").get())
        }
    }
}
