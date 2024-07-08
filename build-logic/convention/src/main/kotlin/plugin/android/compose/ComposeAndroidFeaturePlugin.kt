package plugin.android.compose

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class ComposeAndroidFeaturePlugin: Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<ComposeAndroidLibraryPlugin>()
    }
}
