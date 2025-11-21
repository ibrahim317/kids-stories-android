package com.example.kidsstorybook.data

import com.example.kidsstorybook.models.Story

object StoryRepository {
    private val stories = listOf(

        Story(
            id = 1,
            englishTitle = "Barnaby Bear and the Big Red Ball",
            arabicTitle = "بارنابي الدب والكرة الحمراء الكبيرة",
            turkishTitle = "Barnaby Ayı ve Büyük Kırmızı Top",
            englishImagePaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/en/cover.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/1.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/2.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/3.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/4.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/5.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/6.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/7.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/8.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/9.png",
                "stories/barnaby_bear_and_the_big_red_ball/en/10.png"
            ),
            arabicImagePaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/ar/cover.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/1.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/2.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/3.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/4.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/5.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/6.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/7.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/8.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/9.png",
                "stories/barnaby_bear_and_the_big_red_ball/ar/10.png"
            ),
            turkishImagePaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/tr/cover.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/1.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/2.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/3.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/4.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/5.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/6.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/7.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/8.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/9.png",
                "stories/barnaby_bear_and_the_big_red_ball/tr/10.png"
            ),
            englishAudioPaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/1.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/2.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/3.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/4.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/5.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/6.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/7.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/8.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/9.wav",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/10.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/1.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/2.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/3.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/4.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/5.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/6.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/7.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/8.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/9.wav",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/10.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/1.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/2.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/3.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/4.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/5.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/6.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/7.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/8.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/9.wav",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/10.wav"
            )
        ),
        Story(
            id = 2,
            englishTitle = "The Fox and the Crow",
            arabicTitle = "الثعلب والغراب",
            turkishTitle = "Tilki ve Karga",
            englishImagePaths = listOf(
                "stories/fox_crow/en/cover.png",
                "stories/fox_crow/en/1.png",
                "stories/fox_crow/en/2.png",
                "stories/fox_crow/en/3.png",
                "stories/fox_crow/en/4.png",
                "stories/fox_crow/en/5.png"
            ),
            arabicImagePaths = listOf(
                "stories/fox_crow/ar/cover.png",
                "stories/fox_crow/ar/1.png",
                "stories/fox_crow/ar/2.png",
                "stories/fox_crow/ar/3.png",
                "stories/fox_crow/ar/4.png",
                "stories/fox_crow/ar/5.png"
            ),
            turkishImagePaths = listOf(
                "stories/fox_crow/tr/cover.png",
                "stories/fox_crow/tr/1.png",
                "stories/fox_crow/tr/2.png",
                "stories/fox_crow/tr/3.png",
                "stories/fox_crow/tr/4.png",
                "stories/fox_crow/tr/5.png"
            ),
            englishAudioPaths = listOf(
                "stories/fox_crow/en/sound/1.wav",
                "stories/fox_crow/en/sound/2.wav",
                "stories/fox_crow/en/sound/3.wav",
                "stories/fox_crow/en/sound/4.wav",
                "stories/fox_crow/en/sound/5.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/fox_crow/ar/sound/1.wav",
                "stories/fox_crow/ar/sound/2.wav",
                "stories/fox_crow/ar/sound/3.wav",
                "stories/fox_crow/ar/sound/4.wav",
                "stories/fox_crow/ar/sound/5.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/fox_crow/tr/sound/1.wav",
                "stories/fox_crow/tr/sound/2.wav",
                "stories/fox_crow/tr/sound/3.wav",
                "stories/fox_crow/tr/sound/4.wav",
                "stories/fox_crow/tr/sound/5.wav"
            )
        ),
        Story(
            id = 3,
            englishTitle = "The Lion and the Mouse",
            arabicTitle = "الأسد والفأر",
            turkishTitle = "Aslan ve Fare",
            englishImagePaths = listOf(
                "stories/lion_mouse/en/cover.png",
                "stories/lion_mouse/en/1.png",
                "stories/lion_mouse/en/2.png",
                "stories/lion_mouse/en/3.png",
                "stories/lion_mouse/en/4.png",
                "stories/lion_mouse/en/5.png",
                "stories/lion_mouse/en/6.png",
            ),
            arabicImagePaths = listOf(
                "stories/lion_mouse/ar/cover.png",
                "stories/lion_mouse/ar/1.png",
                "stories/lion_mouse/ar/2.png",
                "stories/lion_mouse/ar/3.png",
                "stories/lion_mouse/ar/4.png",
                "stories/lion_mouse/ar/5.png",
                "stories/lion_mouse/ar/6.png",
            ),
            turkishImagePaths = listOf(
                "stories/lion_mouse/tr/cover.png",
                "stories/lion_mouse/tr/1.png",
                "stories/lion_mouse/tr/2.png",
                "stories/lion_mouse/tr/3.png",
                "stories/lion_mouse/tr/4.png",
                "stories/lion_mouse/tr/5.png",
                "stories/lion_mouse/tr/6.png",
            ),
            englishAudioPaths = listOf(
                "stories/lion_mouse/en/sound/cover.wav",
                "stories/lion_mouse/en/sound/1.wav",
                "stories/lion_mouse/en/sound/2.wav",
                "stories/lion_mouse/en/sound/3.wav",
                "stories/lion_mouse/en/sound/4.wav",
                "stories/lion_mouse/en/sound/5.wav",
                "stories/lion_mouse/en/sound/6.wav",
            ),
            arabicAudioPaths = listOf(
                "stories/lion_mouse/ar/sound/cover.wav",
                "stories/lion_mouse/ar/sound/1.wav",
                "stories/lion_mouse/ar/sound/2.wav",
                "stories/lion_mouse/ar/sound/3.wav",
                "stories/lion_mouse/ar/sound/4.wav",
                "stories/lion_mouse/ar/sound/5.wav",
                "stories/lion_mouse/ar/sound/6.wav",
            ),
            turkishAudioPaths = listOf(
                "stories/lion_mouse/tr/sound/cover.wav",
                "stories/lion_mouse/tr/sound/1.wav",
                "stories/lion_mouse/tr/sound/2.wav",
                "stories/lion_mouse/tr/sound/3.wav",
                "stories/lion_mouse/tr/sound/4.wav",
                "stories/lion_mouse/tr/sound/5.wav",
                "stories/lion_mouse/tr/sound/6.wav",
            )
        )
        Story(
            id = 4,
            englishTitle = "Big and Small Cat",
            arabicTitle = "القطة الكبيرة والصغيرة",
            turkishTitle = "Büyük ve Küçük Kedi",
            englishImagePaths = listOf(
                "stories/big_and_small_cat/en/cover.png",
                "stories/big_and_small_cat/en/1.png",
                "stories/big_and_small_cat/en/2.png",
                "stories/big_and_small_cat/en/3.png",
                "stories/big_and_small_cat/en/4.png",
                "stories/big_and_small_cat/en/5.png",
                "stories/big_and_small_cat/en/6.png",
                "stories/big_and_small_cat/en/7.png"
            ),
            arabicImagePaths = listOf(
                "stories/big_and_small_cat/ar/cover.png",
                "stories/big_and_small_cat/ar/1.png",
                "stories/big_and_small_cat/ar/2.png",
                "stories/big_and_small_cat/ar/3.png",
                "stories/big_and_small_cat/ar/4.png",
                "stories/big_and_small_cat/ar/5.png",
                "stories/big_and_small_cat/ar/6.png",
                "stories/big_and_small_cat/ar/7.png"
            ),
            turkishImagePaths = listOf(
                "stories/big_and_small_cat/tr/cover.png",
                "stories/big_and_small_cat/tr/1.png",
                "stories/big_and_small_cat/tr/2.png",
                "stories/big_and_small_cat/tr/3.png",
                "stories/big_and_small_cat/tr/4.png",
                "stories/big_and_small_cat/tr/5.png",
                "stories/big_and_small_cat/tr/6.png",
                "stories/big_and_small_cat/tr/7.png"
            ),
            englishAudioPaths = listOf(
                "stories/big_and_small_cat/en/sound/cover.wav",
                "stories/big_and_small_cat/en/sound/1.wav",
                "stories/big_and_small_cat/en/sound/2.wav",
                "stories/big_and_small_cat/en/sound/3.wav",
                "stories/big_and_small_cat/en/sound/4.wav",
                "stories/big_and_small_cat/en/sound/5.wav",
                "stories/big_and_small_cat/en/sound/6.wav",
                "stories/big_and_small_cat/en/sound/7.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/big_and_small_cat/ar/sound/cover.wav",
                "stories/big_and_small_cat/ar/sound/1.wav",
                "stories/big_and_small_cat/ar/sound/2.wav",
                "stories/big_and_small_cat/ar/sound/3.wav",
                "stories/big_and_small_cat/ar/sound/4.wav",
                "stories/big_and_small_cat/ar/sound/5.wav",
                "stories/big_and_small_cat/ar/sound/6.wav",
                "stories/big_and_small_cat/ar/sound/7.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/big_and_small_cat/tr/sound/cover.wav"
                "stories/big_and_small_cat/tr/sound/1.wav",
                "stories/big_and_small_cat/tr/sound/2.wav",
                "stories/big_and_small_cat/tr/sound/3.wav",
                "stories/big_and_small_cat/tr/sound/4.wav",
                "stories/big_and_small_cat/tr/sound/5.wav",
                "stories/big_and_small_cat/tr/sound/6.wav",
                "stories/big_and_small_cat/tr/sound/7.wav"
            )
        ),
        Story(
            id = 5,
            englishTitle = "Choo-Choo to Bedtime",
            arabicTitle = "تشو-تشو إلى وقت النوم",
            turkishTitle = "Choo-Choo Uyku Zamanı",
            englishImagePaths = listOf(
                "stories/choo-choo_to_bedtime/en/cover.png",
                "stories/choo-choo_to_bedtime/en/1.png",
                "stories/choo-choo_to_bedtime/en/2.png",
                "stories/choo-choo_to_bedtime/en/3.png",
                "stories/choo-choo_to_bedtime/en/4.png",
                "stories/choo-choo_to_bedtime/en/5.png",
                "stories/choo-choo_to_bedtime/en/6.png",
                "stories/choo-choo_to_bedtime/en/7.png",
                "stories/choo-choo_to_bedtime/en/8.png"
            ),
            arabicImagePaths = listOf(
                "stories/choo-choo_to_bedtime/ar/cover.png",
                "stories/choo-choo_to_bedtime/ar/1.png",
                "stories/choo-choo_to_bedtime/ar/2.png",
                "stories/choo-choo_to_bedtime/ar/3.png",
                "stories/choo-choo_to_bedtime/ar/4.png",
                "stories/choo-choo_to_bedtime/ar/5.png",
                "stories/choo-choo_to_bedtime/ar/6.png",
                "stories/choo-choo_to_bedtime/ar/7.png",
                "stories/choo-choo_to_bedtime/ar/8.png"
            ),
            turkishImagePaths = listOf(
                "stories/choo-choo_to_bedtime/tr/cover.png",
                "stories/choo-choo_to_bedtime/tr/1.png",
                "stories/choo-choo_to_bedtime/tr/2.png",
                "stories/choo-choo_to_bedtime/tr/3.png",
                "stories/choo-choo_to_bedtime/tr/4.png",
                "stories/choo-choo_to_bedtime/tr/5.png",
                "stories/choo-choo_to_bedtime/tr/6.png",
                "stories/choo-choo_to_bedtime/tr/7.png",
                "stories/choo-choo_to_bedtime/tr/8.png"
            ),
            englishAudioPaths = listOf(
                "stories/choo-choo_to_bedtime/en/sound/cover.wav",
                "stories/choo-choo_to_bedtime/en/sound/1.wav",
                "stories/choo-choo_to_bedtime/en/sound/2.wav",
                "stories/choo-choo_to_bedtime/en/sound/3.wav",
                "stories/choo-choo_to_bedtime/en/sound/4.wav",
                "stories/choo-choo_to_bedtime/en/sound/5.wav",
                "stories/choo-choo_to_bedtime/en/sound/6.wav",
                "stories/choo-choo_to_bedtime/en/sound/7.wav",
                "stories/choo-choo_to_bedtime/en/sound/8.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/choo-choo_to_bedtime/ar/sound/cover.wav",
                "stories/choo-choo_to_bedtime/ar/sound/1.wav",
                "stories/choo-choo_to_bedtime/ar/sound/2.wav",
                "stories/choo-choo_to_bedtime/ar/sound/3.wav",
                "stories/choo-choo_to_bedtime/ar/sound/4.wav",
                "stories/choo-choo_to_bedtime/ar/sound/5.wav",
                "stories/choo-choo_to_bedtime/ar/sound/6.wav",
                "stories/choo-choo_to_bedtime/ar/sound/7.wav",
                "stories/choo-choo_to_bedtime/ar/sound/8.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/choo-choo_to_bedtime/tr/sound/cover.wav",
                "stories/choo-choo_to_bedtime/tr/sound/1.wav",
                "stories/choo-choo_to_bedtime/tr/sound/2.wav",
                "stories/choo-choo_to_bedtime/tr/sound/3.wav",
                "stories/choo-choo_to_bedtime/tr/sound/4.wav",
                "stories/choo-choo_to_bedtime/tr/sound/5.wav",
                "stories/choo-choo_to_bedtime/tr/sound/6.wav",
                "stories/choo-choo_to_bedtime/tr/sound/7.wav",
                "stories/choo-choo_to_bedtime/tr/sound/8.wav"
            )
        ),
        Story(
            id = 6,
            englishTitle = "Leo the Little Astronaut",
            arabicTitle = "ليو رائد الفضاء الصغير",
            turkishTitle = "Küçük Astronot Leo",
            englishImagePaths = listOf(
                "stories/leo_the_little_astronaut/en/cover.png",
                "stories/leo_the_little_astronaut/en/1.png",
                "stories/leo_the_little_astronaut/en/2.png",
                "stories/leo_the_little_astronaut/en/3.png",
                "stories/leo_the_little_astronaut/en/4.png",
                "stories/leo_the_little_astronaut/en/5.jpg",
                "stories/leo_the_little_astronaut/en/6.jpg"
            ),
            arabicImagePaths = listOf(
                "stories/leo_the_little_astronaut/ar/cover.png",
                "stories/leo_the_little_astronaut/ar/1.png",
                "stories/leo_the_little_astronaut/ar/2.png",
                "stories/leo_the_little_astronaut/ar/3.png",
                "stories/leo_the_little_astronaut/ar/4.png",
                "stories/leo_the_little_astronaut/ar/5.jpg",
                "stories/leo_the_little_astronaut/ar/6.jpg"
            ),
            turkishImagePaths = listOf(
                "stories/leo_the_little_astronaut/tr/cover.png",
                "stories/leo_the_little_astronaut/tr/1.png",
                "stories/leo_the_little_astronaut/tr/2.png",
                "stories/leo_the_little_astronaut/tr/3.png",
                "stories/leo_the_little_astronaut/tr/4.png",
                "stories/leo_the_little_astronaut/tr/5.jpg",
                "stories/leo_the_little_astronaut/tr/6.jpg"
            ),
            englishAudioPaths = listOf(
                "stories/leo_the_little_astronaut/en/sound/cover.wav",
                "stories/leo_the_little_astronaut/en/sound/1.wav",
                "stories/leo_the_little_astronaut/en/sound/2.wav",
                "stories/leo_the_little_astronaut/en/sound/3.wav",
                "stories/leo_the_little_astronaut/en/sound/4.wav",
                "stories/leo_the_little_astronaut/en/sound/5.wav",
                "stories/leo_the_little_astronaut/en/sound/6.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/leo_the_little_astronaut/ar/sound/cover.wav",
                "stories/leo_the_little_astronaut/ar/sound/1.wav",
                "stories/leo_the_little_astronaut/ar/sound/2.wav",
                "stories/leo_the_little_astronaut/ar/sound/3.wav",
                "stories/leo_the_little_astronaut/ar/sound/4.wav",
                "stories/leo_the_little_astronaut/ar/sound/5.wav",
                "stories/leo_the_little_astronaut/ar/sound/6.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/leo_the_little_astronaut/tr/sound/cover.wav",
                "stories/leo_the_little_astronaut/tr/sound/1.wav",
                "stories/leo_the_little_astronaut/tr/sound/2.wav",
                "stories/leo_the_little_astronaut/tr/sound/3.wav",
                "stories/leo_the_little_astronaut/tr/sound/4.wav",
                "stories/leo_the_little_astronaut/tr/sound/5.wav",
                "stories/leo_the_little_astronaut/tr/sound/6.wav"
            )
        ),
        Story(
            id = 7,
            englishTitle = "Lila the Flying Butterfly",
            arabicTitle = "ليلى الفراشة الطائرة",
            turkishTitle = "Uçan Kelebek Lila",
            englishImagePaths = listOf(
                "stories/lila_the_flying_butterfly/en/cover.png",
                "stories/lila_the_flying_butterfly/en/1.png",
                "stories/lila_the_flying_butterfly/en/2.png",
                "stories/lila_the_flying_butterfly/en/3.png",
                "stories/lila_the_flying_butterfly/en/4.png",
                "stories/lila_the_flying_butterfly/en/5.png",
                "stories/lila_the_flying_butterfly/en/6.png",
                "stories/lila_the_flying_butterfly/en/7.png",
                "stories/lila_the_flying_butterfly/en/8.png"
            ),
            arabicImagePaths = listOf(
                "stories/lila_the_flying_butterfly/ar/cover.png",
                "stories/lila_the_flying_butterfly/ar/1.png",
                "stories/lila_the_flying_butterfly/ar/2.png",
                "stories/lila_the_flying_butterfly/ar/3.png",
                "stories/lila_the_flying_butterfly/ar/4.png",
                "stories/lila_the_flying_butterfly/ar/5.png",
                "stories/lila_the_flying_butterfly/ar/6.png",
                "stories/lila_the_flying_butterfly/ar/7.png",
                "stories/lila_the_flying_butterfly/ar/8.png"
            ),
            turkishImagePaths = listOf(
                "stories/lila_the_flying_butterfly/tr/cover.png",
                "stories/lila_the_flying_butterfly/tr/1.png",
                "stories/lila_the_flying_butterfly/tr/2.png",
                "stories/lila_the_flying_butterfly/tr/3.png",
                "stories/lila_the_flying_butterfly/tr/4.png",
                "stories/lila_the_flying_butterfly/tr/5.png",
                "stories/lila_the_flying_butterfly/tr/6.png",
                "stories/lila_the_flying_butterfly/tr/7.png",
                "stories/lila_the_flying_butterfly/tr/8.png"
            ),
            englishAudioPaths = listOf(
                "stories/lila_the_flying_butterfly/en/sound/cover.wav",
                "stories/lila_the_flying_butterfly/en/sound/1.wav",
                "stories/lila_the_flying_butterfly/en/sound/2.wav",
                "stories/lila_the_flying_butterfly/en/sound/3.wav",
                "stories/lila_the_flying_butterfly/en/sound/4.wav",
                "stories/lila_the_flying_butterfly/en/sound/5.wav",
                "stories/lila_the_flying_butterfly/en/sound/6.wav",
                "stories/lila_the_flying_butterfly/en/sound/7.wav",
                "stories/lila_the_flying_butterfly/en/sound/8.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/lila_the_flying_butterfly/ar/sound/cover.wav",
                "stories/lila_the_flying_butterfly/ar/sound/1.wav",
                "stories/lila_the_flying_butterfly/ar/sound/2.wav",
                "stories/lila_the_flying_butterfly/ar/sound/3.wav",
                "stories/lila_the_flying_butterfly/ar/sound/4.wav",
                "stories/lila_the_flying_butterfly/ar/sound/5.wav",
                "stories/lila_the_flying_butterfly/ar/sound/6.wav",
                "stories/lila_the_flying_butterfly/ar/sound/7.wav",
                "stories/lila_the_flying_butterfly/ar/sound/8.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/lila_the_flying_butterfly/tr/sound/cover.wav",
                "stories/lila_the_flying_butterfly/tr/sound/1.wav",
                "stories/lila_the_flying_butterfly/tr/sound/2.wav",
                "stories/lila_the_flying_butterfly/tr/sound/3.wav",
                "stories/lila_the_flying_butterfly/tr/sound/4.wav",
                "stories/lila_the_flying_butterfly/tr/sound/5.wav",
                "stories/lila_the_flying_butterfly/tr/sound/6.wav",
                "stories/lila_the_flying_butterfly/tr/sound/7.wav",
                "stories/lila_the_flying_butterfly/tr/sound/8.wav"
            )
        ),
        Story(
            id = 8,
            englishTitle = "Lily the Ladybug's Colors",
            arabicTitle = "ألوان الدعسوقة ليلي",
            turkishTitle = "Uğurböceği Lily'nin Renkleri",
            englishImagePaths = listOf(
                "stories/lily_the_ladybugs_colors/en/cover.png",
                "stories/lily_the_ladybugs_colors/en/1.png",
                "stories/lily_the_ladybugs_colors/en/2.png",
                "stories/lily_the_ladybugs_colors/en/3.png",
                "stories/lily_the_ladybugs_colors/en/4.png"
            ),
            arabicImagePaths = listOf(
                "stories/lily_the_ladybugs_colors/ar/cover.png",
                "stories/lily_the_ladybugs_colors/ar/1.png",
                "stories/lily_the_ladybugs_colors/ar/2.png",
                "stories/lily_the_ladybugs_colors/ar/3.png",
                "stories/lily_the_ladybugs_colors/ar/4.png"
            ),
            turkishImagePaths = listOf(
                "stories/lily_the_ladybugs_colors/tr/cover.png",
                "stories/lily_the_ladybugs_colors/tr/1.png",
                "stories/lily_the_ladybugs_colors/tr/2.png",
                "stories/lily_the_ladybugs_colors/tr/3.png",
                "stories/lily_the_ladybugs_colors/tr/4.png"
            ),
            englishAudioPaths = listOf(
                "stories/lily_the_ladybugs_colors/en/sound/cover.wav",
                "stories/lily_the_ladybugs_colors/en/sound/1.wav",
                "stories/lily_the_ladybugs_colors/en/sound/2.wav",
                "stories/lily_the_ladybugs_colors/en/sound/3.wav",
                "stories/lily_the_ladybugs_colors/en/sound/4.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/lily_the_ladybugs_colors/ar/sound/cover.wav",
                "stories/lily_the_ladybugs_colors/ar/sound/1.wav",
                "stories/lily_the_ladybugs_colors/ar/sound/2.wav",
                "stories/lily_the_ladybugs_colors/ar/sound/3.wav",
                "stories/lily_the_ladybugs_colors/ar/sound/4.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/lily_the_ladybugs_colors/tr/sound/cover.wav",
                "stories/lily_the_ladybugs_colors/tr/sound/1.wav",
                "stories/lily_the_ladybugs_colors/tr/sound/2.wav",
                "stories/lily_the_ladybugs_colors/tr/sound/3.wav",
                "stories/lily_the_ladybugs_colors/tr/sound/4.wav"
            )
        ),
        Story(
            id = 9,
            englishTitle = "Little Bear Honey's Picnic",
            arabicTitle = "نزهة الدب الصغير هوني",
            turkishTitle = "Küçük Ayı Honey'nin Pikniği",
            englishImagePaths = listOf(
                "stories/little_bear_honeys_picnic/en/cover.png",
                "stories/little_bear_honeys_picnic/en/1.png",
                "stories/little_bear_honeys_picnic/en/2.png",
                "stories/little_bear_honeys_picnic/en/3.png",
                "stories/little_bear_honeys_picnic/en/4.png",
                "stories/little_bear_honeys_picnic/en/5.png",
                "stories/little_bear_honeys_picnic/en/6.png",
                "stories/little_bear_honeys_picnic/en/7.png"
            ),
            arabicImagePaths = listOf(
                "stories/little_bear_honeys_picnic/ar/cover.png",
                "stories/little_bear_honeys_picnic/ar/1.png",
                "stories/little_bear_honeys_picnic/ar/2.png",
                "stories/little_bear_honeys_picnic/ar/3.png",
                "stories/little_bear_honeys_picnic/ar/4.png",
                "stories/little_bear_honeys_picnic/ar/5.png",
                "stories/little_bear_honeys_picnic/ar/6.png",
                "stories/little_bear_honeys_picnic/ar/7.png"
            ),
            turkishImagePaths = listOf(
                "stories/little_bear_honeys_picnic/tr/cover.png",
                "stories/little_bear_honeys_picnic/tr/1.png",
                "stories/little_bear_honeys_picnic/tr/2.png",
                "stories/little_bear_honeys_picnic/tr/3.png",
                "stories/little_bear_honeys_picnic/tr/4.png",
                "stories/little_bear_honeys_picnic/tr/5.png",
                "stories/little_bear_honeys_picnic/tr/6.png",
                "stories/little_bear_honeys_picnic/tr/7.png"
            ),
            englishAudioPaths = listOf(
                "stories/little_bear_honeys_picnic/en/sound/cover.wav",
                "stories/little_bear_honeys_picnic/en/sound/1.wav",
                "stories/little_bear_honeys_picnic/en/sound/2.wav",
                "stories/little_bear_honeys_picnic/en/sound/3.wav",
                "stories/little_bear_honeys_picnic/en/sound/4.wav",
                "stories/little_bear_honeys_picnic/en/sound/5.wav",
                "stories/little_bear_honeys_picnic/en/sound/6.wav",
                "stories/little_bear_honeys_picnic/en/sound/7.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/little_bear_honeys_picnic/ar/sound/cover.wav",
                "stories/little_bear_honeys_picnic/ar/sound/1.wav",
                "stories/little_bear_honeys_picnic/ar/sound/2.wav",
                "stories/little_bear_honeys_picnic/ar/sound/3.wav",
                "stories/little_bear_honeys_picnic/ar/sound/4.wav",
                "stories/little_bear_honeys_picnic/ar/sound/5.wav",
                "stories/little_bear_honeys_picnic/ar/sound/6.wav",
                "stories/little_bear_honeys_picnic/ar/sound/7.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/little_bear_honeys_picnic/tr/sound/cover.wav",
                "stories/little_bear_honeys_picnic/tr/sound/1.wav",
                "stories/little_bear_honeys_picnic/tr/sound/2.wav",
                "stories/little_bear_honeys_picnic/tr/sound/3.wav",
                "stories/little_bear_honeys_picnic/tr/sound/4.wav",
                "stories/little_bear_honeys_picnic/tr/sound/5.wav",
                "stories/little_bear_honeys_picnic/tr/sound/6.wav",
                "stories/little_bear_honeys_picnic/tr/sound/7.wav"
            )
        ),
        Story(
            id = 10,
            englishTitle = "Red, Yellow, Green - Traffic Light",
            arabicTitle = "أحمر، أصفر، أخضر - إشارة المرور",
            turkishTitle = "Kırmızı, Sarı, Yeşil - Trafik Işığı",
            englishImagePaths = listOf(
                "stories/red_yellow_reen_traffic_light/en/cover.png",
                "stories/red_yellow_reen_traffic_light/en/1.png",
                "stories/red_yellow_reen_traffic_light/en/2.png",
                "stories/red_yellow_reen_traffic_light/en/3.png",
                "stories/red_yellow_reen_traffic_light/en/4.png",
                "stories/red_yellow_reen_traffic_light/en/5.png",
                "stories/red_yellow_reen_traffic_light/en/6.png",
                "stories/red_yellow_reen_traffic_light/en/7.png"
            ),
            arabicImagePaths = listOf(
                "stories/red_yellow_reen_traffic_light/ar/cover.png",
                "stories/red_yellow_reen_traffic_light/ar/1.png",
                "stories/red_yellow_reen_traffic_light/ar/2.png",
                "stories/red_yellow_reen_traffic_light/ar/3.png",
                "stories/red_yellow_reen_traffic_light/ar/4.png",
                "stories/red_yellow_reen_traffic_light/ar/5.png",
                "stories/red_yellow_reen_traffic_light/ar/6.png",
                "stories/red_yellow_reen_traffic_light/ar/7.png"
            ),
            turkishImagePaths = listOf(
                "stories/red_yellow_reen_traffic_light/tr/cover.png",
                "stories/red_yellow_reen_traffic_light/tr/1.png",
                "stories/red_yellow_reen_traffic_light/tr/2.png",
                "stories/red_yellow_reen_traffic_light/tr/3.png",
                "stories/red_yellow_reen_traffic_light/tr/4.png",
                "stories/red_yellow_reen_traffic_light/tr/5.png",
                "stories/red_yellow_reen_traffic_light/tr/6.png",
                "stories/red_yellow_reen_traffic_light/tr/7.png"
            ),
            englishAudioPaths = listOf(
                "stories/red_yellow_reen_traffic_light/en/sound/cover.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/1.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/2.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/3.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/4.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/5.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/6.wav",
                "stories/red_yellow_reen_traffic_light/en/sound/7.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/red_yellow_reen_traffic_light/ar/sound/cover.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/1.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/2.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/3.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/4.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/5.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/6.wav",
                "stories/red_yellow_reen_traffic_light/ar/sound/7.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/red_yellow_reen_traffic_light/tr/sound/cover.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/1.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/2.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/3.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/4.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/5.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/6.wav",
                "stories/red_yellow_reen_traffic_light/tr/sound/7.wav"
            )
        ),
        Story(
            id = 11,
            englishTitle = "The Fingers Five",
            arabicTitle = "الأصابع الخمسة",
            turkishTitle = "Beş Parmak",
            englishImagePaths = listOf(
                "stories/the_finggers_five/en/1.png",
                "stories/the_finggers_five/en/2.png",
                "stories/the_finggers_five/en/3.png",
                "stories/the_finggers_five/en/4.png",
                "stories/the_finggers_five/en/5.png",
                "stories/the_finggers_five/en/6.png"
            ),
            arabicImagePaths = listOf(
                "stories/the_finggers_five/ar/1.png",
                "stories/the_finggers_five/ar/2.png",
                "stories/the_finggers_five/ar/3.png",
                "stories/the_finggers_five/ar/4.png",
                "stories/the_finggers_five/ar/5.png",
                "stories/the_finggers_five/ar/6.png"
            ),
            turkishImagePaths = listOf(
                "stories/the_finggers_five/tr/1.png",
                "stories/the_finggers_five/tr/2.png",
                "stories/the_finggers_five/tr/3.png",
                "stories/the_finggers_five/tr/4.png",
                "stories/the_finggers_five/tr/5.png",
                "stories/the_finggers_five/tr/6.png"
            ),
            englishAudioPaths = listOf(
                "stories/the_finggers_five/en/sound/1.wav",
                "stories/the_finggers_five/en/sound/2.wav",
                "stories/the_finggers_five/en/sound/3.wav",
                "stories/the_finggers_five/en/sound/4.wav",
                "stories/the_finggers_five/en/sound/5.wav",
                "stories/the_finggers_five/en/sound/6.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/the_finggers_five/ar/sound/1.wav",
                "stories/the_finggers_five/ar/sound/2.wav",
                "stories/the_finggers_five/ar/sound/3.wav",
                "stories/the_finggers_five/ar/sound/4.wav",
                "stories/the_finggers_five/ar/sound/5.wav",
                "stories/the_finggers_five/ar/sound/6.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/the_finggers_five/tr/sound/1.wav",
                "stories/the_finggers_five/tr/sound/2.wav",
                "stories/the_finggers_five/tr/sound/3.wav",
                "stories/the_finggers_five/tr/sound/4.wav",
                "stories/the_finggers_five/tr/sound/5.wav",
                "stories/the_finggers_five/tr/sound/6.wav"
            )
        ),
        Story(
            id = 12,
            englishTitle = "The Little Blue Train",
            arabicTitle = "القطار الأزرق الصغير",
            turkishTitle = "Küçük Mavi Tren",
            englishImagePaths = listOf(
                "stories/the_little_blue_train/en/cover.png",
                "stories/the_little_blue_train/en/1.png",
                "stories/the_little_blue_train/en/2.png",
                "stories/the_little_blue_train/en/3.png",
                "stories/the_little_blue_train/en/4.png"
            ),
            arabicImagePaths = listOf(
                "stories/the_little_blue_train/ar/cover.png",
                "stories/the_little_blue_train/ar/1.png",
                "stories/the_little_blue_train/ar/2.png",
                "stories/the_little_blue_train/ar/3.png",
                "stories/the_little_blue_train/ar/4.png"
            ),
            turkishImagePaths = listOf(
                "stories/the_little_blue_train/tr/cover.png",
                "stories/the_little_blue_train/tr/1.png",
                "stories/the_little_blue_train/tr/2.png",
                "stories/the_little_blue_train/tr/3.png",
                "stories/the_little_blue_train/tr/4.png"
            ),
            englishAudioPaths = listOf(
                "stories/the_little_blue_train/en/sound/cover.wav",
                "stories/the_little_blue_train/en/sound/1.wav",
                "stories/the_little_blue_train/en/sound/2.wav",
                "stories/the_little_blue_train/en/sound/3.wav",
                "stories/the_little_blue_train/en/sound/4.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/the_little_blue_train/ar/sound/cover.wav",
                "stories/the_little_blue_train/ar/sound/1.wav",
                "stories/the_little_blue_train/ar/sound/2.wav",
                "stories/the_little_blue_train/ar/sound/3.wav",
                "stories/the_little_blue_train/ar/sound/4.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/the_little_blue_train/tr/sound/cover.wav",
                "stories/the_little_blue_train/tr/sound/1.wav",
                "stories/the_little_blue_train/tr/sound/2.wav",
                "stories/the_little_blue_train/tr/sound/3.wav",
                "stories/the_little_blue_train/tr/sound/4.wav"
            )
        ),
        Story(
            id = 13,
            englishTitle = "The Lost Blue Sock",
            arabicTitle = "الجورب الأزرق المفقود",
            turkishTitle = "Kayıp Mavi Çorap",
            englishImagePaths = listOf(
                "stories/the_lost_blue_sock/en/cover.png",
                "stories/the_lost_blue_sock/en/1.png",
                "stories/the_lost_blue_sock/en/2.png",
                "stories/the_lost_blue_sock/en/3.png",
                "stories/the_lost_blue_sock/en/4.png",
                "stories/the_lost_blue_sock/en/5.png",
                "stories/the_lost_blue_sock/en/6.png",
                "stories/the_lost_blue_sock/en/7.png"
            ),
            arabicImagePaths = listOf(
                "stories/the_lost_blue_sock/ar/cover.png",
                "stories/the_lost_blue_sock/ar/1.png",
                "stories/the_lost_blue_sock/ar/2.png",
                "stories/the_lost_blue_sock/ar/3.png",
                "stories/the_lost_blue_sock/ar/4.png",
                "stories/the_lost_blue_sock/ar/5.png",
                "stories/the_lost_blue_sock/ar/6.png",
                "stories/the_lost_blue_sock/ar/7.png"
            ),
            turkishImagePaths = listOf(
                "stories/the_lost_blue_sock/tr/cover.png",
                "stories/the_lost_blue_sock/tr/1.png",
                "stories/the_lost_blue_sock/tr/2.png",
                "stories/the_lost_blue_sock/tr/3.png",
                "stories/the_lost_blue_sock/tr/4.png",
                "stories/the_lost_blue_sock/tr/5.png",
                "stories/the_lost_blue_sock/tr/6.png",
                "stories/the_lost_blue_sock/tr/7.png"
            ),
            englishAudioPaths = listOf(
                "stories/the_lost_blue_sock/en/sound/cover.wav",
                "stories/the_lost_blue_sock/en/sound/1.wav",
                "stories/the_lost_blue_sock/en/sound/2.wav",
                "stories/the_lost_blue_sock/en/sound/3.wav",
                "stories/the_lost_blue_sock/en/sound/4.wav",
                "stories/the_lost_blue_sock/en/sound/5.wav",
                "stories/the_lost_blue_sock/en/sound/6.wav",
                "stories/the_lost_blue_sock/en/sound/7.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/the_lost_blue_sock/ar/sound/cover.wav",
                "stories/the_lost_blue_sock/ar/sound/1.wav",
                "stories/the_lost_blue_sock/ar/sound/2.wav",
                "stories/the_lost_blue_sock/ar/sound/3.wav",
                "stories/the_lost_blue_sock/ar/sound/4.wav",
                "stories/the_lost_blue_sock/ar/sound/5.wav",
                "stories/the_lost_blue_sock/ar/sound/6.wav",
                "stories/the_lost_blue_sock/ar/sound/7.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/the_lost_blue_sock/tr/sound/cover.wav",
                "stories/the_lost_blue_sock/tr/sound/1.wav",
                "stories/the_lost_blue_sock/tr/sound/2.wav",
                "stories/the_lost_blue_sock/tr/sound/3.wav",
                "stories/the_lost_blue_sock/tr/sound/4.wav",
                "stories/the_lost_blue_sock/tr/sound/5.wav",
                "stories/the_lost_blue_sock/tr/sound/6.wav",
                "stories/the_lost_blue_sock/tr/sound/7.wav"
            )
        ),
        Story(
            id = 14,
            englishTitle = "Timmy the Tiny Turtle",
            arabicTitle = "تيمي السلحفاة الصغيرة",
            turkishTitle = "Minik Kaplumbağa Timmy",
            englishImagePaths = listOf(
                "stories/timmy_the_tiny_turtle/en/cover.png",
                "stories/timmy_the_tiny_turtle/en/1.png",
                "stories/timmy_the_tiny_turtle/en/2.png",
                "stories/timmy_the_tiny_turtle/en/3.png",
                "stories/timmy_the_tiny_turtle/en/4.png",
                "stories/timmy_the_tiny_turtle/en/5.png",
                "stories/timmy_the_tiny_turtle/en/6.png"
            ),
            arabicImagePaths = listOf(
                "stories/timmy_the_tiny_turtle/ar/cover.png",
                "stories/timmy_the_tiny_turtle/ar/1.png",
                "stories/timmy_the_tiny_turtle/ar/2.png",
                "stories/timmy_the_tiny_turtle/ar/3.png",
                "stories/timmy_the_tiny_turtle/ar/4.png",
                "stories/timmy_the_tiny_turtle/ar/5.png",
                "stories/timmy_the_tiny_turtle/ar/6.png"
            ),
            turkishImagePaths = listOf(
                "stories/timmy_the_tiny_turtle/tr/cover.png",
                "stories/timmy_the_tiny_turtle/tr/1.png",
                "stories/timmy_the_tiny_turtle/tr/2.png",
                "stories/timmy_the_tiny_turtle/tr/3.png",
                "stories/timmy_the_tiny_turtle/tr/4.png",
                "stories/timmy_the_tiny_turtle/tr/5.png",
                "stories/timmy_the_tiny_turtle/tr/6.png"
            ),
            englishAudioPaths = listOf(
                "stories/timmy_the_tiny_turtle/en/sound/cover.wav",
                "stories/timmy_the_tiny_turtle/en/sound/1.wav",
                "stories/timmy_the_tiny_turtle/en/sound/2.wav",
                "stories/timmy_the_tiny_turtle/en/sound/3.wav",
                "stories/timmy_the_tiny_turtle/en/sound/4.wav",
                "stories/timmy_the_tiny_turtle/en/sound/5.wav",
                "stories/timmy_the_tiny_turtle/en/sound/6.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/timmy_the_tiny_turtle/ar/sound/cover.wav",
                "stories/timmy_the_tiny_turtle/ar/sound/1.wav",
                "stories/timmy_the_tiny_turtle/ar/sound/2.wav",
                "stories/timmy_the_tiny_turtle/ar/sound/3.wav",
                "stories/timmy_the_tiny_turtle/ar/sound/4.wav",
                "stories/timmy_the_tiny_turtle/ar/sound/5.wav",
                "stories/timmy_the_tiny_turtle/ar/sound/6.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/timmy_the_tiny_turtle/tr/sound/cover.wav",
                "stories/timmy_the_tiny_turtle/tr/sound/1.wav",
                "stories/timmy_the_tiny_turtle/tr/sound/2.wav",
                "stories/timmy_the_tiny_turtle/tr/sound/3.wav",
                "stories/timmy_the_tiny_turtle/tr/sound/4.wav",
                "stories/timmy_the_tiny_turtle/tr/sound/5.wav",
                "stories/timmy_the_tiny_turtle/tr/sound/6.wav"
            )
        ),
        Story(
            id = 15,
            englishTitle = "Ziko the Tall Giraffe",
            arabicTitle = "زيكو الزرافة الطويلة",
            turkishTitle = "Uzun Zürafa Ziko",
            englishImagePaths = listOf(
                "stories/ziko_the_tall_iraffe/en/cover.png",
                "stories/ziko_the_tall_iraffe/en/1.png",
                "stories/ziko_the_tall_iraffe/en/2.png",
                "stories/ziko_the_tall_iraffe/en/3.png",
                "stories/ziko_the_tall_iraffe/en/4.png",
                "stories/ziko_the_tall_iraffe/en/5.png",
                "stories/ziko_the_tall_iraffe/en/6.png",
                "stories/ziko_the_tall_iraffe/en/7.png"
            ),
            arabicImagePaths = listOf(
                "stories/ziko_the_tall_iraffe/ar/cover.png",
                "stories/ziko_the_tall_iraffe/ar/1.png",
                "stories/ziko_the_tall_iraffe/ar/2.png",
                "stories/ziko_the_tall_iraffe/ar/3.png",
                "stories/ziko_the_tall_iraffe/ar/4.png",
                "stories/ziko_the_tall_iraffe/ar/5.png",
                "stories/ziko_the_tall_iraffe/ar/6.png",
                "stories/ziko_the_tall_iraffe/ar/7.png"
            ),
            turkishImagePaths = listOf(
                "stories/ziko_the_tall_iraffe/tr/cover.png",
                "stories/ziko_the_tall_iraffe/tr/1.png",
                "stories/ziko_the_tall_iraffe/tr/2.png",
                "stories/ziko_the_tall_iraffe/tr/3.png",
                "stories/ziko_the_tall_iraffe/tr/4.png",
                "stories/ziko_the_tall_iraffe/tr/5.png",
                "stories/ziko_the_tall_iraffe/tr/6.png",
                "stories/ziko_the_tall_iraffe/tr/7.png"
            ),
            englishAudioPaths = listOf(
                "stories/ziko_the_tall_iraffe/en/sound/cover.wav",
                "stories/ziko_the_tall_iraffe/en/sound/1.wav",
                "stories/ziko_the_tall_iraffe/en/sound/2.wav",
                "stories/ziko_the_tall_iraffe/en/sound/3.wav",
                "stories/ziko_the_tall_iraffe/en/sound/4.wav",
                "stories/ziko_the_tall_iraffe/en/sound/5.wav",
                "stories/ziko_the_tall_iraffe/en/sound/6.wav",
                "stories/ziko_the_tall_iraffe/en/sound/7.wav"
            ),
            arabicAudioPaths = listOf(
                "stories/ziko_the_tall_iraffe/ar/sound/cover.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/1.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/2.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/3.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/4.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/5.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/6.wav",
                "stories/ziko_the_tall_iraffe/ar/sound/7.wav"
            ),
            turkishAudioPaths = listOf(
                "stories/ziko_the_tall_iraffe/tr/sound/cover.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/1.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/2.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/3.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/4.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/5.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/6.wav",
                "stories/ziko_the_tall_iraffe/tr/sound/7.wav"
            )
        )
    )

    // Map levels to stories (one unique story per level)
    private val levelToStoryMap: Map<Int, Int> = buildMap {
        for (level in 1..15) {
            put(level, level) // Level 1 -> Story 1, Level 2 -> Story 2, etc.
        }
    }

    fun getAllStories(): List<Story> = stories

    fun getStoryById(id: Int): Story? = stories.find { it.id == id }

    fun getStoryForLevel(level: Int): Story? {
        val storyId = levelToStoryMap[level] ?: return null
        return getStoryById(storyId)
    }

    fun getTotalLevels(): Int = levelToStoryMap.size
}



