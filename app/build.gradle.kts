plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.soboksobook"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.soboksobook"
        minSdk = 25
        targetSdk=33
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
//
    implementation("com.github.ybq:Android-SpinKit:1.4.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //타이머 관련 의존성

    implementation("com.github.krtkush:LinearTimer:v2.1.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}