package com.shahadalrubaye.kidsstorybook.models

enum class AgeGroup(val displayNameEn: String, val displayNameAr: String, val displayNameTr: String) {
    AGE_2_4("2-4 years", "2-4 سنوات", "2-4 yaş"),
    AGE_5_6("5-6 years", "5-6 سنوات", "5-6 yaş");

    fun getDisplayName(language: String): String {
        return when (language) {
            "ar" -> displayNameAr
            "tr" -> displayNameTr
            else -> displayNameEn
        }
    }
}

data class AppSettings(
    val language: String = "en", // en, ar, tr
    val ageGroup: AgeGroup = AgeGroup.AGE_2_4,
    val playerName: String = ""
)



