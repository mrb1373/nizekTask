plugins {
    alias(libs.plugins.nizek.android.feature)
    alias(libs.plugins.nizek.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.nizek.productSearch"
}

dependencies {

    implementation(projects.core.data)
    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(libs.picasso)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}