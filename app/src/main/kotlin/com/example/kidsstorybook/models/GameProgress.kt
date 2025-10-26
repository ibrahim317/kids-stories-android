package com.example.kidsstorybook.models

data class GameProgress(
    val highestUnlockedLevel: Int = 1,
    val completedLevels: Set<Int> = emptySet()
) {
    fun isLevelUnlocked(level: Int): Boolean {
        return level <= highestUnlockedLevel
    }

    fun isLevelCompleted(level: Int): Boolean {
        return completedLevels.contains(level)
    }

    fun completeLevel(level: Int): GameProgress {
        return copy(
            highestUnlockedLevel = maxOf(highestUnlockedLevel, level + 1),
            completedLevels = completedLevels + level
        )
    }
}

