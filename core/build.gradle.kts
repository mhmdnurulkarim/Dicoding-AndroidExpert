plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtools.ksp)
    id("kotlin-parcelize")
}

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
    buildToolsVersion = "35.0.0"
}

dependencies {
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

    //Coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //Injection: Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    ksp(libs.koin.ksp.compiler)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)

    //Room
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //DataStore
    implementation(libs.androidx.datastore.preferences)

    //Glide
    implementation(libs.glide)
    implementation(libs.circleimageview)

    //LeakCanary
    debugImplementation(libs.leakcanary.android)
    implementation(libs.leakcanary.deobfuscation.gradle.plugin)

    //Database Encryption
    implementation(libs.android.database.sqlcipher)
    implementation(libs.androidx.sqlite.ktx)
}