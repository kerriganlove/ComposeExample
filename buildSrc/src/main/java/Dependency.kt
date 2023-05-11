object Version {
    const val GLIDE_COMPOSE_VERSION = "1.0.0-alpha.1"
    const val CORE_KTX_VERSION = "1.10.1"
    const val LIFECYCLE_KTX_VERSION = "2.6.1"
    const val ACTIVITY_COMPOSE_VERSION = "1.7.1"
    const val COMPOSE_VERSION = "1.4.3"
    const val MATERIAL_3_VERSION = "1.1.0"
}

object AndroidX {
    const val CORE_KTX = "androidx.core:core-ktx:1.9.0:${Version.CORE_KTX_VERSION}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE_KTX_VERSION}"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Version.ACTIVITY_COMPOSE_VERSION}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${Version.COMPOSE_VERSION}"
    const val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Version.COMPOSE_VERSION}"

    const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3:${Version.MATERIAL_3_VERSION}"

}

object Kotlin {

}

object AppTest {

}

object Github {
    const val Glide = "com.github.bumptech.glide:compose:${Version.GLIDE_COMPOSE_VERSION}"
}