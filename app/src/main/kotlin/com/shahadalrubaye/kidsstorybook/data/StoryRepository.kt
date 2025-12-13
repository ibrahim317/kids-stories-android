package com.shahadalrubaye.kidsstorybook.data

import com.shahadalrubaye.kidsstorybook.models.Story

object StoryRepository {
    private val stories = listOf(

        Story(
            id = 1,
            englishTitle = "Barnaby Bear and the Big Red Ball",
            arabicTitle = "بارنابي الدب والكرة الحمراء الكبيرة",
            turkishTitle = "Barnaby Ayı ve Büyük Kırmızı Top",
            englishImagePaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/en/cover.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/1.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/2.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/3.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/4.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/5.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/6.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/7.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/8.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/9.webp",
                "stories/barnaby_bear_and_the_big_red_ball/en/10.webp"
            ),
            arabicImagePaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/ar/cover.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/1.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/2.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/3.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/4.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/5.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/6.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/7.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/8.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/9.webp",
                "stories/barnaby_bear_and_the_big_red_ball/ar/10.webp"
            ),
            turkishImagePaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/tr/cover.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/1.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/2.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/3.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/4.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/5.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/6.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/7.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/8.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/9.webp",
                "stories/barnaby_bear_and_the_big_red_ball/tr/10.webp"
            ),
            englishAudioPaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/cover.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/1.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/2.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/3.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/4.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/5.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/6.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/7.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/8.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/9.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/en/sound/10.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/cover.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/1.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/2.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/3.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/4.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/5.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/6.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/7.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/8.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/9.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/ar/sound/10.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/cover.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/1.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/2.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/3.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/4.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/5.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/6.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/7.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/8.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/9.mp3",
                "stories/barnaby_bear_and_the_big_red_ball/tr/sound/10.mp3"
            )
        ),
        Story(
            id = 2,
            englishTitle = "The Fox and the Crow",
            arabicTitle = "الثعلب والغراب",
            turkishTitle = "Tilki ve Karga",
            englishImagePaths = listOf(
                "stories/fox_crow/en/cover.webp",
                "stories/fox_crow/en/1.webp",
                "stories/fox_crow/en/2.webp",
                "stories/fox_crow/en/3.webp",
                "stories/fox_crow/en/4.webp",
                "stories/fox_crow/en/5.webp"
            ),
            arabicImagePaths = listOf(
                "stories/fox_crow/ar/cover.webp",
                "stories/fox_crow/ar/1.webp",
                "stories/fox_crow/ar/2.webp",
                "stories/fox_crow/ar/3.webp",
                "stories/fox_crow/ar/4.webp",
                "stories/fox_crow/ar/5.webp"
            ),
            turkishImagePaths = listOf(
                "stories/fox_crow/tr/cover.webp",
                "stories/fox_crow/tr/1.webp",
                "stories/fox_crow/tr/2.webp",
                "stories/fox_crow/tr/3.webp",
                "stories/fox_crow/tr/4.webp",
                "stories/fox_crow/tr/5.webp"
            ),
            englishAudioPaths = listOf(
                "stories/fox_crow/en/sound/cover.mp3",
                "stories/fox_crow/en/sound/1.mp3",
                "stories/fox_crow/en/sound/2.mp3",
                "stories/fox_crow/en/sound/3.mp3",
                "stories/fox_crow/en/sound/4.mp3",
                "stories/fox_crow/en/sound/5.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/fox_crow/ar/sound/cover.mp3",
                "stories/fox_crow/ar/sound/1.mp3",
                "stories/fox_crow/ar/sound/2.mp3",
                "stories/fox_crow/ar/sound/3.mp3",
                "stories/fox_crow/ar/sound/4.mp3",
                "stories/fox_crow/ar/sound/5.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/fox_crow/tr/sound/cover.mp3",
                "stories/fox_crow/tr/sound/1.mp3",
                "stories/fox_crow/tr/sound/2.mp3",
                "stories/fox_crow/tr/sound/3.mp3",
                "stories/fox_crow/tr/sound/4.mp3",
                "stories/fox_crow/tr/sound/5.mp3"
            )
        ),
        Story(
            id = 3,
            englishTitle = "The Lion and the Mouse",
            arabicTitle = "الأسد والفأر",
            turkishTitle = "Aslan ve Fare",
            englishImagePaths = listOf(
                "stories/lion_mouse/en/cover.webp",
                "stories/lion_mouse/en/1.webp",
                "stories/lion_mouse/en/2.webp",
                "stories/lion_mouse/en/3.webp",
                "stories/lion_mouse/en/4.webp",
                "stories/lion_mouse/en/5.webp",
                "stories/lion_mouse/en/6.webp",
            ),
            arabicImagePaths = listOf(
                "stories/lion_mouse/ar/cover.webp",
                "stories/lion_mouse/ar/1.webp",
                "stories/lion_mouse/ar/2.webp",
                "stories/lion_mouse/ar/3.webp",
                "stories/lion_mouse/ar/4.webp",
                "stories/lion_mouse/ar/5.webp",
                "stories/lion_mouse/ar/6.webp",
            ),
            turkishImagePaths = listOf(
                "stories/lion_mouse/tr/cover.webp",
                "stories/lion_mouse/tr/1.webp",
                "stories/lion_mouse/tr/2.webp",
                "stories/lion_mouse/tr/3.webp",
                "stories/lion_mouse/tr/4.webp",
                "stories/lion_mouse/tr/5.webp",
                "stories/lion_mouse/tr/6.webp",
            ),
            englishAudioPaths = listOf(
                "stories/lion_mouse/en/sound/cover.mp3",
                "stories/lion_mouse/en/sound/1.mp3",
                "stories/lion_mouse/en/sound/2.mp3",
                "stories/lion_mouse/en/sound/3.mp3",
                "stories/lion_mouse/en/sound/4.mp3",
                "stories/lion_mouse/en/sound/5.mp3",
                "stories/lion_mouse/en/sound/6.mp3",
            ),
            arabicAudioPaths = listOf(
                "stories/lion_mouse/ar/sound/cover.mp3",
                "stories/lion_mouse/ar/sound/1.mp3",
                "stories/lion_mouse/ar/sound/2.mp3",
                "stories/lion_mouse/ar/sound/3.mp3",
                "stories/lion_mouse/ar/sound/4.mp3",
                "stories/lion_mouse/ar/sound/5.mp3",
                "stories/lion_mouse/ar/sound/6.mp3",
            ),
            turkishAudioPaths = listOf(
                "stories/lion_mouse/tr/sound/cover.mp3",
                "stories/lion_mouse/tr/sound/1.mp3",
                "stories/lion_mouse/tr/sound/2.mp3",
                "stories/lion_mouse/tr/sound/3.mp3",
                "stories/lion_mouse/tr/sound/4.mp3",
                "stories/lion_mouse/tr/sound/5.mp3",
                "stories/lion_mouse/tr/sound/6.mp3",
            )
        ),
        Story(
            id = 4,
            englishTitle = "Big and Small Cat",
            arabicTitle = "القطة الكبيرة والصغيرة",
            turkishTitle = "Büyük ve Küçük Kedi",
            englishImagePaths = listOf(
                "stories/big_and_small_cat/en/cover.webp",
                "stories/big_and_small_cat/en/1.webp",
                "stories/big_and_small_cat/en/2.webp",
                "stories/big_and_small_cat/en/3.webp",
                "stories/big_and_small_cat/en/4.webp",
                "stories/big_and_small_cat/en/5.webp",
                "stories/big_and_small_cat/en/6.webp",
                "stories/big_and_small_cat/en/7.webp"
            ),
            arabicImagePaths = listOf(
                "stories/big_and_small_cat/ar/cover.webp",
                "stories/big_and_small_cat/ar/1.webp",
                "stories/big_and_small_cat/ar/2.webp",
                "stories/big_and_small_cat/ar/3.webp",
                "stories/big_and_small_cat/ar/4.webp",
                "stories/big_and_small_cat/ar/5.webp",
                "stories/big_and_small_cat/ar/6.webp",
                "stories/big_and_small_cat/ar/7.webp"
            ),
            turkishImagePaths = listOf(
                "stories/big_and_small_cat/tr/cover.webp",
                "stories/big_and_small_cat/tr/1.webp",
                "stories/big_and_small_cat/tr/2.webp",
                "stories/big_and_small_cat/tr/3.webp",
                "stories/big_and_small_cat/tr/4.webp",
                "stories/big_and_small_cat/tr/5.webp",
                "stories/big_and_small_cat/tr/6.webp",
                "stories/big_and_small_cat/tr/7.webp"
            ),
            englishAudioPaths = listOf(
                "stories/big_and_small_cat/en/sound/cover.mp3",
                "stories/big_and_small_cat/en/sound/1.mp3",
                "stories/big_and_small_cat/en/sound/2.mp3",
                "stories/big_and_small_cat/en/sound/3.mp3",
                "stories/big_and_small_cat/en/sound/4.mp3",
                "stories/big_and_small_cat/en/sound/5.mp3",
                "stories/big_and_small_cat/en/sound/6.mp3",
                "stories/big_and_small_cat/en/sound/7.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/big_and_small_cat/ar/sound/cover.mp3",
                "stories/big_and_small_cat/ar/sound/1.mp3",
                "stories/big_and_small_cat/ar/sound/2.mp3",
                "stories/big_and_small_cat/ar/sound/3.mp3",
                "stories/big_and_small_cat/ar/sound/4.mp3",
                "stories/big_and_small_cat/ar/sound/5.mp3",
                "stories/big_and_small_cat/ar/sound/6.mp3",
                "stories/big_and_small_cat/ar/sound/7.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/big_and_small_cat/tr/sound/cover.mp3",
                "stories/big_and_small_cat/tr/sound/1.mp3",
                "stories/big_and_small_cat/tr/sound/2.mp3",
                "stories/big_and_small_cat/tr/sound/3.mp3",
                "stories/big_and_small_cat/tr/sound/4.mp3",
                "stories/big_and_small_cat/tr/sound/5.mp3",
                "stories/big_and_small_cat/tr/sound/6.mp3",
                "stories/big_and_small_cat/tr/sound/7.mp3"
            )
        ),
        Story(
            id = 5,
            englishTitle = "Choo-Choo to Bedtime",
            arabicTitle = "تشو-تشو إلى وقت النوم",
            turkishTitle = "Choo-Choo Uyku Zamanı",
            englishImagePaths = listOf(
                "stories/choo-choo_to_bedtime/en/cover.webp",
                "stories/choo-choo_to_bedtime/en/1.webp",
                "stories/choo-choo_to_bedtime/en/2.webp",
                "stories/choo-choo_to_bedtime/en/3.webp",
                "stories/choo-choo_to_bedtime/en/4.webp",
                "stories/choo-choo_to_bedtime/en/5.webp",
                "stories/choo-choo_to_bedtime/en/6.webp",
                "stories/choo-choo_to_bedtime/en/7.webp",
                "stories/choo-choo_to_bedtime/en/8.webp"
            ),
            arabicImagePaths = listOf(
                "stories/choo-choo_to_bedtime/ar/cover.webp",
                "stories/choo-choo_to_bedtime/ar/1.webp",
                "stories/choo-choo_to_bedtime/ar/2.webp",
                "stories/choo-choo_to_bedtime/ar/3.webp",
                "stories/choo-choo_to_bedtime/ar/4.webp",
                "stories/choo-choo_to_bedtime/ar/5.webp",
                "stories/choo-choo_to_bedtime/ar/6.webp",
                "stories/choo-choo_to_bedtime/ar/7.webp",
                "stories/choo-choo_to_bedtime/ar/8.webp"
            ),
            turkishImagePaths = listOf(
                "stories/choo-choo_to_bedtime/tr/cover.webp",
                "stories/choo-choo_to_bedtime/tr/1.webp",
                "stories/choo-choo_to_bedtime/tr/2.webp",
                "stories/choo-choo_to_bedtime/tr/3.webp",
                "stories/choo-choo_to_bedtime/tr/4.webp",
                "stories/choo-choo_to_bedtime/tr/5.webp",
                "stories/choo-choo_to_bedtime/tr/6.webp",
                "stories/choo-choo_to_bedtime/tr/7.webp",
                "stories/choo-choo_to_bedtime/tr/8.webp"
            ),
            englishAudioPaths = listOf(
                "stories/choo-choo_to_bedtime/en/sound/cover.mp3",
                "stories/choo-choo_to_bedtime/en/sound/1.mp3",
                "stories/choo-choo_to_bedtime/en/sound/2.mp3",
                "stories/choo-choo_to_bedtime/en/sound/3.mp3",
                "stories/choo-choo_to_bedtime/en/sound/4.mp3",
                "stories/choo-choo_to_bedtime/en/sound/5.mp3",
                "stories/choo-choo_to_bedtime/en/sound/6.mp3",
                "stories/choo-choo_to_bedtime/en/sound/7.mp3",
                "stories/choo-choo_to_bedtime/en/sound/8.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/choo-choo_to_bedtime/ar/sound/cover.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/1.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/2.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/3.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/4.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/5.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/6.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/7.mp3",
                "stories/choo-choo_to_bedtime/ar/sound/8.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/choo-choo_to_bedtime/tr/sound/cover.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/1.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/2.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/3.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/4.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/5.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/6.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/7.mp3",
                "stories/choo-choo_to_bedtime/tr/sound/8.mp3"
            )
        ),
        Story(
            id = 6,
            englishTitle = "Leo the Little Astronaut",
            arabicTitle = "ليو رائد الفضاء الصغير",
            turkishTitle = "Küçük Astronot Leo",
            englishImagePaths = listOf(
                "stories/leo_the_little_astronaut/en/cover.webp",
                "stories/leo_the_little_astronaut/en/1.webp",
                "stories/leo_the_little_astronaut/en/2.webp",
                "stories/leo_the_little_astronaut/en/3.webp",
                "stories/leo_the_little_astronaut/en/4.webp",
                "stories/leo_the_little_astronaut/en/5.webp",
                "stories/leo_the_little_astronaut/en/6.webp"
            ),
            arabicImagePaths = listOf(
                "stories/leo_the_little_astronaut/ar/cover.webp",
                "stories/leo_the_little_astronaut/ar/1.webp",
                "stories/leo_the_little_astronaut/ar/2.webp",
                "stories/leo_the_little_astronaut/ar/3.webp",
                "stories/leo_the_little_astronaut/ar/4.webp",
                "stories/leo_the_little_astronaut/ar/5.webp",
                "stories/leo_the_little_astronaut/ar/6.webp"
            ),
            turkishImagePaths = listOf(
                "stories/leo_the_little_astronaut/tr/cover.webp",
                "stories/leo_the_little_astronaut/tr/1.webp",
                "stories/leo_the_little_astronaut/tr/2.webp",
                "stories/leo_the_little_astronaut/tr/3.webp",
                "stories/leo_the_little_astronaut/tr/4.webp",
                "stories/leo_the_little_astronaut/tr/5.webp",
                "stories/leo_the_little_astronaut/tr/6.webp"
            ),
            englishAudioPaths = listOf(
                "stories/leo_the_little_astronaut/en/sound/cover.mp3",
                "stories/leo_the_little_astronaut/en/sound/1.mp3",
                "stories/leo_the_little_astronaut/en/sound/2.mp3",
                "stories/leo_the_little_astronaut/en/sound/3.mp3",
                "stories/leo_the_little_astronaut/en/sound/4.mp3",
                "stories/leo_the_little_astronaut/en/sound/5.mp3",
                "stories/leo_the_little_astronaut/en/sound/6.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/leo_the_little_astronaut/ar/sound/cover.mp3",
                "stories/leo_the_little_astronaut/ar/sound/1.mp3",
                "stories/leo_the_little_astronaut/ar/sound/2.mp3",
                "stories/leo_the_little_astronaut/ar/sound/3.mp3",
                "stories/leo_the_little_astronaut/ar/sound/4.mp3",
                "stories/leo_the_little_astronaut/ar/sound/5.mp3",
                "stories/leo_the_little_astronaut/ar/sound/6.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/leo_the_little_astronaut/tr/sound/cover.mp3",
                "stories/leo_the_little_astronaut/tr/sound/1.mp3",
                "stories/leo_the_little_astronaut/tr/sound/2.mp3",
                "stories/leo_the_little_astronaut/tr/sound/3.mp3",
                "stories/leo_the_little_astronaut/tr/sound/4.mp3",
                "stories/leo_the_little_astronaut/tr/sound/5.mp3",
                "stories/leo_the_little_astronaut/tr/sound/6.mp3"
            )
        ),
        Story(
            id = 7,
            englishTitle = "Lila the Flying Butterfly",
            arabicTitle = "ليلى الفراشة الطائرة",
            turkishTitle = "Uçan Kelebek Lila",
            englishImagePaths = listOf(
                "stories/lila_the_flying_butterfly/en/cover.webp",
                "stories/lila_the_flying_butterfly/en/1.webp",
                "stories/lila_the_flying_butterfly/en/2.webp",
                "stories/lila_the_flying_butterfly/en/3.webp",
                "stories/lila_the_flying_butterfly/en/4.webp",
                "stories/lila_the_flying_butterfly/en/5.webp",
                "stories/lila_the_flying_butterfly/en/6.webp",
                "stories/lila_the_flying_butterfly/en/7.webp",
                "stories/lila_the_flying_butterfly/en/8.webp"
            ),
            arabicImagePaths = listOf(
                "stories/lila_the_flying_butterfly/ar/cover.webp",
                "stories/lila_the_flying_butterfly/ar/1.webp",
                "stories/lila_the_flying_butterfly/ar/2.webp",
                "stories/lila_the_flying_butterfly/ar/3.webp",
                "stories/lila_the_flying_butterfly/ar/4.webp",
                "stories/lila_the_flying_butterfly/ar/5.webp",
                "stories/lila_the_flying_butterfly/ar/6.webp",
                "stories/lila_the_flying_butterfly/ar/7.webp",
                "stories/lila_the_flying_butterfly/ar/8.webp"
            ),
            turkishImagePaths = listOf(
                "stories/lila_the_flying_butterfly/tr/cover.webp",
                "stories/lila_the_flying_butterfly/tr/1.webp",
                "stories/lila_the_flying_butterfly/tr/2.webp",
                "stories/lila_the_flying_butterfly/tr/3.webp",
                "stories/lila_the_flying_butterfly/tr/4.webp",
                "stories/lila_the_flying_butterfly/tr/5.webp",
                "stories/lila_the_flying_butterfly/tr/6.webp",
                "stories/lila_the_flying_butterfly/tr/7.webp",
                "stories/lila_the_flying_butterfly/tr/8.webp"
            ),
            englishAudioPaths = listOf(
                "stories/lila_the_flying_butterfly/en/sound/cover.mp3",
                "stories/lila_the_flying_butterfly/en/sound/1.mp3",
                "stories/lila_the_flying_butterfly/en/sound/2.mp3",
                "stories/lila_the_flying_butterfly/en/sound/3.mp3",
                "stories/lila_the_flying_butterfly/en/sound/4.mp3",
                "stories/lila_the_flying_butterfly/en/sound/5.mp3",
                "stories/lila_the_flying_butterfly/en/sound/6.mp3",
                "stories/lila_the_flying_butterfly/en/sound/7.mp3",
                "stories/lila_the_flying_butterfly/en/sound/8.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/lila_the_flying_butterfly/ar/sound/cover.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/1.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/2.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/3.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/4.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/5.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/6.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/7.mp3",
                "stories/lila_the_flying_butterfly/ar/sound/8.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/lila_the_flying_butterfly/tr/sound/cover.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/1.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/2.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/3.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/4.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/5.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/6.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/7.mp3",
                "stories/lila_the_flying_butterfly/tr/sound/8.mp3"
            )
        ),
        Story(
            id = 8,
            englishTitle = "Lily the Ladybug's Colors",
            arabicTitle = "ألوان الدعسوقة ليلي",
            turkishTitle = "Uğurböceği Lily'nin Renkleri",
            englishImagePaths = listOf(
                "stories/lily_the_ladybugs_colors/en/cover.webp",
                "stories/lily_the_ladybugs_colors/en/1.webp",
                "stories/lily_the_ladybugs_colors/en/2.webp",
                "stories/lily_the_ladybugs_colors/en/3.webp",
                "stories/lily_the_ladybugs_colors/en/4.webp"
            ),
            arabicImagePaths = listOf(
                "stories/lily_the_ladybugs_colors/ar/cover.webp",
                "stories/lily_the_ladybugs_colors/ar/1.webp",
                "stories/lily_the_ladybugs_colors/ar/2.webp",
                "stories/lily_the_ladybugs_colors/ar/3.webp",
                "stories/lily_the_ladybugs_colors/ar/4.webp"
            ),
            turkishImagePaths = listOf(
                "stories/lily_the_ladybugs_colors/tr/cover.webp",
                "stories/lily_the_ladybugs_colors/tr/1.webp",
                "stories/lily_the_ladybugs_colors/tr/2.webp",
                "stories/lily_the_ladybugs_colors/tr/3.webp",
                "stories/lily_the_ladybugs_colors/tr/4.webp"
            ),
            englishAudioPaths = listOf(
                "stories/lily_the_ladybugs_colors/en/sound/cover.mp3",
                "stories/lily_the_ladybugs_colors/en/sound/1.mp3",
                "stories/lily_the_ladybugs_colors/en/sound/2.mp3",
                "stories/lily_the_ladybugs_colors/en/sound/3.mp3",
                "stories/lily_the_ladybugs_colors/en/sound/4.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/lily_the_ladybugs_colors/ar/sound/cover.mp3",
                "stories/lily_the_ladybugs_colors/ar/sound/1.mp3",
                "stories/lily_the_ladybugs_colors/ar/sound/2.mp3",
                "stories/lily_the_ladybugs_colors/ar/sound/3.mp3",
                "stories/lily_the_ladybugs_colors/ar/sound/4.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/lily_the_ladybugs_colors/tr/sound/cover.mp3",
                "stories/lily_the_ladybugs_colors/tr/sound/1.mp3",
                "stories/lily_the_ladybugs_colors/tr/sound/2.mp3",
                "stories/lily_the_ladybugs_colors/tr/sound/3.mp3",
                "stories/lily_the_ladybugs_colors/tr/sound/4.mp3"
            )
        ),
        Story(
            id = 9,
            englishTitle = "Little Bear Honey's Picnic",
            arabicTitle = "نزهة الدب الصغير هوني",
            turkishTitle = "Küçük Ayı Honey'nin Pikniği",
            englishImagePaths = listOf(
                "stories/little_bear_honeys_picnic/en/cover.webp",
                "stories/little_bear_honeys_picnic/en/1.webp",
                "stories/little_bear_honeys_picnic/en/2.webp",
                "stories/little_bear_honeys_picnic/en/3.webp",
                "stories/little_bear_honeys_picnic/en/4.webp",
                "stories/little_bear_honeys_picnic/en/5.webp",
                "stories/little_bear_honeys_picnic/en/6.webp",
                "stories/little_bear_honeys_picnic/en/7.webp"
            ),
            arabicImagePaths = listOf(
                "stories/little_bear_honeys_picnic/ar/cover.webp",
                "stories/little_bear_honeys_picnic/ar/1.webp",
                "stories/little_bear_honeys_picnic/ar/2.webp",
                "stories/little_bear_honeys_picnic/ar/3.webp",
                "stories/little_bear_honeys_picnic/ar/4.webp",
                "stories/little_bear_honeys_picnic/ar/5.webp",
                "stories/little_bear_honeys_picnic/ar/6.webp",
                "stories/little_bear_honeys_picnic/ar/7.webp"
            ),
            turkishImagePaths = listOf(
                "stories/little_bear_honeys_picnic/tr/cover.webp",
                "stories/little_bear_honeys_picnic/tr/1.webp",
                "stories/little_bear_honeys_picnic/tr/2.webp",
                "stories/little_bear_honeys_picnic/tr/3.webp",
                "stories/little_bear_honeys_picnic/tr/4.webp",
                "stories/little_bear_honeys_picnic/tr/5.webp",
                "stories/little_bear_honeys_picnic/tr/6.webp",
                "stories/little_bear_honeys_picnic/tr/7.webp"
            ),
            englishAudioPaths = listOf(
                "stories/little_bear_honeys_picnic/en/sound/cover.mp3",
                "stories/little_bear_honeys_picnic/en/sound/1.mp3",
                "stories/little_bear_honeys_picnic/en/sound/2.mp3",
                "stories/little_bear_honeys_picnic/en/sound/3.mp3",
                "stories/little_bear_honeys_picnic/en/sound/4.mp3",
                "stories/little_bear_honeys_picnic/en/sound/5.mp3",
                "stories/little_bear_honeys_picnic/en/sound/6.mp3",
                "stories/little_bear_honeys_picnic/en/sound/7.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/little_bear_honeys_picnic/ar/sound/cover.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/1.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/2.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/3.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/4.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/5.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/6.mp3",
                "stories/little_bear_honeys_picnic/ar/sound/7.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/little_bear_honeys_picnic/tr/sound/cover.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/1.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/2.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/3.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/4.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/5.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/6.mp3",
                "stories/little_bear_honeys_picnic/tr/sound/7.mp3"
            )
        ),
        Story(
            id = 10,
            englishTitle = "Red, Yellow, Green - Traffic Light",
            arabicTitle = "أحمر، أصفر، أخضر - إشارة المرور",
            turkishTitle = "Kırmızı, Sarı, Yeşil - Trafik Işığı",
            englishImagePaths = listOf(
                "stories/red_yellow_reen_traffic_light/en/cover.webp",
                "stories/red_yellow_reen_traffic_light/en/1.webp",
                "stories/red_yellow_reen_traffic_light/en/2.webp",
                "stories/red_yellow_reen_traffic_light/en/3.webp",
                "stories/red_yellow_reen_traffic_light/en/4.webp",
                "stories/red_yellow_reen_traffic_light/en/5.webp",
                "stories/red_yellow_reen_traffic_light/en/6.webp",
                "stories/red_yellow_reen_traffic_light/en/7.webp"
            ),
            arabicImagePaths = listOf(
                "stories/red_yellow_reen_traffic_light/ar/cover.webp",
                "stories/red_yellow_reen_traffic_light/ar/1.webp",
                "stories/red_yellow_reen_traffic_light/ar/2.webp",
                "stories/red_yellow_reen_traffic_light/ar/3.webp",
                "stories/red_yellow_reen_traffic_light/ar/4.webp",
                "stories/red_yellow_reen_traffic_light/ar/5.webp",
                "stories/red_yellow_reen_traffic_light/ar/6.webp",
                "stories/red_yellow_reen_traffic_light/ar/7.webp"
            ),
            turkishImagePaths = listOf(
                "stories/red_yellow_reen_traffic_light/tr/cover.webp",
                "stories/red_yellow_reen_traffic_light/tr/1.webp",
                "stories/red_yellow_reen_traffic_light/tr/2.webp",
                "stories/red_yellow_reen_traffic_light/tr/3.webp",
                "stories/red_yellow_reen_traffic_light/tr/4.webp",
                "stories/red_yellow_reen_traffic_light/tr/5.webp",
                "stories/red_yellow_reen_traffic_light/tr/6.webp",
                "stories/red_yellow_reen_traffic_light/tr/7.webp"
            ),
            englishAudioPaths = listOf(
                "stories/red_yellow_reen_traffic_light/en/sound/cover.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/1.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/2.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/3.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/4.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/5.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/6.mp3",
                "stories/red_yellow_reen_traffic_light/en/sound/7.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/red_yellow_reen_traffic_light/ar/sound/cover.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/1.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/2.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/3.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/4.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/5.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/6.mp3",
                "stories/red_yellow_reen_traffic_light/ar/sound/7.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/red_yellow_reen_traffic_light/tr/sound/cover.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/1.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/2.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/3.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/4.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/5.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/6.mp3",
                "stories/red_yellow_reen_traffic_light/tr/sound/7.mp3"
            )
        ),
        Story(
            id = 11,
            englishTitle = "The Fingers Five",
            arabicTitle = "الأصابع الخمسة",
            turkishTitle = "Beş Parmak",
            englishImagePaths = listOf(
                "stories/the_finggers_five/en/1.webp",
                "stories/the_finggers_five/en/2.webp",
                "stories/the_finggers_five/en/3.webp",
                "stories/the_finggers_five/en/4.webp",
                "stories/the_finggers_five/en/5.webp",
                "stories/the_finggers_five/en/6.webp"
            ),
            arabicImagePaths = listOf(
                "stories/the_finggers_five/ar/1.webp",
                "stories/the_finggers_five/ar/2.webp",
                "stories/the_finggers_five/ar/3.webp",
                "stories/the_finggers_five/ar/4.webp",
                "stories/the_finggers_five/ar/5.webp",
                "stories/the_finggers_five/ar/6.webp"
            ),
            turkishImagePaths = listOf(
                "stories/the_finggers_five/tr/1.webp",
                "stories/the_finggers_five/tr/2.webp",
                "stories/the_finggers_five/tr/3.webp",
                "stories/the_finggers_five/tr/4.webp",
                "stories/the_finggers_five/tr/5.webp",
                "stories/the_finggers_five/tr/6.webp"
            ),
            englishAudioPaths = listOf(
                "stories/the_finggers_five/en/sound/1.mp3",
                "stories/the_finggers_five/en/sound/2.mp3",
                "stories/the_finggers_five/en/sound/3.mp3",
                "stories/the_finggers_five/en/sound/4.mp3",
                "stories/the_finggers_five/en/sound/5.mp3",
                "stories/the_finggers_five/en/sound/6.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/the_finggers_five/ar/sound/1.mp3",
                "stories/the_finggers_five/ar/sound/2.mp3",
                "stories/the_finggers_five/ar/sound/3.mp3",
                "stories/the_finggers_five/ar/sound/4.mp3",
                "stories/the_finggers_five/ar/sound/5.mp3",
                "stories/the_finggers_five/ar/sound/6.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/the_finggers_five/tr/sound/1.mp3",
                "stories/the_finggers_five/tr/sound/2.mp3",
                "stories/the_finggers_five/tr/sound/3.mp3",
                "stories/the_finggers_five/tr/sound/4.mp3",
                "stories/the_finggers_five/tr/sound/5.mp3",
                "stories/the_finggers_five/tr/sound/6.mp3"
            )
        ),
        Story(
            id = 12,
            englishTitle = "The Little Blue Train",
            arabicTitle = "القطار الأزرق الصغير",
            turkishTitle = "Küçük Mavi Tren",
            englishImagePaths = listOf(
                "stories/the_little_blue_train/en/cover.webp",
                "stories/the_little_blue_train/en/1.webp",
                "stories/the_little_blue_train/en/2.webp",
                "stories/the_little_blue_train/en/3.webp",
                "stories/the_little_blue_train/en/4.webp"
            ),
            arabicImagePaths = listOf(
                "stories/the_little_blue_train/ar/cover.webp",
                "stories/the_little_blue_train/ar/1.webp",
                "stories/the_little_blue_train/ar/2.webp",
                "stories/the_little_blue_train/ar/3.webp",
                "stories/the_little_blue_train/ar/4.webp"
            ),
            turkishImagePaths = listOf(
                "stories/the_little_blue_train/tr/cover.webp",
                "stories/the_little_blue_train/tr/1.webp",
                "stories/the_little_blue_train/tr/2.webp",
                "stories/the_little_blue_train/tr/3.webp",
                "stories/the_little_blue_train/tr/4.webp"
            ),
            englishAudioPaths = listOf(
                "stories/the_little_blue_train/en/sound/cover.mp3",
                "stories/the_little_blue_train/en/sound/1.mp3",
                "stories/the_little_blue_train/en/sound/2.mp3",
                "stories/the_little_blue_train/en/sound/3.mp3",
                "stories/the_little_blue_train/en/sound/4.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/the_little_blue_train/ar/sound/cover.mp3",
                "stories/the_little_blue_train/ar/sound/1.mp3",
                "stories/the_little_blue_train/ar/sound/2.mp3",
                "stories/the_little_blue_train/ar/sound/3.mp3",
                "stories/the_little_blue_train/ar/sound/4.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/the_little_blue_train/tr/sound/cover.mp3",
                "stories/the_little_blue_train/tr/sound/1.mp3",
                "stories/the_little_blue_train/tr/sound/2.mp3",
                "stories/the_little_blue_train/tr/sound/3.mp3",
                "stories/the_little_blue_train/tr/sound/4.mp3"
            )
        ),
        Story(
            id = 13,
            englishTitle = "The Lost Blue Sock",
            arabicTitle = "الجورب الأزرق المفقود",
            turkishTitle = "Kayıp Mavi Çorap",
            englishImagePaths = listOf(
                "stories/the_lost_blue_sock/en/cover.webp",
                "stories/the_lost_blue_sock/en/1.webp",
                "stories/the_lost_blue_sock/en/2.webp",
                "stories/the_lost_blue_sock/en/3.webp",
                "stories/the_lost_blue_sock/en/4.webp",
                "stories/the_lost_blue_sock/en/5.webp",
                "stories/the_lost_blue_sock/en/6.webp",
                "stories/the_lost_blue_sock/en/7.webp"
            ),
            arabicImagePaths = listOf(
                "stories/the_lost_blue_sock/ar/cover.webp",
                "stories/the_lost_blue_sock/ar/1.webp",
                "stories/the_lost_blue_sock/ar/2.webp",
                "stories/the_lost_blue_sock/ar/3.webp",
                "stories/the_lost_blue_sock/ar/4.webp",
                "stories/the_lost_blue_sock/ar/5.webp",
                "stories/the_lost_blue_sock/ar/6.webp",
                "stories/the_lost_blue_sock/ar/7.webp"
            ),
            turkishImagePaths = listOf(
                "stories/the_lost_blue_sock/tr/cover.webp",
                "stories/the_lost_blue_sock/tr/1.webp",
                "stories/the_lost_blue_sock/tr/2.webp",
                "stories/the_lost_blue_sock/tr/3.webp",
                "stories/the_lost_blue_sock/tr/4.webp",
                "stories/the_lost_blue_sock/tr/5.webp",
                "stories/the_lost_blue_sock/tr/6.webp",
                "stories/the_lost_blue_sock/tr/7.webp"
            ),
            englishAudioPaths = listOf(
                "stories/the_lost_blue_sock/en/sound/cover.mp3",
                "stories/the_lost_blue_sock/en/sound/1.mp3",
                "stories/the_lost_blue_sock/en/sound/2.mp3",
                "stories/the_lost_blue_sock/en/sound/3.mp3",
                "stories/the_lost_blue_sock/en/sound/4.mp3",
                "stories/the_lost_blue_sock/en/sound/5.mp3",
                "stories/the_lost_blue_sock/en/sound/6.mp3",
                "stories/the_lost_blue_sock/en/sound/7.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/the_lost_blue_sock/ar/sound/cover.mp3",
                "stories/the_lost_blue_sock/ar/sound/1.mp3",
                "stories/the_lost_blue_sock/ar/sound/2.mp3",
                "stories/the_lost_blue_sock/ar/sound/3.mp3",
                "stories/the_lost_blue_sock/ar/sound/4.mp3",
                "stories/the_lost_blue_sock/ar/sound/5.mp3",
                "stories/the_lost_blue_sock/ar/sound/6.mp3",
                "stories/the_lost_blue_sock/ar/sound/7.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/the_lost_blue_sock/tr/sound/cover.mp3",
                "stories/the_lost_blue_sock/tr/sound/1.mp3",
                "stories/the_lost_blue_sock/tr/sound/2.mp3",
                "stories/the_lost_blue_sock/tr/sound/3.mp3",
                "stories/the_lost_blue_sock/tr/sound/4.mp3",
                "stories/the_lost_blue_sock/tr/sound/5.mp3",
                "stories/the_lost_blue_sock/tr/sound/6.mp3",
                "stories/the_lost_blue_sock/tr/sound/7.mp3"
            )
        ),
        Story(
            id = 14,
            englishTitle = "Timmy the Tiny Turtle",
            arabicTitle = "تيمي السلحفاة الصغيرة",
            turkishTitle = "Minik Kaplumbağa Timmy",
            englishImagePaths = listOf(
                "stories/timmy_the_tiny_turtle/en/cover.webp",
                "stories/timmy_the_tiny_turtle/en/1.webp",
                "stories/timmy_the_tiny_turtle/en/2.webp",
                "stories/timmy_the_tiny_turtle/en/3.webp",
                "stories/timmy_the_tiny_turtle/en/4.webp",
                "stories/timmy_the_tiny_turtle/en/5.webp",
                "stories/timmy_the_tiny_turtle/en/6.webp"
            ),
            arabicImagePaths = listOf(
                "stories/timmy_the_tiny_turtle/ar/cover.webp",
                "stories/timmy_the_tiny_turtle/ar/1.webp",
                "stories/timmy_the_tiny_turtle/ar/2.webp",
                "stories/timmy_the_tiny_turtle/ar/3.webp",
                "stories/timmy_the_tiny_turtle/ar/4.webp",
                "stories/timmy_the_tiny_turtle/ar/5.webp",
                "stories/timmy_the_tiny_turtle/ar/6.webp"
            ),
            turkishImagePaths = listOf(
                "stories/timmy_the_tiny_turtle/tr/cover.webp",
                "stories/timmy_the_tiny_turtle/tr/1.webp",
                "stories/timmy_the_tiny_turtle/tr/2.webp",
                "stories/timmy_the_tiny_turtle/tr/3.webp",
                "stories/timmy_the_tiny_turtle/tr/4.webp",
                "stories/timmy_the_tiny_turtle/tr/5.webp",
                "stories/timmy_the_tiny_turtle/tr/6.webp"
            ),
            englishAudioPaths = listOf(
                "stories/timmy_the_tiny_turtle/en/sound/cover.mp3",
                "stories/timmy_the_tiny_turtle/en/sound/1.mp3",
                "stories/timmy_the_tiny_turtle/en/sound/2.mp3",
                "stories/timmy_the_tiny_turtle/en/sound/3.mp3",
                "stories/timmy_the_tiny_turtle/en/sound/4.mp3",
                "stories/timmy_the_tiny_turtle/en/sound/5.mp3",
                "stories/timmy_the_tiny_turtle/en/sound/6.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/timmy_the_tiny_turtle/ar/sound/cover.mp3",
                "stories/timmy_the_tiny_turtle/ar/sound/1.mp3",
                "stories/timmy_the_tiny_turtle/ar/sound/2.mp3",
                "stories/timmy_the_tiny_turtle/ar/sound/3.mp3",
                "stories/timmy_the_tiny_turtle/ar/sound/4.mp3",
                "stories/timmy_the_tiny_turtle/ar/sound/5.mp3",
                "stories/timmy_the_tiny_turtle/ar/sound/6.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/timmy_the_tiny_turtle/tr/sound/cover.mp3",
                "stories/timmy_the_tiny_turtle/tr/sound/1.mp3",
                "stories/timmy_the_tiny_turtle/tr/sound/2.mp3",
                "stories/timmy_the_tiny_turtle/tr/sound/3.mp3",
                "stories/timmy_the_tiny_turtle/tr/sound/4.mp3",
                "stories/timmy_the_tiny_turtle/tr/sound/5.mp3",
                "stories/timmy_the_tiny_turtle/tr/sound/6.mp3"
            )
        ),
        Story(
            id = 15,
            englishTitle = "Ziko the Tall Giraffe",
            arabicTitle = "زيكو الزرافة الطويلة",
            turkishTitle = "Uzun Zürafa Ziko",
            englishImagePaths = listOf(
                "stories/ziko_the_tall_iraffe/en/cover.webp",
                "stories/ziko_the_tall_iraffe/en/1.webp",
                "stories/ziko_the_tall_iraffe/en/2.webp",
                "stories/ziko_the_tall_iraffe/en/3.webp",
                "stories/ziko_the_tall_iraffe/en/4.webp",
                "stories/ziko_the_tall_iraffe/en/5.webp",
                "stories/ziko_the_tall_iraffe/en/6.webp",
                "stories/ziko_the_tall_iraffe/en/7.webp"
            ),
            arabicImagePaths = listOf(
                "stories/ziko_the_tall_iraffe/ar/cover.webp",
                "stories/ziko_the_tall_iraffe/ar/1.webp",
                "stories/ziko_the_tall_iraffe/ar/2.webp",
                "stories/ziko_the_tall_iraffe/ar/3.webp",
                "stories/ziko_the_tall_iraffe/ar/4.webp",
                "stories/ziko_the_tall_iraffe/ar/5.webp",
                "stories/ziko_the_tall_iraffe/ar/6.webp",
                "stories/ziko_the_tall_iraffe/ar/7.webp"
            ),
            turkishImagePaths = listOf(
                "stories/ziko_the_tall_iraffe/tr/cover.webp",
                "stories/ziko_the_tall_iraffe/tr/1.webp",
                "stories/ziko_the_tall_iraffe/tr/2.webp",
                "stories/ziko_the_tall_iraffe/tr/3.webp",
                "stories/ziko_the_tall_iraffe/tr/4.webp",
                "stories/ziko_the_tall_iraffe/tr/5.webp",
                "stories/ziko_the_tall_iraffe/tr/6.webp",
                "stories/ziko_the_tall_iraffe/tr/7.webp"
            ),
            englishAudioPaths = listOf(
                "stories/ziko_the_tall_iraffe/en/sound/cover.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/1.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/2.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/3.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/4.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/5.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/6.mp3",
                "stories/ziko_the_tall_iraffe/en/sound/7.mp3"
            ),
            arabicAudioPaths = listOf(
                "stories/ziko_the_tall_iraffe/ar/sound/cover.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/1.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/2.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/3.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/4.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/5.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/6.mp3",
                "stories/ziko_the_tall_iraffe/ar/sound/7.mp3"
            ),
            turkishAudioPaths = listOf(
                "stories/ziko_the_tall_iraffe/tr/sound/cover.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/1.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/2.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/3.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/4.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/5.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/6.mp3",
                "stories/ziko_the_tall_iraffe/tr/sound/7.mp3"
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



