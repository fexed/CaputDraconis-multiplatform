plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../Caput_Draconis/Podfile")
        framework {
            baseName = "expelliarmus"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            resources.srcDir("src/commonMain/assets")

            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                // FIRE STORE
                implementation("co.touchlab:firestore:0.2.5")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            resources.srcDir("src/commonMain/assets")
            dependsOn(commonMain)
            //iosTest.dependsOn(this)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        //val iosTest by getting
    }
}

android {
    namespace = "com.fexed.caputdraconis"
    compileSdk = 33
    sourceSets {
        named("main") {
            assets.srcDir("src/commonMain/assets")
        }
    }
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}