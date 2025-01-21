plugins {
    alias(libs.plugins.nizek.android.library)
}

android {
    namespace = "com.nizek.common"
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk.android)
    testImplementation(libs.mockk.agent)
    testImplementation(libs.junit)
}