import org.gradle.api.Project

object Version {
    const val GLIDE_COMPOSE_VERSION = "1.0.0-alpha.1"
    const val CORE_KTX_VERSION = "1.10.1"
    const val LIFECYCLE_KTX_VERSION = "2.6.1"
    const val ACTIVITY_COMPOSE_VERSION = "1.7.1"
    const val COMPOSE_VERSION = "1.4.3"
    const val MATERIAL_3_VERSION = "1.1.0"
    const val HILT_VERISON = "2.44"

    const val JUNIT_VERSION = "4.13.2"
    const val ANDROID_JUNIT_VERSION = "1.1.4"
    const val ESPRESSO_VERSION = "3.5.0"
}

object AppDependency {
    const val CORE_KTX = "androidx.core:core-ktx:1.9.0:${Version.CORE_KTX_VERSION}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE_KTX_VERSION}"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Version.ACTIVITY_COMPOSE_VERSION}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${Version.COMPOSE_VERSION}"
    const val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Version.COMPOSE_VERSION}"

    const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3:${Version.MATERIAL_3_VERSION}"

    const val GLIDE = "com.github.bumptech.glide:compose:${Version.GLIDE_COMPOSE_VERSION}"

}

object AppTest {
    const val JUNIT = "junit:junit:${Version.JUNIT_VERSION}"
    const val ANDROID_TEST_JUNIT= "androidx.test.ext:junit:${Version.ANDROID_JUNIT_VERSION}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_VERSION}"
    const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${Version.COMPOSE_VERSION}"
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-manifest:${Version.COMPOSE_VERSION}"
}

object AppSupport {
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Version.COMPOSE_VERSION}"
}
object RejectDependency {
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT_VERISON}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-compiler:${Version.HILT_VERISON}"
    const val KOIN = ""
}

object AppAndroid {
    val libList = arrayOf(
        AppDependency.CORE_KTX,
        AppDependency.LIFECYCLE_KTX,
        AppDependency.ACTIVITY_COMPOSE,
        AppDependency.COMPOSE_UI,
        AppDependency.COMPOSE_UI_PREVIEW,
        AppDependency.COMPOSE_MATERIAL_3,
        AppDependency.GLIDE
    )

    val rejectionLibList = arrayOf(
        RejectDependency.HILT_ANDROID
    )
    val testLibList = arrayOf(
        AppTest.JUNIT
    )
}

