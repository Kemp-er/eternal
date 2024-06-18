import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AppSpotlessPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<SpotlessPlugin>()

        configure<SpotlessExtension> {
            kotlin {
                target(
                    fileTree(
                        mapOf(
                            "dir" to ".",
                            "include" to listOf("**/*.kt"),
                            "exclude" to listOf("**/build/**", "**/buildSrc/**", "**/.*")
                        )
                    )
                )
                licenseHeaderFile(
                    rootProject.file(".spotless/copyright.kt"),
                    "^(package|object|import|interface)"
                )
                trimTrailingWhitespace()
                indentWithSpaces()
                ktlint()
                endWithNewline()
            }

            format("misc") {
                target(
                    fileTree(
                        mapOf(
                            "dir" to ".",
                            "include" to listOf("**/*.md", "**/.gitignore", "**/*.yaml", "**/*.yml"),
                            "exclude" to listOf(
                                ".gradle/**",
                                ".gradle-cache/**",
                                "**/tools/**",
                                "**/build/**"
                            )
                        )
                    )
                )
                trimTrailingWhitespace()
                indentWithSpaces()
                endWithNewline()
            }

            kotlinGradle {
                target(
                    fileTree(
                        mapOf(
                            "dir" to ".",
                            "include" to listOf("**/*.gradle.kts", "*.gradle.kts"),
                            "exclude" to listOf("**/build/**")
                        )
                    )
                )
                licenseHeaderFile(
                    rootProject.file(".spotless/copyright.kt"),
                    "package|import|tasks|apply|plugins|include|val|object|interface"
                )
                trimTrailingWhitespace()
                indentWithSpaces()
                endWithNewline()
                ktlint()
            }

            format("xml") {
                target("**/res/**/*.xml")
                indentWithSpaces(4)
                trimTrailingWhitespace()
                endWithNewline()
            }

            freshmark {
                target("**/*.md")

                endWithNewline()
            }
        }
    }
}