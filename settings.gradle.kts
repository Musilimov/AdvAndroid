pluginManagement {
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
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/Musilimov/AdvAndroid")
            credentials {
                username = "Musilimov"
                password = "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"
            }
        }
    }
}

rootProject.name = "ChatLibraryProject"
include(":app")
include(":chatlibrary")
