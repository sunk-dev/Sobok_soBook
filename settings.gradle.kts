pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url =  "https://jitpack.io" )
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")

    }
}

rootProject.name = "SOBOKSOBOOK"
include(":app")
 