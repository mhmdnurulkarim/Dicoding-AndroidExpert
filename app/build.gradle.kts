plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtools.ksp)
    id("kotlin-parcelize")
}

android {
    namespace = "com.mhmdnurulkarim.githubuser"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mhmdnurulkarim.githubuser"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    dynamicFeatures += setOf(":favorite")
    buildToolsVersion = "35.0.0"
}

dependencies {
    implementation(project(":core"))

    //Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(platform(libs.kotlin.bom))

    //UnitTest
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Glide
    implementation(libs.glide)
    implementation(libs.circleimageview)

    //Coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    //Injection: Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    ksp(libs.koin.ksp.compiler)

    //LeakCanary
    debugImplementation(libs.leakcanary.android)
    implementation(libs.leakcanary.deobfuscation.gradle.plugin)
}