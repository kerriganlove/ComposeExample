plugins {
    id("kotlin-kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

buildscript {
    extra.apply {
        set("internalVersionCode", 10001)
        set("internalVersionName", "1.00.01")
        set("releaseVersionCode", 10000)
        set("releaseVersionName","1.00.00")
    }
}


android {
    namespace("com.learning.composeexample")
    compileSdk(33)

    defaultConfig {
        applicationId("com.learning.composeexample")
        minSdk(26)
        targetSdk(33)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        vectorDrawables {
            useSupportLibrary(true)
        }
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
            resConfig = "hdpi"
        }
        create("phone") {
            dimension = "type"
            resConfig = "xxxhdpi"
        }

        create("launch") {
            dimension = "env"
            versionCode = releaseVersionCode
            versionName = releaseVersionName
        }
        create("dev") {
            dimension = "env"
            versionCode = internalVersionCode
            versionName = internalVersionName
        }
        create("errorTest") {
            dimension = "env"
            initWith(getByName("dev"))
            // error code 테스트 할 수 있도록 추가.
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

    // Compose UI
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:${compose_version}")
    implementation("androidx.compose.ui:ui-tooling-preview:${compose_version}")
    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")

    // Test Code
    testImplementation "junit:junit:4.13.2"
    androidTestImplementation "androidx.test.ext:junit:1.1.4"
    androidTestImplementation "androidx.test.espresso:espresso-core:3.5.0"
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_version"

    // Dagger-Hilt
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}