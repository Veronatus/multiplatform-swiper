  plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "lib"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }
        val androidMain by getting {
            dependencies {
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val desktopMain by getting {
            dependencies {
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

mavenPublishing {
    coordinates("io.github.veronatus", "multiplatform-swiper", "0.0.2")

    pom {
        name.set(project.name)
        description.set("A Tinder-like box swiper for Compose Multiplatform")
        inceptionYear.set("2024")
        url.set("https://github.com/veronatus/multiplatform-swiper/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("ezberlin")
                name.set("ezberlin")
                url.set("https://github.com/ezberlin/")
            }
            developer {
                id.set("Daxoza")
                name.set("Daxoza")
                url.set("https://github.com/Daxoza/")
            }
            developer {
                id.set("JakobMattes")
                name.set("JakobMattes")
                url.set("https://github.com/JakobMattes/")
            }
        }
        scm {
            url.set("https://github.com/Veronatus/multiplatform-swiper")
            connection.set("scm:git:git://github.com/Veronatus/multiplatform-swiper.git")
            developerConnection.set("scm:git:ssh://git@github.com/Veronatus/multiplatform-swiper.git")
        }
    }
}
