plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.tokisaki.tokisakimatsuri"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tokisaki.tokisakimatsuri"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //retrofit and gson
    implementation(libs.retrofit2.retrofit)
    implementation(libs.converter.gson)

    //logging interceptor
    implementation(libs.logging.interceptor)
//
//    //datastore
//    implementation(libs.androidx.datastore.preferences)
//
//    //lifecycle components
//    implementation(libs.androidx.lifecycle.extensions)
//    implementation(libs.androidx.lifecycle.viewmodel.ktx)
//    implementation(libs.androidx.lifecycle.livedata.ktx)
//    implementation(libs.androidx.lifecycle.common.java8)
//
//    //coroutines
//    implementation(libs.kotlin.stdlib.jdk7)
//    implementation(libs.kotlinx.coroutines.core)
//    implementation(libs.kotlinx.coroutines.android)

    // Preferences DataStore

    implementation(libs.androidx.datastore.preferences)

    // Lifecycle components

    implementation (libs.androidx.lifecycle.livedata.ktx)

    implementation (libs.androidx.lifecycle.extensions)

    implementation (libs.androidx.lifecycle.common.java8)

    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    // Kotlin coroutines components

    implementation (libs.kotlin.stdlib.jdk7)

    api (libs.kotlinx.coroutines.core)

    api (libs.kotlinx.coroutines.android)
}