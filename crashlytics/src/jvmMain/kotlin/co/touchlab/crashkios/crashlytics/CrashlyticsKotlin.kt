package co.touchlab.crashkios.crashlytics

import co.touchlab.crashkios.core.ThreadSafeVar

internal val crashlyticsCalls = ThreadSafeVar<CrashlyticsCalls?>(null)

actual fun enableCrashlytics() {
    crashlyticsCalls.value = CrashlyticsCalls()
}

actual fun setCrashlyticsUnhandledExceptionHook() {
    crashlyticsCalls.value?.setCrashlyticsUnhandledExceptionHook()
}

actual fun sendHandledException(exception: Throwable) {
    crashlyticsCalls.value?.sendHandledException(exception)
}

actual fun logMessage(message: String) {
    crashlyticsCalls.value?.logMessage(message)
}

actual fun setCustomValue(key: String, value: String) {
    crashlyticsCalls.value?.setCustomValue(key, value)
}
