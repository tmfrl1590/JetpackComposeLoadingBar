plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.tmfrl.compose.loading"
    compileSdk = 35

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}

// ✅ JitPack을 통한 배포 설정
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                // ✅ GitHub 사용자 이름과 라이브러리 이름을 설정
                groupId = "com.github.tmfrl1590"  // GitHub 사용자 이름 (예: tmfrl1590)
                artifactId = "JetpackComposeLoadingBar"  // 공개할 라이브러리 이름
                version = "1.0.0"  // 버전

                // ✅ 필요하면 POM 설명 추가
                pom {
                    name.set("Compose Loading Bar")
                    description.set("A lightweight and customizable loading spinner for Jetpack Compose.")
                    url.set("https://github.com/tmfrl1590/JetpackComposeLoadingBar")
                }
            }

            create<MavenPublication>("debug") { // ✅ debug 빌드 추가
                from(components["debug"])
                groupId = "com.github.tmfrl1590"
                artifactId = "JetpackComposeLoadingBar"
                version = "1.0.0"
            }
        }
    }
}
