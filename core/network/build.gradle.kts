plugins {
    alias(libs.plugins.nizek.android.library)
    alias(libs.plugins.nizek.hilt)
}

android {
    namespace = "com.nizek.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.gson.converter)

    testImplementation(libs.junit)
    testImplementation(libs.mockk.android)
    testImplementation(libs.mockk.agent)
    
}