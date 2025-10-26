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
        private const val KEY_HIGHEST_UNLOCKED_LEVEL = "highest_unlocked_level"
        private const val KEY_COMPLETED_LEVELS = "completed_levels"
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
        val name = prefs.getString(KEY_AGE_GROUP, AgeGroup.AGE_3_4.name)
        return try {
            AgeGroup.valueOf(name ?: AgeGroup.AGE_3_4.name)
        } catch (e: IllegalArgumentException) {
            AgeGroup.AGE_3_4
        }
    }

    fun saveSettings(settings: AppSettings) {
        prefs.edit().apply {
            putString(KEY_LANGUAGE, settings.language)
            putString(KEY_AGE_GROUP, settings.ageGroup.name)
            apply()
        }
    }

    fun getSettings(): AppSettings {
        return AppSettings(
            language = getLanguage(),
            ageGroup = getAgeGroup()
        )
    }

    fun saveProgress(progress: GameProgress) {
        prefs.edit().apply {
            putInt(KEY_HIGHEST_UNLOCKED_LEVEL, progress.highestUnlockedLevel)
            putStringSet(KEY_COMPLETED_LEVELS, progress.completedLevels.map { it.toString() }.toSet())
            apply()
        }
    }

    fun getProgress(): GameProgress {
        val highestLevel = prefs.getInt(KEY_HIGHEST_UNLOCKED_LEVEL, 1)
        val completedLevelsStrings = prefs.getStringSet(KEY_COMPLETED_LEVELS, emptySet()) ?: emptySet()
        val completedLevels = completedLevelsStrings.mapNotNull { it.toIntOrNull() }.toSet()
        
        return GameProgress(
            highestUnlockedLevel = highestLevel,
            completedLevels = completedLevels
        )
    }

    fun resetProgress() {
        prefs.edit().apply {
            putInt(KEY_HIGHEST_UNLOCKED_LEVEL, 1)
            putStringSet(KEY_COMPLETED_LEVELS, emptySet())
            apply()
        }
    }
}

