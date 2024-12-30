package co.touchlab.crashkios.crashlytics

import co.touchlab.crashkios.core.ThreadSafeVar

internal actual class CrashlyticsCalls actual constructor() {
    actual fun enableCrashlytics() {
        // No-op for JVM
    }

    actual fun setCrashlyticsUnhandledExceptionHook() {
        // No-op for JVM
    }

    actual fun sendHandledException(exception: Throwable) {
        // No-op for JVM
    }

    actual fun logMessage(message: String) {
        // No-op for JVM
    }

    actual fun setCustomValue(key: String, value: String) {
        // No-op for JVM
    }
}
