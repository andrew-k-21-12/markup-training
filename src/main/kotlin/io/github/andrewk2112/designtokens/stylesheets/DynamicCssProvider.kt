package io.github.andrewk2112.designtokens.stylesheets

import kotlinx.css.CssBuilder
import kotlinx.css.RuleSet

/**
 * Provides [RuleSet]s with caching according to provided arguments.
 *
 * @param sheet           A reference to the [DynamicStyleSheet] containing and caching all related styles.
 * @param staticCssSuffix A suffix to be included into all names of dynamic CSS classes.
 * @param builder         A builder describing how to prepare CSS rules according to the current argument.
 * */
class DynamicCssProvider<T : HasCssSuffix> internal constructor(
    private val sheet: DynamicStyleSheet,
    private val staticCssSuffix: String,
    private val builder: CssBuilder.(T) -> Unit
) {

    operator fun invoke(argument: T): RuleSet = sheet.prepareCachedRuleSet(staticCssSuffix, builder, argument)

}
