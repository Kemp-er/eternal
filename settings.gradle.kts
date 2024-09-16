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
include(":showcase")

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
    ":feature:news",
    ":feature:home",
)

// Data
include(
    ":feature:splash:data",
    ":feature:register:data",
    ":feature:login:data",
    ":feature:news:data",
    ":feature:home:data",
)

// Domain
include(
    ":feature:splash:domain",
    ":feature:register:domain",
    ":feature:login:domain",
    ":feature:news:domain",
    ":feature:home:domain",
)

// Presentation
include(
    ":feature:splash:presentation",
    ":feature:register:presentation",
    ":feature:login:presentation",
    ":feature:news:presentation:list",
    ":feature:news:presentation:detail",
    ":feature:home:presentation",
)

// Navigation
include(
    ":feature:home:navigation",
)

// Integration
include(
    ":integration:news",
)
