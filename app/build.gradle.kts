plugins {
    id("com.android.application")
}

android {
    namespace = "com.collectcent.gamepad"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.collectcent.gamepad"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //adjust sdk
    implementation ("com.adjust.sdk:adjust-android:4.33.5")
    implementation ("com.android.installreferrer:installreferrer:2.2")
    // Add the following if you are using the Adjust SDK inside web views on your app
    implementation ("com.adjust.sdk:adjust-android-webbridge:4.33.5")

    implementation ("com.google.android.gms:play-services-appset:16.0.2")
    implementation ("com.google.android.gms:play-services-ads-identifier:18.0.1")


    implementation ("com.android.installreferrer:installreferrer:2.2")


}