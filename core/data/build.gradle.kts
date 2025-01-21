plugins {
    alias(libs.plugins.nizek.android.library)
    alias(libs.plugins.nizek.hilt)
}

android {
    namespace = "com.mrb.data"
}

dependencies {

    implementation(projects.core.network)
    implementation(projects.core.common)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk.android)
    testImplementation(libs.mockk.agent)
}