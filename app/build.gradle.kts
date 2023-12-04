plugins {
    id("com.android.application")
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

    //
    id("com.google.gms.google-services")

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

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")

    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")

//
    implementation("com.github.ybq:Android-SpinKit:1.4.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //타이머 관련 의존성

    implementation("com.github.krtkush:LinearTimer:v2.1.1")

    //구글 맵 의존성
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    implementation ("com.google.android.gms:play-services-places:15.0.0")
    implementation ("com.google.android.libraries.places:places:2.4.0")

    //네트워킹
    implementation ("com.android.volley:volley:1.2.1")



    //kakao sdk
    implementation("com.kakao.sdk:v2-user:2.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.0")

}