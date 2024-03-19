/*
 * This file was generated by the Gradle 'init' task.
 */
import dependencies.ProjectConfig

plugins {
  kotlin("multiplatform")
}

repositories {
  mavenLocal()
  mavenCentral()

  maven {
    url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
  }
}

dependencies {
  commonMainImplementation("org.jetbrains.kotlin:kotlin-stdlib")
  commonTestImplementation(kotlin("test-common"))
}

version = ProjectConfig.VERSION
group = ProjectConfig.GROUP


kotlin {
  jvm("jvm") {
  }
  js("js") {
    browser {}
    nodejs { }
  }

  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation(kotlin("test-junit5"))
      }

    }
    val jvmTest by getting
    val commonMain by getting
    val commonTest by getting
  }
}



tasks {
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
      jvmTarget = "${JavaVersion.VERSION_17}"
      freeCompilerArgs += "-Xexpect-actual-classes"
    }
  }
}