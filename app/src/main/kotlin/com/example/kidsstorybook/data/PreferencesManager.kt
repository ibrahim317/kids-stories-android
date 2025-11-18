package com.example.kidsstorybook.data

import android.content.Context
import android.content.SharedPreferences
import com.example.kidsstorybook.models.AgeGroup
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.GameProgress

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

    fun saveProgress(progress: GameProgress) {
        val completedLevels =
            progress.levelStars.filterValues { it >= GameProgress.MAX_STARS }.keys.map { it.toString() }.toSet()

        prefs.edit().apply {
            putInt(KEY_HIGHEST_UNLOCKED_LEVEL, progress.highestUnlockedLevel)
            putStringSet(KEY_COMPLETED_LEVELS, completedLevels)
            putString(KEY_LEVEL_STARS, serializeLevelStars(progress.levelStars))
            apply()
        }
    }

    fun getProgress(): GameProgress {
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

    fun resetProgress() {
        prefs.edit().apply {
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



