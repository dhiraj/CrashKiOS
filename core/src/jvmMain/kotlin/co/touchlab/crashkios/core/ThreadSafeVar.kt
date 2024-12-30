package co.touchlab.crashkios.core

import kotlin.reflect.KProperty
import java.util.concurrent.atomic.AtomicReference

actual class ThreadSafeVar<T>(target: T) {
    private val atomicRef = AtomicReference(target)

    actual operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return atomicRef.get()
    }

    actual operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        atomicRef.set(value)
    }
}
