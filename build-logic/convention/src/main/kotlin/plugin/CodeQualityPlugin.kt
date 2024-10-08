package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import plugin.codequality.AppDetektPlugin
import plugin.codequality.AppKtlintPlugin
import plugin.codequality.AppSpotlessPlugin

class CodeQualityPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<AppDetektPlugin>()
        apply<AppKtlintPlugin>()
        apply<AppSpotlessPlugin>()
    }
}
