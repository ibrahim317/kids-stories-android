package com.example.kidsstorybook.data

import android.content.Context
import android.content.SharedPreferences
import com.example.kidsstorybook.models.AgeGroup
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.GameProgress
import com.example.kidsstorybook.models.LanguageProgress

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = 
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "kids_game_prefs"
        private const val KEY_LANGUAGE = "language"
        private const val KEY_AGE_GROUP = "age_group"
        private const val KEY_PLAYER_NAME = "player_name"
        private const val KEY_HIGHEST_UNLOCKED_LEVEL = "highest_unlocked_level"
        private const val KEY_COMPLETED_LEVELS = "completed_levels"
        private const val KEY_LEVEL_STARS = "level_stars"
        private const val KEY_AD_UNLOCKED_LEVELS = "ad_unlocked_levels"
        private const val KEY_AD_UNLOCKED_ANIMALS = "ad_unlocked_animals"
        private const val KEY_AD_UNLOCKED_COMPARISONS = "ad_unlocked_comparisons"
        
        // Language-specific progress keys
        private const val KEY_LANGUAGE_PROGRESS_PREFIX = "lang_progress_"
        private const val KEY_MIGRATED_TO_LANGUAGE_PROGRESS = "migrated_to_language_progress"
    }

    fun saveLanguage(language: String) {
        prefs.edit().putString(KEY_LANGUAGE, language).apply()
    }

    fun getLanguage(): String {
        return prefs.getString(KEY_LANGUAGE, "en") ?: "en"
    }

    fun saveAgeGroup(ageGroup: AgeGroup) {
        prefs.edit().putString(KEY_AGE_GROUP, ageGroup.name).apply()
    }

    fun getAgeGroup(): AgeGroup {
        val name = prefs.getString(KEY_AGE_GROUP, AgeGroup.AGE_2_4.name)
        return try {
            AgeGroup.valueOf(name ?: AgeGroup.AGE_2_4.name)
        } catch (e: IllegalArgumentException) {
            AgeGroup.AGE_2_4
        }
    }

    fun saveSettings(settings: AppSettings) {
        prefs.edit().apply {
            putString(KEY_LANGUAGE, settings.language)
            putString(KEY_AGE_GROUP, settings.ageGroup.name)
            putString(KEY_PLAYER_NAME, settings.playerName)
            apply()
        }
    }

    fun getSettings(): AppSettings {
        return AppSettings(
            language = getLanguage(),
            ageGroup = getAgeGroup(),
            playerName = getPlayerName()
        )
    }

    fun getPlayerName(): String {
        return prefs.getString(KEY_PLAYER_NAME, "").orEmpty()
    }

    fun savePlayerName(name: String) {
        prefs.edit().putString(KEY_PLAYER_NAME, name).apply()
    }

    /**
     * Save progress for a specific language.
     */
    fun saveProgressForLanguage(language: String, progress: GameProgress) {
        val keyPrefix = "$KEY_LANGUAGE_PROGRESS_PREFIX$language"
        val completedLevels =
            progress.levelStars.filterValues { it >= GameProgress.MAX_STARS }.keys.map { it.toString() }.toSet()

        prefs.edit().apply {
            putInt("${keyPrefix}_highest", progress.highestUnlockedLevel)
            putStringSet("${keyPrefix}_completed", completedLevels)
            putString("${keyPrefix}_stars", serializeLevelStars(progress.levelStars))
            apply()
        }
    }

    /**
     * Get progress for a specific language.
     */
    fun getProgressForLanguage(language: String): GameProgress {
        val keyPrefix = "$KEY_LANGUAGE_PROGRESS_PREFIX$language"
        val highestLevel = prefs.getInt("${keyPrefix}_highest", 1)
        val completedLevelsStrings = prefs.getStringSet("${keyPrefix}_completed", emptySet()) ?: emptySet()
        val legacyStars = completedLevelsStrings.mapNotNull { it.toIntOrNull() }
            .associateWith { GameProgress.MAX_STARS }
        val serializedStars = prefs.getString("${keyPrefix}_stars", null)
        val storedStars = deserializeLevelStars(serializedStars)

        val mergedStars = buildMap {
            putAll(legacyStars)
            putAll(storedStars)
        }

        return GameProgress(
            highestUnlockedLevel = highestLevel,
            levelStars = mergedStars
        )
    }

    /**
     * Save all language progress.
     */
    fun saveLanguageProgress(languageProgress: LanguageProgress) {
        languageProgress.progressByLanguage.forEach { (language, progress) ->
            saveProgressForLanguage(language, progress)
        }
    }

    /**
     * Get all language progress, with migration from old format if needed.
     */
    fun getLanguageProgress(): LanguageProgress {
        // Check if we need to migrate from old format
        val migrated = prefs.getBoolean(KEY_MIGRATED_TO_LANGUAGE_PROGRESS, false)
        if (!migrated) {
            // Migrate old progress to all languages - read directly from old keys to avoid circular dependency
            val highestLevel = prefs.getInt(KEY_HIGHEST_UNLOCKED_LEVEL, 1)
            val completedLevelsStrings = prefs.getStringSet(KEY_COMPLETED_LEVELS, emptySet()) ?: emptySet()
            val legacyStars = completedLevelsStrings.mapNotNull { it.toIntOrNull() }
                .associateWith { GameProgress.MAX_STARS }
            val serializedStars = prefs.getString(KEY_LEVEL_STARS, null)
            val storedStars = deserializeLevelStars(serializedStars)

            val mergedStars = buildMap {
                putAll(legacyStars)
                putAll(storedStars)
            }

            val oldProgress = GameProgress(
                highestUnlockedLevel = highestLevel,
                levelStars = mergedStars
            )
            
            val languages = listOf("en", "ar", "tr")
            val migratedProgress = languages.associateWith { oldProgress }
            
            prefs.edit().apply {
                languages.forEach { lang ->
                    saveProgressForLanguage(lang, oldProgress)
                }
                putBoolean(KEY_MIGRATED_TO_LANGUAGE_PROGRESS, true)
                apply()
            }
            
            return LanguageProgress(progressByLanguage = migratedProgress)
        }

        // Load progress for all languages
        val languages = listOf("en", "ar", "tr")
        val progressByLanguage = languages.associateWith { language ->
            getProgressForLanguage(language)
        }
        
        return LanguageProgress(progressByLanguage = progressByLanguage)
    }

    /**
     * @deprecated Use saveProgressForLanguage instead. Kept for backward compatibility.
     */
    fun saveProgress(progress: GameProgress) {
        // Save to current language for backward compatibility
        val currentLanguage = getLanguage()
        saveProgressForLanguage(currentLanguage, progress)
        
        // Also save to old format for migration purposes
        val completedLevels =
            progress.levelStars.filterValues { it >= GameProgress.MAX_STARS }.keys.map { it.toString() }.toSet()

        prefs.edit().apply {
            putInt(KEY_HIGHEST_UNLOCKED_LEVEL, progress.highestUnlockedLevel)
            putStringSet(KEY_COMPLETED_LEVELS, completedLevels)
            putString(KEY_LEVEL_STARS, serializeLevelStars(progress.levelStars))
            apply()
        }
    }

    /**
     * @deprecated Use getProgressForLanguage instead. Kept for backward compatibility.
     */
    fun getProgress(): GameProgress {
        // Try to get from current language first
        val currentLanguage = getLanguage()
        val languageProgress = getProgressForLanguage(currentLanguage)
        
        // If no progress exists for this language, check old format
        if (languageProgress.highestUnlockedLevel == 1 && languageProgress.levelStars.isEmpty()) {
            val highestLevel = prefs.getInt(KEY_HIGHEST_UNLOCKED_LEVEL, 1)
            val completedLevelsStrings = prefs.getStringSet(KEY_COMPLETED_LEVELS, emptySet()) ?: emptySet()
            val legacyStars = completedLevelsStrings.mapNotNull { it.toIntOrNull() }
                .associateWith { GameProgress.MAX_STARS }
            val serializedStars = prefs.getString(KEY_LEVEL_STARS, null)
            val storedStars = deserializeLevelStars(serializedStars)

            val mergedStars = buildMap {
                putAll(legacyStars)
                putAll(storedStars)
            }

            return GameProgress(
                highestUnlockedLevel = highestLevel,
                levelStars = mergedStars
            )
        }
        
        return languageProgress
    }

    fun resetProgress() {
        // Reset all language progress
        val languages = listOf("en", "ar", "tr")
        prefs.edit().apply {
            languages.forEach { language ->
                val keyPrefix = "$KEY_LANGUAGE_PROGRESS_PREFIX$language"
                putInt("${keyPrefix}_highest", 1)
                putStringSet("${keyPrefix}_completed", emptySet())
                remove("${keyPrefix}_stars")
            }
            // Also reset old format
            putInt(KEY_HIGHEST_UNLOCKED_LEVEL, 1)
            putStringSet(KEY_COMPLETED_LEVELS, emptySet())
            remove(KEY_LEVEL_STARS)
            remove(KEY_AD_UNLOCKED_LEVELS)
            remove(KEY_AD_UNLOCKED_ANIMALS)
            remove(KEY_AD_UNLOCKED_COMPARISONS)
            apply()
        }
    }

    fun getAdUnlockedLevels(): Set<Int> {
        val stored = prefs.getStringSet(KEY_AD_UNLOCKED_LEVELS, emptySet()).orEmpty()
        return stored.mapNotNull { it.toIntOrNull() }.toSet()
    }

    fun saveAdUnlockedLevels(levels: Set<Int>) {
        val serialized = levels.map { it.toString() }.toSet()
        prefs.edit().putStringSet(KEY_AD_UNLOCKED_LEVELS, serialized).apply()
    }

    fun getAdUnlockedAnimals(): Set<String> {
        return prefs.getStringSet(KEY_AD_UNLOCKED_ANIMALS, emptySet()).orEmpty()
    }

    fun saveAdUnlockedAnimals(animalNames: Set<String>) {
        prefs.edit().putStringSet(KEY_AD_UNLOCKED_ANIMALS, animalNames.toSet()).apply()
    }

    fun getAdUnlockedComparisons(): Set<String> {
        return prefs.getStringSet(KEY_AD_UNLOCKED_COMPARISONS, emptySet()).orEmpty()
    }

    fun saveAdUnlockedComparisons(comparisonIds: Set<String>) {
        prefs.edit().putStringSet(KEY_AD_UNLOCKED_COMPARISONS, comparisonIds.toSet()).apply()
    }

    private fun serializeLevelStars(levelStars: Map<Int, Int>): String {
        if (levelStars.isEmpty()) return ""
        return levelStars.entries.joinToString(separator = ",") { "${it.key}:${it.value}" }
    }

    private fun deserializeLevelStars(serialized: String?): Map<Int, Int> {
        if (serialized.isNullOrBlank()) return emptyMap()
        return serialized.split(",")
            .mapNotNull { entry ->
                val parts = entry.split(":")
                if (parts.size == 2) {
                    val level = parts[0].toIntOrNull()
                    val stars = parts[1].toIntOrNull()
                    if (level != null && stars != null) {
                        level to stars.coerceIn(0, 3)
                    } else {
                        null
                    }
                } else {
                    null
                }
            }
            .toMap()
    }
}



