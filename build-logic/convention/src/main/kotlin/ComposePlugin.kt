import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply {
            plugin(libs.findPluginOrThrow("jetbrains.kotlin.android").get().pluginId)
            plugin(libs.findPluginOrThrow("compose.compiler").get().pluginId)
        }
    }
}
