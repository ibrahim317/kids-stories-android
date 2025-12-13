package com.shahadalrubaye.kidsstorybook.models

data class GameProgress(
    val highestUnlockedLevel: Int = 1,
    val levelStars: Map<Int, Int> = emptyMap()
) {
    fun isLevelUnlocked(level: Int): Boolean = level <= highestUnlockedLevel

    fun getStarsForLevel(level: Int): Int = levelStars[level] ?: 0

    fun isLevelCompleted(level: Int): Boolean = getStarsForLevel(level) == MAX_STARS

    fun withLevelStars(level: Int, starsEarned: Int, totalLevels: Int): GameProgress {
        val clampedStars = starsEarned.coerceIn(0, MAX_STARS)
        val currentStars = getStarsForLevel(level)
        val updatedStars = if (clampedStars > currentStars) {
            levelStars + (level to clampedStars)
        } else {
            levelStars
        }

        val shouldUnlockNext = clampedStars == MAX_STARS && level >= highestUnlockedLevel
        val newHighestUnlocked = when {
            shouldUnlockNext && level < totalLevels -> maxOf(highestUnlockedLevel, level + 1)
            else -> highestUnlockedLevel
        }.coerceIn(1, totalLevels)

        return copy(
            highestUnlockedLevel = newHighestUnlocked,
            levelStars = updatedStars.filterKeys { it in 1..totalLevels }
        )
    }

    fun clamp(totalLevels: Int): GameProgress {
        val clampedHighest = highestUnlockedLevel.coerceIn(1, totalLevels)
        val filteredStars = levelStars.filterKeys { it in 1..totalLevels }
        return if (clampedHighest != highestUnlockedLevel || filteredStars.size != levelStars.size) {
            copy(
                highestUnlockedLevel = clampedHighest,
                levelStars = filteredStars
            )
        } else {
            this
        }
    }

    companion object {
        const val MAX_STARS = 3
    }
}

/**
 * Tracks progress separately for each language.
 * Each language has its own GameProgress, allowing independent progress tracking.
 */
data class LanguageProgress(
    val progressByLanguage: Map<String, GameProgress> = emptyMap()
) {
    /**
     * Get progress for a specific language, or default progress if not found.
     */
    fun getProgressForLanguage(language: String): GameProgress {
        return progressByLanguage[language] ?: GameProgress()
    }

    /**
     * Update progress for a specific language.
     */
    fun withProgressForLanguage(language: String, progress: GameProgress): LanguageProgress {
        return copy(
            progressByLanguage = progressByLanguage + (language to progress)
        )
    }

    /**
     * Clamp all language progress to valid level ranges.
     */
    fun clamp(totalLevels: Int): LanguageProgress {
        val clampedProgress = progressByLanguage.mapValues { (_, progress) ->
            progress.clamp(totalLevels)
        }
        return if (clampedProgress != progressByLanguage) {
            copy(progressByLanguage = clampedProgress)
        } else {
            this
        }
    }
}



