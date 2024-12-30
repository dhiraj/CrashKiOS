# Key Files in CrashKiOS

## Project Configuration

1. **build.gradle.kts** (root)
   - Main build configuration for the project
   - Defines common plugins and repositories

2. **gradle/libs.versions.toml**
   - Centralized dependency version management
   - Contains SDK versions and library dependencies

3. **settings.gradle.kts**
   - Project structure configuration
   - Includes all submodules

## Core Modules

### Bugsnag Module
1. **bugsnag/build.gradle.kts**
   - Build configuration for Bugsnag integration
   - Defines platform targets and dependencies

2. **bugsnag/src/nativeInterop/cinterop/bugsnag.def**
   - Native interop configuration for Bugsnag SDK
   - Lists required header files

3. **bugsnag/src/include/Bugsnag.h**
   - Main Bugsnag header file
   - Defines core Bugsnag functionality

### Crashlytics Module
1. **crashlytics/build.gradle.kts**
   - Build configuration for Crashlytics integration
   - Defines platform targets and dependencies

2. **crashlytics/src/nativeInterop/cinterop/crashlytics.def**
   - Native interop configuration for Crashlytics SDK
   - Defines Objective-C functions for Crashlytics

## Documentation

1. **docs/architecture.md**
   - Project architecture overview
   - Describes module structure and components

2. **docs/usage_guide.md**
   - Usage instructions and examples
   - Covers both Bugsnag and Crashlytics integration

3. **docs/BugsnagTutorial.md**
   - Bugsnag-specific tutorial
   - Step-by-step integration guide

4. **docs/CrashlyticsTutorial.md**
   - Crashlytics-specific tutorial
   - Step-by-step integration guide

## Samples

1. **samples/sample-bugsnag/**
   - Example implementation using Bugsnag
   - Includes both Android and iOS samples

2. **samples/sample-crashlytics/**
   - Example implementation using Crashlytics
   - Includes both Android and iOS samples

## Website

1. **website/docusaurus.config.js**
   - Configuration for documentation website
   - Defines site metadata and plugins

2. **website/sidebars.js**
   - Documentation navigation structure
   - Organizes documentation sections

3. **website/src/pages/index.tsx**
   - Main website landing page
   - Contains homepage content and layout

## Other Important Files

1. **README.md**
   - Project overview and quick start guide
   - Links to documentation and resources

2. **THE_PROBLEM.md**
   - Explains the problem the project solves
   - Provides context for the implementation

3. **LICENSE.txt**
   - Project license information
   - Apache License 2.0
