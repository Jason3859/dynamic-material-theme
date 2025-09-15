import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
}

group = "io.github.jason3859"
version = "1.0.0"

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {

        commonMain.dependencies {
            implementation(compose.material3)
        }

        jvmMain.dependencies {
            implementation(libs.java.jna)
            implementation(libs.material.color.utilities)
        }
    }
}

android {
    namespace = "org.jetbrains.kotlinx.multiplatform.library.template"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(group.toString(), "dynamic-material-theme", version.toString())

    pom {
        name = "Dynamic Material theme for windows and android"
        description =
            "This library contains a function that provides dynamic theme support for both android and windows. This currently doesn't support iOS, macOS or linux"
        inceptionYear = "2025"
        url = "https://github.com/jason3859/dynamic-material-theme/"

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "jason"
                name = "Jason"
                url = "https://github.com/jason3859"
            }
        }
        scm {
            url = "https://github.com/jason3859/dynamic-material-theme"
        }
    }
}
