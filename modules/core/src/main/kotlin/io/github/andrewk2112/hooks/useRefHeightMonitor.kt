package io.github.andrewk2112.hooks

import dom.observers.ResizeObserver
import org.w3c.dom.Element
import react.RefObject
import react.useEffectOnce

/**
 * Monitors for and notifies about the height updates of the provided [ref] via the [onHeightChanged] callback.
 */
inline fun useRefHeightMonitor(ref: RefObject<Element>, crossinline onHeightChanged: (Double) -> Unit) = useEffectOnce {
    val resizeObserver = ref.current?.let { element ->
        var previousHeight = 0.0
        ResizeObserver { entries, _ ->
            val newHeight = entries.firstOrNull()?.contentRect?.height
            if (newHeight != null && newHeight != previousHeight) {
                previousHeight = newHeight
                onHeightChanged(newHeight)
            }
        }.also { it.observe(element) }
    }
    cleanup { resizeObserver?.disconnect() }
}
