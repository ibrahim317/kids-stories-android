package com.shahadalrubaye.kidsstorybook.models

/**
 * Controls which comparison cards require rewarded ads before unlocking.
 *
 * We purposely lock only a handful of cards to keep most content readily available
 * while still showcasing the rewarded flow. The ids map directly to
 * `ComparisonRepository` entries.
 */
object ComparisonGatekeeper {
    private val LOCKED_COMPARISON_IDS = setOf(
        "in_the_street",
        "mall",
        "school",
        "strangers",
        "birthday"
    )

    fun lockedComparisonIds(): Set<String> = LOCKED_COMPARISON_IDS
}


