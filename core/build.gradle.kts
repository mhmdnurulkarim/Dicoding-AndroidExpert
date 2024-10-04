plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
//    id("com.squareup.leakcanary.deobfuscation")
}

//leakCanary {
//    // LeakCanary needs to know which variants have obfuscation turned on
//    filterObfuscatedVariants { variant ->
//        variant.name == "debug"
//    }
//}

android {
    namespace = "com.mhmdnurulkarim.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        buildConfigField("String", "API_KEY", "\"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\"")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
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
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.androidx.constraintlayout)
    implementation(platform(libs.kotlin.bom))

    testApi(libs.junit)
    androidTestApi(libs.androidx.junit)
    androidTestApi(libs.androidx.espresso.core)

    api(libs.androidx.activity.ktx)
    api(libs.androidx.fragment.ktx)

    //Coroutine
    api (libs.kotlinx.coroutines.core)
    api (libs.kotlinx.coroutines.android)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.livedata.ktx)
    api (libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.navigation.fragment.ktx)
    api(libs.androidx.navigation.ui.ktx)

    //Injection: Koin
    api(libs.koin.core)
    api(libs.koin.android)
    ksp(libs.koin.ksp.compiler)

    //Retrofit
    api(libs.retrofit)
    api(libs.converter.gson)
    api(libs.logging.interceptor)
    implementation(libs.okhttp)

    //Room
    api(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //DataStore
    api(libs.androidx.datastore.preferences)

    //Glide
    api(libs.glide)
    api(libs.circleimageview)

    //LeakCanary
    debugApi(libs.leakcanary.android)
    api(libs.leakcanary.deobfuscation.gradle.plugin)

    //Database Encryption
    implementation(libs.android.database.sqlcipher)
    implementation(libs.androidx.sqlite.ktx)
}