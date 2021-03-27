plugins {
    kotlin("multiplatform") version "1.4.30"
    id("com.android.library")
    kotlin("plugin.serialization") version "1.4.30"
}

group = "me.yuli"
version = "1.0-SNAPSHOT"

repositories {
    google()
    jcenter()
    mavenCentral()
}

kotlin {
    android()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
                //implementation("com.squareup.okhttp3:okhttp:4.9.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val androidMain by getting{
            dependencies {
                implementation("com.squareup.okhttp3:okhttp:4.9.0")
            }
        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}

