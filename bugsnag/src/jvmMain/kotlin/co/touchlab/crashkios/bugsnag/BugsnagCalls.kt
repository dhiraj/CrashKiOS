package co.touchlab.crashkios.bugsnag

import co.touchlab.crashkios.core.ThreadSafeVar

internal actual class BugsnagCalls actual constructor() {
    actual fun startBugsnag(config: BugsnagConfiguration) {
        // No-op for JVM
    }

    actual fun sendHandledException(exception: Throwable) {
        // No-op for JVM
    }

    actual fun sendFatalException(exception: Throwable) {
        // No-op for JVM
    }

    actual fun logMessage(message: String) {
        // No-op for JVM
    }

    actual fun setCustomValue(section: String, key: String, value: Any) {
        // No-op for JVM
    }

    actual fun clearCustomValue(section: String, key: String) {
        // No-op for JVM
    }

    actual fun addFeatureFlag(name: String, variant: String?) {
        // No-op for JVM
    }

    actual fun clearFeatureFlag(name: String) {
        // No-op for JVM
    }

    actual fun clearAllFeatureFlags() {
        // No-op for JVM
    }
}
