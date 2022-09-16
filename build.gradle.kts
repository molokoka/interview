buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(app.yope.interview.buildSrc.Libs.androidGradlePlugin)
    classpath(app.yope.interview.buildSrc.Libs.Kotlin.gradlePlugin)
    classpath(app.yope.interview.buildSrc.Libs.Kotlin.serializationPlugin)
    classpath(app.yope.interview.buildSrc.Libs.GoogleGms.servicesGradlePlugin)
    classpath(app.yope.interview.buildSrc.Libs.Firebase.crashlyticsGradlePlugin)
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
