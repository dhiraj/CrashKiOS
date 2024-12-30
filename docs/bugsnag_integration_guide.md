# BugSnag Integration Guide for Compose Multiplatform (iOS)

This guide provides step-by-step instructions for integrating the CrashKiOS BugSnag library into a Compose Multiplatform project targeting iOS, Android, and Desktop JVM.

## Prerequisites
- Existing Compose Multiplatform project
- BugSnag account and API key
- Xcode 13+ and CocoaPods installed

## 1. Gradle Configuration

Add the following to your root `build.gradle.kts`:

```kotlin
plugins {
    id("co.touchlab.crashkios.bugsnaglink") version "0.1.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
        maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}
```

In your shared module's `build.gradle.kts`:

```kotlin
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api("co.touchlab.crashkios:bugsnag")
            }
        }
    }

    cocoapods {
        framework {
            export("co.touchlab.crashkios:bugsnag")
            isStatic = false
        }
    }
}
```

## 2. iOS Configuration

In your iOS project's `Podfile`:

```ruby
target 'YourApp' do
  use_frameworks!
  
  pod 'Bugsnag'
  plugin 'cocoapods-bugsnag'
  
  pod 'shared', :path => '../shared'
end
```

Run `pod install` in your iOS directory.

## 3. BugSnag Initialization

In your shared module's common code:

```kotlin
import co.touchlab.crashkios.bugsnag.BugsnagKios

fun initBugsnag(apiKey: String) {
    BugsnagKios.start(apiKey)
}
```

Call this from your platform-specific entry points:

```kotlin
// iOS
initBugsnag("YOUR_API_KEY")

// Android
Bugsnag.start(context, "YOUR_API_KEY")
```

## 4. Handling Kotlin Exceptions on iOS

The library automatically hooks into Kotlin/Native's uncaught exception handler to provide detailed Kotlin stack traces in BugSnag reports.

To manually report exceptions:

```kotlin
try {
    // Your code
} catch (e: Exception) {
    BugsnagKios.reportException(e)
    throw e
}
```

## 5. Verifying Integration

1. Force a crash in your Kotlin code
2. Check the BugSnag dashboard
3. Verify that the stack trace shows Kotlin source lines instead of just native frames

## Troubleshooting

- Ensure the BugSnag pod is properly installed
- Verify the API key is correct
- Check that the shared framework is linked in your Xcode project
- Make sure the `BugsnagKios.start()` is called before any Kotlin code executes
