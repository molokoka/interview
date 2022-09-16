// warnings are generated because groovy script fails to "use" properties properly
@file:Suppress("unused")

package app.yope.interview.buildSrc

object Libs {
  const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.2"

  const val timber = "com.jakewharton.timber:timber:5.0.1"
  const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.9.1"
  const val exoplayer = "com.google.android.exoplayer:exoplayer:2.18.1"
  const val dataStore = "androidx.datastore:datastore-preferences:1.0.0"

  object Okhttp {
    const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.3"

    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
  }

  object Retrofit {
    private const val version = "2.9.0"

    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val converter = "com.squareup.retrofit2:converter-moshi:$version"
  }

  object Moshi {
    private const val version = "1.13.0"

    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    const val moshi = "com.squareup.moshi:moshi:$version"
  }

  object Kotlin {
    private const val version = "1.7.0"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
    const val reflection = "org.jetbrains.kotlin:kotlin-reflect:$version"
  }

  object Coroutines {
    private const val version = "1.6.4"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
  }

  object Dagger {
    private const val version = "2.43.2"
    const val dagger = "com.google.dagger:dagger:$version"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$version"
  }

  object Coil {
    private const val version = "1.4.0"
    const val compose = "io.coil-kt:coil-compose:$version"
    const val gif = "io.coil-kt:coil-gif:$version"
  }

  object Accompanist {
    private const val version = "0.25.1"
    const val pager = "com.google.accompanist:accompanist-pager:$version"
    const val permissions = "com.google.accompanist:accompanist-permissions:$version"
    const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:$version"
  }

  object GoogleGms {
    const val servicesGradlePlugin = "com.google.gms:google-services:4.3.10"
  }

  object Firebase {
    const val crashlyticsGradlePlugin = "com.google.firebase:firebase-crashlytics-gradle:2.8.1"
    const val bom = "com.google.firebase:firebase-bom:30.3.0"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val storage = "com.google.firebase:firebase-storage-ktx"
    const val authentication = "com.google.firebase:firebase-auth-ktx"
    const val firestoreDatabase = "com.google.firebase:firebase-firestore-ktx"
    const val realtimeDatabase = "com.google.firebase:firebase-database-ktx"
    const val coroutineExt = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.0"
  }

  object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:1.8.0"
    const val webKit = "androidx.webkit:webkit:1.4.0"

    object Lifecycle {
      private const val version = "2.5.1"
      const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }

    object Activity {
      const val activityCompose = "androidx.activity:activity-compose:1.5.1"
    }

    object Compose {
      const val version = "1.2.0"

      const val util = "androidx.compose.ui:ui-util:$version"
      const val foundation = "androidx.compose.foundation:foundation:$version"
      const val layout = "androidx.compose.foundation:foundation-layout:$version"
      const val material = "androidx.compose.material:material:$version"
      const val runtime = "androidx.compose.runtime:runtime:$version"
      const val test = "androidx.compose.test:test-core:$version"
      const val uiTest = "androidx.compose.ui:ui-test:$version"

      object Tooling {
        const val version = "1.2.1"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
      }
    }

    object ConstrainLayout {
      const val compose = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    }

    object Test {
      private const val version = "1.4.0"
      const val core = "androidx.test:core:$version"
      const val rules = "androidx.test:rules:$version"

      object Ext {
        private const val version = "1.1.3"
        const val junitKotlin = "androidx.test.ext:junit-ktx:$version"
        const val junit = "androidx.test.ext:junit:$version"
      }

      const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    }
  }

  const val junit = "junit:junit:4.13.2"

  object KoTest {
    private const val version = "5.4.2"
    const val koTestRunner = "io.kotest:kotest-runner-junit5:$version"
    const val koTestAssertions = "io.kotest:kotest-assertions-core:$version"
  }
}
