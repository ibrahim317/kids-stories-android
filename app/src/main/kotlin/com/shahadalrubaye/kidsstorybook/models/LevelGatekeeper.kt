package com.shahadalrubaye.kidsstorybook.models

object LevelGatekeeper {
    private const val LOCKED_LEVEL_COUNT = 7

    fun lockedLevels(totalLevels: Int): Set<Int> {
        if (totalLevels <= 0) return emptySet()
        val levelsToLock = LOCKED_LEVEL_COUNT.coerceAtMost(totalLevels)
        val start = totalLevels - levelsToLock + 1
        return (start..totalLevels).toSet()
    }

    fun requiresAdForLevel(level: Int, totalLevels: Int): Boolean {
        return level in lockedLevels(totalLevels)
    }
}

