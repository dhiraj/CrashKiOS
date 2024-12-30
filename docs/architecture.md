# CrashKiOS Architecture Overview

## Project Structure

The project is organized into several key modules:

1. **Core** (core/)
   - Empty module that serves as a common dependency
   - Configured for both Android and Apple platforms

2. **Bugsnag Integration** (bugsnag/)
   - Kotlin Multiplatform wrapper for Bugsnag's iOS SDK
   - Uses C interop to interface with native Bugsnag headers
   - Supports Android and Apple platforms
   - Key Features:
     - Exception reporting
     - Metadata management
     - Feature flags
     - Breadcrumbs

3. **Crashlytics Integration** (crashlytics/)
   - Kotlin Multiplatform wrapper for Firebase Crashlytics iOS SDK
   - Uses C interop to interface with native Crashlytics headers
   - Supports Android and Apple platforms
   - Key Features:
     - Exception reporting with stack traces
     - Custom logging
     - User identification
     - Custom key-value pairs

4. **Samples** (samples/)
   - Example implementations demonstrating usage
   - Includes both Bugsnag and Crashlytics samples
   - Shows Android and iOS integration

## Key Components

### Native Interop
Both integration modules use Kotlin/Native's C interop capabilities to interface with the respective crash reporting SDKs:
- Objective-C headers are exposed to Kotlin
- Native functions are called through generated Kotlin bindings
- Error handling bridges Kotlin exceptions to native crash reporters

### Platform Support
The modules support:
- iOS (arm64, x64, simulator)
- macOS (arm64, x64)
- watchOS
- tvOS
- Android

### Common Architecture
Both integration modules follow a similar pattern:
1. Native SDK headers are exposed through .def files
2. Kotlin provides a type-safe API for the native functionality
3. Platform-specific implementations handle the actual integration
4. Common interfaces allow for consistent usage across platforms

## Workflow

1. **Initialization**
   - SDK is configured through native configuration objects
   - Required dependencies are verified at startup

2. **Exception Handling**
   - Kotlin exceptions are captured and translated to native exception models
   - Stack traces are preserved and formatted for native crash reporters
   - Additional context (breadcrumbs, metadata) is attached

3. **Reporting**
   - Exceptions are reported to the native SDK
   - Custom events and logs can be recorded
   - User information and custom data can be attached

## Dependencies

- **NSExceptionKt**: Used for exception handling on Apple platforms
- **Bugsnag iOS SDK**: Native dependency for bugsnag module
- **Firebase Crashlytics**: Native dependency for crashlytics module
- **Kotlin Multiplatform**: Core framework enabling cross-platform support

## Suggested Improvements

1. **Enhanced Documentation**
   - Add detailed usage examples
   - Create troubleshooting guides
   - Document common integration patterns

2. **Error Handling Improvements**
   - Add more robust error recovery
   - Implement fallback mechanisms for failed reports
   - Add detailed logging for debugging

3. **Feature Expansion**
   - Add support for more crash reporting providers
   - Implement unified API across different providers
   - Add more customization options for reports

4. **Testing Enhancements**
   - Add more comprehensive unit tests
   - Implement integration testing
   - Add CI/CD pipeline for automated testing

5. **Performance Optimization**
   - Optimize exception handling overhead
   - Implement batching for reports
   - Add resource usage monitoring

6. **Monitoring and Analytics**
   - Add usage statistics collection
   - Implement health monitoring
   - Add reporting success/failure metrics
