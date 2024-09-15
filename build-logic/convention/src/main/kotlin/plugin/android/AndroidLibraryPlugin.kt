package plugin.android

import com.android.build.api.dsl.LibraryExtension
import com.ecardero.eternal.configureKotlinAndroid
import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import plugin.CodeQualityPlugin

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply {
            plugin(libs.findPluginOrThrow("android.library").get().pluginId)
            plugin(libs.findPluginOrThrow("jetbrains.kotlin.android").get().pluginId)
            plugin(libs.findPluginOrThrow("ksp").get().pluginId)
        }
        apply<HiltPlugin>()
        apply<CodeQualityPlugin>()

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
        }

        dependencies {
            add("implementation", libs.findBundle("hilt").get())
            add("ksp", libs.findBundle("hilt-ksp").get())
        }
    }
}
