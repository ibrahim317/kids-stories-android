package com.shahadalrubaye.kidsstorybook.models

data class Animal(
    val name: String, // folder name (e.g., "bear", "cat")
    val englishName: String,
    val arabicName: String,
    val turkishName: String,
    val imagePath: String, // "animals/{name}/image.webp"
    val englishAudioPath: String,
    val arabicAudioPath: String,
    val turkishAudioPath: String
) {
    fun getDisplayName(language: String): String {
        return when (language) {
            "ar" -> arabicName
            "tr" -> turkishName
            else -> englishName
        }
    }
    
    fun getAudioPath(language: String): String {
        return when (language) {
            "ar" -> arabicAudioPath
            "tr" -> turkishAudioPath
            else -> englishAudioPath
        }
    }
}

