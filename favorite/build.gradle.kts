plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.mhmdnurulkarim.favorite"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":app"))
}