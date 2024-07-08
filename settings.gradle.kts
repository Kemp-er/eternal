pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Eternal"
include(":app")

include(
    ":core:shared",
    ":core:designSystem",
    ":core:feature:data",
    ":core:feature:domain",
    ":core:feature:presentation",
)

include(
    ":feature:splash",
    ":feature:register",
    ":feature:login",
    ":feature:home",
)

// data
include(
    ":feature:splash:data",
    ":feature:register:data",
    ":feature:login:data",
    ":feature:home:data",
)

// domain
include(
    ":feature:splash:domain",
    ":feature:register:domain",
    ":feature:login:domain",
    ":feature:home:domain",
)

// presentation
include(
    ":feature:splash:presentation",
    ":feature:register:presentation",
    ":feature:login:presentation",
    ":feature:home:presentation",
)
