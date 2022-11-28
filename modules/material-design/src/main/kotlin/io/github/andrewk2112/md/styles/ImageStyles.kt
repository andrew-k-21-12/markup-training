package io.github.andrewk2112.md.styles

import io.github.andrewk2112.designtokens.StyleValues
import io.github.andrewk2112.stylesheets.DynamicStyleSheet
import io.github.andrewk2112.stylesheets.NamedRuleSet
import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.css.pct
import kotlinx.css.width

/**
 * Typical image and icon styles.
 */
object ImageStyles : DynamicStyleSheet() {

    val fitWidthKeepAspectImage: NamedRuleSet by css {
        width  = 100.pct
        height = LinearDimension.auto
    }

    val smallSizedIcon: NamedRuleSet by css {
        width  = StyleValues.sizes.absolute32
        height = StyleValues.sizes.absolute32
    }

}
