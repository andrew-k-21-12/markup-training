package io.github.andrewk2112.ui.styles

import io.github.andrewk2112.designtokens.StyleValues
import io.github.andrewk2112.designtokens.stylesheets.DynamicStyleSheet
import kotlinx.css.properties.transition
import kotlin.reflect.KProperty

/**
 * Contains some common transition configs.
 * */
object TransitionStyles : DynamicStyleSheet() {

    val defaultTransition by dynamicCss<KProperty<*>> {
        transition(it, StyleValues.time.ms100, StyleValues.timing.cubicBezier1)
    }

}
