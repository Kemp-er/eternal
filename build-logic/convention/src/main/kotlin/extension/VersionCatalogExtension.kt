package extension

import model.Versions
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

internal val Project.libs: VersionCatalog
    get() = getVersionCatalog()

private fun Project.getVersionCatalog(
    name: String = "libs",
): VersionCatalog = extensions
    .getByType<VersionCatalogsExtension>()
    .named(name)

internal fun VersionCatalog.findLibraryOrThrow(
    name: String,
): Provider<MinimalExternalModuleDependency> = findLibrary(name)
    .orElseThrow { NoSuchElementException("Library $name not found in version catalog") }

internal fun VersionCatalog.findVersionOrThrow(
    version: String,
): String = findVersion(version)
    .orElseThrow { NoSuchElementException("Version $version not found in version catalog") }
    .requiredVersion

internal fun VersionCatalog.findPluginOrThrow(
    name: String,
): Provider<PluginDependency> = findPlugin(name)
    .orElseThrow { NoSuchElementException("Plugin $name not found in version catalog") }

internal val VersionCatalog.versions: Versions
    get() = Versions(this)