buildscript {
    extra.apply {
        set("compose_version", "1.4.1")
        set("hilt_version", "2.44")
        set("internalVersionCode", 10001)
        set("internalVersionName", "1.00.01")
        set("releaseVersionCode", 10000)
        set("releaseVersionName","1.00.00")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.android) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.androidLibrary) apply false
}