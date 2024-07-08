package plugin.android.compose

import com.android.build.api.dsl.ApplicationExtension
import com.ecardero.eternal.configureCompose
import extension.findLibraryOrThrow
import extension.findPluginOrThrow
import extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ComposeAndroidApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply {
            plugin(libs.findPluginOrThrow("jetbrains.kotlin.android").get().pluginId)
            plugin(libs.findPluginOrThrow("compose.compiler").get().pluginId)
        }

        extensions.configure<ApplicationExtension> {
            configureCompose(this)
        }

        dependencies {
            add("implementation", platform(libs.findLibraryOrThrow("androidx-compose-bom").get()))
            add("implementation", libs.findBundle("compose").get())
        }
    }
}
