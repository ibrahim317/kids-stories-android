package com.example.kidsstorybook.data

import com.example.kidsstorybook.models.Story

object StoryRepository {
    private val stories = listOf(
        Story(
            id = 1,
            englishTitle = "The Lion and the Mouse",
            arabicTitle = "الأسد والفأر",
            turkishTitle = "Aslan ve Fare",
            englishImagePaths = listOf(
                "stories/lion_mouse/en/img_1.jpg",
                "stories/lion_mouse/en/img_2.jpg",
                "stories/lion_mouse/en/img_3.jpg",
                "stories/lion_mouse/en/img_4.jpg",
                "stories/lion_mouse/en/img_5.jpg",
                "stories/lion_mouse/en/img_6.jpg",
                "stories/lion_mouse/en/img_7.jpg"
            ),
            arabicImagePaths = listOf(
                "stories/lion_mouse/ar/img_1.jpg",
                "stories/lion_mouse/ar/img_2.jpg",
                "stories/lion_mouse/ar/img_3.jpg",
                "stories/lion_mouse/ar/img_4.jpg",
                "stories/lion_mouse/ar/img_5.jpg",
                "stories/lion_mouse/ar/img_6.jpg",
                "stories/lion_mouse/ar/img_7.jpg"
            ),
            turkishImagePaths = listOf(
                "stories/lion_mouse/tr/img_1.jpg",
                "stories/lion_mouse/tr/img_2.jpg",
                "stories/lion_mouse/tr/img_3.jpg",
                "stories/lion_mouse/tr/img_4.jpg",
                "stories/lion_mouse/tr/img_5.jpg",
                "stories/lion_mouse/tr/img_6.jpg",
                "stories/lion_mouse/tr/img_7.jpg"
            ),
            englishAudioPath = "stories/lion_mouse/en/audio.wav",
            arabicAudioPath = "stories/lion_mouse/ar/audio.wav",
            turkishAudioPath = "stories/lion_mouse/tr/audio.wav"
        ),
        Story(
            id = 2,
            englishTitle = "The Fox and the Crow",
            arabicTitle = "الثعلب والغراب",
            turkishTitle = "Tilki ve Karga",
            englishImagePaths = listOf(
                "stories/fox_crow/en/img_awal.png",
                "stories/fox_crow/en/img_1.png",
                "stories/fox_crow/en/img_2.png",
                "stories/fox_crow/en/img_3.png",
                "stories/fox_crow/en/img_4.png",
                "stories/fox_crow/en/img_5.png"
            ),
            arabicImagePaths = listOf(
                "stories/fox_crow/ar/img_awal.png",
                "stories/fox_crow/ar/img_1.png",
                "stories/fox_crow/ar/img_2.png",
                "stories/fox_crow/ar/img_3.png",
                "stories/fox_crow/ar/img_4.png",
                "stories/fox_crow/ar/img_5.png"
            ),
            turkishImagePaths = listOf(
                "stories/fox_crow/tr/img_awal.png",
                "stories/fox_crow/tr/img_1.png",
                "stories/fox_crow/tr/img_2.png",
                "stories/fox_crow/tr/img_3.png",
                "stories/fox_crow/tr/img_4.png",
                "stories/fox_crow/tr/img_5.png"
            ),
            englishAudioPath = "stories/fox_crow/en/audio.wav",
            arabicAudioPath = "stories/fox_crow/ar/audio.wav",
            turkishAudioPath = "stories/fox_crow/tr/audio.wav"
        )
    )

    // Map levels to stories (repeating stories for levels 3 and 4)
    private val levelToStoryMap = mapOf(
        1 to 1, // Level 1 -> Lion and Mouse
        2 to 2, // Level 2 -> Fox and Crow
        3 to 1, // Level 3 -> Lion and Mouse (replay)
        4 to 2  // Level 4 -> Fox and Crow (replay)
    )

    fun getAllStories(): List<Story> = stories

    fun getStoryById(id: Int): Story? = stories.find { it.id == id }

    fun getStoryForLevel(level: Int): Story? {
        val storyId = levelToStoryMap[level] ?: return null
        return getStoryById(storyId)
    }

    fun getTotalLevels(): Int = levelToStoryMap.size
}

