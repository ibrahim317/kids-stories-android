package com.example.kidsstorybook.models

data class Story(
    val id: Int,
    val englishTitle: String,
    val arabicTitle: String,
    val turkishTitle: String,
    val englishImagePaths: List<String> = emptyList(),
    val arabicImagePaths: List<String> = emptyList(),
    val turkishImagePaths: List<String> = emptyList(),
    val englishAudioPath: String? = null,
    val arabicAudioPath: String? = null,
    val turkishAudioPath: String? = null,
    var isFavorite: Boolean = false
) {
    fun getTitle(language: String): String {
        return when (language) {
            "ar" -> arabicTitle
            "tr" -> turkishTitle
            else -> englishTitle
        }
    }

    fun getImagePaths(language: String): List<String> {
        return when (language) {
            "ar" -> arabicImagePaths
            "tr" -> turkishImagePaths
            else -> englishImagePaths
        }
    }

    fun getAudioPath(language: String): String? {
        return when (language) {
            "ar" -> arabicAudioPath
            "tr" -> turkishAudioPath
            else -> englishAudioPath
        }
    }
}

