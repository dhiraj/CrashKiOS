package co.touchlab.crashkios.bugsnag

import co.touchlab.crashkios.core.ThreadSafeVar

internal val bugsnagCalls = ThreadSafeVar<BugsnagCalls?>(null)

actual fun enableBugsnag() {
    bugsnagCalls.value = BugsnagCalls()
}

actual fun startBugsnag(config: BugsnagConfiguration) {
    bugsnagCalls.value?.startBugsnag(config)
}

actual fun sendHandledException(exception: Throwable) {
    bugsnagCalls.value?.sendHandledException(exception)
}

actual fun sendFatalException(exception: Throwable) {
    bugsnagCalls.value?.sendFatalException(exception)
}

actual fun logMessage(message: String) {
    bugsnagCalls.value?.logMessage(message)
}

actual fun setCustomValue(section: String, key: String, value: Any) {
    bugsnagCalls.value?.setCustomValue(section, key, value)
}

actual fun clearCustomValue(section: String, key: String) {
    bugsnagCalls.value?.clearCustomValue(section, key)
}

actual fun addFeatureFlag(name: String, variant: String?) {
    bugsnagCalls.value?.addFeatureFlag(name, variant)
}

actual fun clearFeatureFlag(name: String) {
    bugsnagCalls.value?.clearFeatureFlag(name)
}

actual fun clearAllFeatureFlags() {
    bugsnagCalls.value?.clearAllFeatureFlags()
}
