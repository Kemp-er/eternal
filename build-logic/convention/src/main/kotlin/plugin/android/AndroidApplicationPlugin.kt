package plugin.android

import com.android.build.api.dsl.ApplicationExtension
import com.ecardero.eternal.configureKotlinAndroid
import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import plugin.CodeQualityPlugin
import plugin.android.compose.ComposeAndroidApplicationPlugin

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply {
            plugin(libs.findPluginOrThrow("android.application").get().pluginId)
            plugin(libs.findPluginOrThrow("jetbrains.kotlin.android").get().pluginId)
            plugin(libs.findPluginOrThrow("kotlin-serialization").get().pluginId)
            plugin(libs.findPluginOrThrow("ksp").get().pluginId)
        }

        apply<HiltPlugin>()
        apply<ComposeAndroidApplicationPlugin>()
        apply<CodeQualityPlugin>()

        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
        }

        dependencies {
            add("implementation", libs.findBundle("hilt").get())
            add("ksp", libs.findBundle("hilt-ksp").get())
            add("implementation", libs.findLibrary("kotlinx.serialization.json").get())
        }
    }
}
