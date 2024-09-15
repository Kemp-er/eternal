package plugin.android

import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply {
            plugin(libs.findPluginOrThrow("jetbrains.kotlin.android").get().pluginId)
            plugin(libs.findPluginOrThrow("google.hilt").get().pluginId)
//            plugin(libs.findPluginOrThrow("ksp").get().pluginId)
        }

        dependencies {
            add("implementation", libs.findBundle("hilt").get())
            add("ksp", libs.findBundle("hilt-ksp").get())
        }
    }
}
