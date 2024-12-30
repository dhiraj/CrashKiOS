# CrashKiOS Usage Guide

## Getting Started

### Installation
Add the desired module to your project:

```kotlin
// For Bugsnag
implementation("co.touchlab.crashkios:bugsnag:$version")

// For Crashlytics
implementation("co.touchlab.crashkios:crashlytics:$version")
```

### Initialization

#### Bugsnag
```kotlin
Bugsnag.start(context, Configuration().apply {
    apiKey = "YOUR_API_KEY"
    // Additional configuration
})
```

#### Crashlytics
```kotlin
FirebaseApp.initializeApp(context)
Crashlytics.initialize()
```

## Basic Usage

### Reporting Exceptions

#### Bugsnag
```kotlin
try {
    // Code that might throw
} catch (e: Exception) {
    Bugsnag.notify(e)
}
```

#### Crashlytics
```kotlin
try {
    // Code that might throw
} catch (e: Exception) {
    Crashlytics.recordException(e)
}
```

### Adding Metadata

#### Bugsnag
```kotlin
Bugsnag.addMetadata("user", mapOf(
    "id" to userId,
    "email" to userEmail
))
```

#### Crashlytics
```kotlin
Crashlytics.setCustomKey("user_id", userId)
Crashlytics.setCustomKey("user_email", userEmail)
```

### Logging Messages

#### Bugsnag
```kotlin
Bugsnag.leaveBreadcrumb("User logged in")
```

#### Crashlytics
```kotlin
Crashlytics.log("User logged in")
```

## Advanced Features

### Feature Flags (Bugsnag Only)
```kotlin
Bugsnag.addFeatureFlag("new_feature", "enabled")
```

### User Identification
```kotlin
// Bugsnag
Bugsnag.setUser(userId, userEmail, userName)

// Crashlytics
Crashlytics.setUserId(userId)
```

### Custom Stack Traces
```kotlin
val exception = Exception("Custom error")
exception.stackTrace = customStackTrace
Crashlytics.recordException(exception)
```

## Best Practices

1. **Initialize Early**
   - Initialize the SDK as early as possible in your application lifecycle

2. **Handle Uncaught Exceptions**
   - Set up global exception handlers to catch unexpected crashes

3. **Use Metadata Wisely**
   - Add relevant context but avoid sensitive information

4. **Test Your Integration**
   - Verify reporting works in both development and production environments

5. **Monitor Usage**
   - Regularly check your crash reporting dashboard for issues

## Troubleshooting

### Common Issues

1. **Missing Dependencies**
   - Ensure all required native SDKs are properly linked

2. **Initialization Errors**
   - Verify configuration values and network connectivity

3. **Missing Reports**
   - Check for errors in the console logs
   - Verify the SDK is properly initialized

4. **Performance Impact**
   - Monitor application performance after integration
   - Optimize reporting frequency if needed

## Sample Code

See the `samples/` directory for complete example implementations demonstrating both Bugsnag and Crashlytics integration on Android and iOS.
