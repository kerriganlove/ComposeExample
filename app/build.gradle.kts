
@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin)
    id("kotlin-kapt")
}


android {
    namespace = "com.learning.composeexample"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.learning.composeexample"
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        create("inhouse") {
            initWith(getByName("release"))
            isDebuggable = true
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
    // 대분류 ex) "dev", "type" 순서로 선언 시
    val dimensions = arrayOf("type", "env")
    dimensions.forEach {
        flavorDimensions += it
    }
    // 소분류 ex) tabletLaunch, tabletDev, phoneErrorTest...
    productFlavors {
        create("tablet") {
            dimension = "type"// 임의값입니다... 의미 부여 ㄴ
            resourceConfigurations.add("hdpi")
        }
        create("phone") {
            dimension = "type"
            resourceConfigurations.add("xxxhdpi")
        }

        create("launch") {
            dimension = "env"
            versionCode = rootProject.extra["releaseVersionCode"] as Int
            versionName = rootProject.extra["releaseVersionName"] as String
        }
        create("dev") {
            dimension = "env"
            versionCode = rootProject.extra["internalVersionCode"] as Int
            versionName = rootProject.extra["internalVersionName"] as String
        }
        create("errorTest") {
            dimension = "env"
            initWith(getByName("dev"))
            // error code 테스트 할 수 있도록 추가.
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // UI & Android Library
    AppAndroid.libList.forEach {
        implementation(it)
    }
    debugImplementation(AppSupport.COMPOSE_TOOLING)

    // Dagger-Hilt
    AppAndroid.rejectionLibList.forEach {
        implementation(it)
    }

    // Test Code
    testImplementation(AppTest.JUNIT)
    androidTestImplementation(AppTest.ANDROID_TEST_JUNIT)
    androidTestImplementation(AppTest.ESPRESSO)
    androidTestImplementation(AppTest.COMPOSE_JUNIT)
    debugImplementation(AppTest.COMPOSE_UI_TEST)
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}