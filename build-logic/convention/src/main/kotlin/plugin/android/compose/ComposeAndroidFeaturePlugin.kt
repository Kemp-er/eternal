package plugin.android.compose

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import plugin.android.AndroidLibraryPlugin

class ComposeAndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<AndroidLibraryPlugin>()
        apply<ComposeAndroidLibraryPlugin>()
    }
}
