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
            "stories/barnaby_bear_and_the_big_red_ball/en/cover/cover.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/1/1.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/2/2.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/3/3.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/4/4.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/5/5.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/6/6.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/7/7.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/8/8.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/9/9.webp",
            "stories/barnaby_bear_and_the_big_red_ball/en/10/10.webp"
        ),
        arabicImagePaths = listOf(
            "stories/barnaby_bear_and_the_big_red_ball/ar/cover/cover.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/1/1.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/2/2.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/3/3.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/4/4.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/5/5.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/6/6.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/7/7.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/8/8.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/9/9.webp",
            "stories/barnaby_bear_and_the_big_red_ball/ar/10/10.webp"
        ),
        turkishImagePaths = listOf(
            "stories/barnaby_bear_and_the_big_red_ball/tr/cover/cover.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/1/1.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/2/2.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/3/3.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/4/4.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/5/5.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/6/6.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/7/7.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/8/8.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/9/9.webp",
            "stories/barnaby_bear_and_the_big_red_ball/tr/10/10.webp"
        ),
        englishAudioPaths = listOf(
            "stories/barnaby_bear_and_the_big_red_ball/en/cover/cover.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/1/1.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/2/2.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/3/3.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/4/4.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/5/5.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/6/6.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/7/7.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/8/8.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/9/9.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/en/10/10.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/barnaby_bear_and_the_big_red_ball/ar/cover/cover.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/1/1.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/2/2.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/3/3.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/4/4.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/5/5.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/6/6.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/7/7.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/8/8.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/9/9.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/ar/10/10.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/barnaby_bear_and_the_big_red_ball/tr/cover/cover.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/1/1.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/2/2.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/3/3.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/4/4.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/5/5.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/6/6.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/7/7.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/8/8.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/9/9.mp3",
            "stories/barnaby_bear_and_the_big_red_ball/tr/10/10.mp3"
        )
    ),
    Story(
        id = 2,
        englishTitle = "The Fox and the Crow",
        arabicTitle = "الثعلب والغراب",
        turkishTitle = "Tilki ve Karga",
        englishImagePaths = listOf(
            "stories/fox_and_crow/en/cover/cover.webp",
            "stories/fox_and_crow/en/1/1.webp",
            "stories/fox_and_crow/en/2/2.webp",
            "stories/fox_and_crow/en/3/3.webp",
            "stories/fox_and_crow/en/4/4.webp",
            "stories/fox_and_crow/en/5/5.webp"
        ),
        arabicImagePaths = listOf(
            "stories/fox_and_crow/ar/cover/cover.webp",
            "stories/fox_and_crow/ar/1/1.webp",
            "stories/fox_and_crow/ar/2/2.webp",
            "stories/fox_and_crow/ar/3/3.webp",
            "stories/fox_and_crow/ar/4/4.webp",
            "stories/fox_and_crow/ar/5/5.webp"
        ),
        turkishImagePaths = listOf(
            "stories/fox_and_crow/tr/cover/cover.webp",
            "stories/fox_and_crow/tr/1/1.webp",
            "stories/fox_and_crow/tr/2/2.webp",
            "stories/fox_and_crow/tr/3/3.webp",
            "stories/fox_and_crow/tr/4/4.webp",
            "stories/fox_and_crow/tr/5/5.webp"
        ),
        englishAudioPaths = listOf(
            "stories/fox_and_crow/en/cover/cover.mp3",
            "stories/fox_and_crow/en/1/1.mp3",
            "stories/fox_and_crow/en/2/2.mp3",
            "stories/fox_and_crow/en/3/3.mp3",
            "stories/fox_and_crow/en/4/4.mp3",
            "stories/fox_and_crow/en/5/5.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/fox_and_crow/ar/cover/cover.mp3",
            "stories/fox_and_crow/ar/1/1.mp3",
            "stories/fox_and_crow/ar/2/2.mp3",
            "stories/fox_and_crow/ar/3/3.mp3",
            "stories/fox_and_crow/ar/4/4.mp3",
            "stories/fox_and_crow/ar/5/5.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/fox_and_crow/tr/cover/cover.mp3",
            "stories/fox_and_crow/tr/1/1.mp3",
            "stories/fox_and_crow/tr/2/2.mp3",
            "stories/fox_and_crow/tr/3/3.mp3",
            "stories/fox_and_crow/tr/4/4.mp3",
            "stories/fox_and_crow/tr/5/5.mp3"
        )
    ),
    Story(
        id = 3,
        englishTitle = "The Lion and the Mouse",
        arabicTitle = "الأسد والفأر",
        turkishTitle = "Aslan ve Fare",
        englishImagePaths = listOf(
            "stories/lion_mouse/en/cover/cover.webp",
            "stories/lion_mouse/en/1/1.webp",
            "stories/lion_mouse/en/2/2.webp",
            "stories/lion_mouse/en/3/3.webp",
            "stories/lion_mouse/en/4/4.webp",
            "stories/lion_mouse/en/5/5.webp",
            "stories/lion_mouse/en/6/6.webp"
        ),
        arabicImagePaths = listOf(
            "stories/lion_mouse/ar/cover/cover.webp",
            "stories/lion_mouse/ar/1/1.webp",
            "stories/lion_mouse/ar/2/2.webp",
            "stories/lion_mouse/ar/3/3.webp",
            "stories/lion_mouse/ar/4/4.webp",
            "stories/lion_mouse/ar/5/5.webp",
            "stories/lion_mouse/ar/6/6.webp"
        ),
        turkishImagePaths = listOf(
            "stories/lion_mouse/tr/cover/cover.webp",
            "stories/lion_mouse/tr/1/1.webp",
            "stories/lion_mouse/tr/2/2.webp",
            "stories/lion_mouse/tr/3/3.webp",
            "stories/lion_mouse/tr/4/4.webp",
            "stories/lion_mouse/tr/5/5.webp",
            "stories/lion_mouse/tr/6/6.webp"
        ),
        englishAudioPaths = listOf(
            "stories/lion_mouse/en/cover/cover.mp3",
            "stories/lion_mouse/en/1/1.mp3",
            "stories/lion_mouse/en/2/2.mp3",
            "stories/lion_mouse/en/3/3.mp3",
            "stories/lion_mouse/en/4/4.mp3",
            "stories/lion_mouse/en/5/5.mp3",
            "stories/lion_mouse/en/6/6.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/lion_mouse/ar/cover/cover.mp3",
            "stories/lion_mouse/ar/1/1.mp3",
            "stories/lion_mouse/ar/2/2.mp3",
            "stories/lion_mouse/ar/3/3.mp3",
            "stories/lion_mouse/ar/4/4.mp3",
            "stories/lion_mouse/ar/5/5.mp3",
            "stories/lion_mouse/ar/6/6.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/lion_mouse/tr/cover/cover.mp3",
            "stories/lion_mouse/tr/1/1.mp3",
            "stories/lion_mouse/tr/2/2.mp3",
            "stories/lion_mouse/tr/3/3.mp3",
            "stories/lion_mouse/tr/4/4.mp3",
            "stories/lion_mouse/tr/5/5.mp3",
            "stories/lion_mouse/tr/6/6.mp3"
        )
    ),
    Story(
        id = 4,
        englishTitle = "Big and Small Cat",
        arabicTitle = "القطة الكبيرة والصغيرة",
        turkishTitle = "Büyük ve Küçük Kedi",
        englishImagePaths = listOf(
            "stories/big_and_small_cat/en/cover/cover.webp",
            "stories/big_and_small_cat/en/1/1.webp",
            "stories/big_and_small_cat/en/2/2.webp",
            "stories/big_and_small_cat/en/3/3.webp",
            "stories/big_and_small_cat/en/4/4.webp",
            "stories/big_and_small_cat/en/5/5.webp",
            "stories/big_and_small_cat/en/6/6.webp",
            "stories/big_and_small_cat/en/7/7.webp"
        ),
        arabicImagePaths = listOf(
            "stories/big_and_small_cat/ar/cover/cover.webp",
            "stories/big_and_small_cat/ar/1/1.webp",
            "stories/big_and_small_cat/ar/2/2.webp",
            "stories/big_and_small_cat/ar/3/3.webp",
            "stories/big_and_small_cat/ar/4/4.webp",
            "stories/big_and_small_cat/ar/5/5.webp",
            "stories/big_and_small_cat/ar/6/6.webp",
            "stories/big_and_small_cat/ar/7/7.webp"
        ),
        turkishImagePaths = listOf(
            "stories/big_and_small_cat/tr/cover/cover.webp",
            "stories/big_and_small_cat/tr/1/1.webp",
            "stories/big_and_small_cat/tr/2/2.webp",
            "stories/big_and_small_cat/tr/3/3.webp",
            "stories/big_and_small_cat/tr/4/4.webp",
            "stories/big_and_small_cat/tr/5/5.webp",
            "stories/big_and_small_cat/tr/6/6.webp",
            "stories/big_and_small_cat/tr/7/7.webp"
        ),
        englishAudioPaths = listOf(
            "stories/big_and_small_cat/en/cover/cover.mp3",
            "stories/big_and_small_cat/en/1/1.mp3",
            "stories/big_and_small_cat/en/2/2.mp3",
            "stories/big_and_small_cat/en/3/3.mp3",
            "stories/big_and_small_cat/en/4/4.mp3",
            "stories/big_and_small_cat/en/5/5.mp3",
            "stories/big_and_small_cat/en/6/6.mp3",
            "stories/big_and_small_cat/en/7/7.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/big_and_small_cat/ar/cover/cover.mp3",
            "stories/big_and_small_cat/ar/1/1.mp3",
            "stories/big_and_small_cat/ar/2/2.mp3",
            "stories/big_and_small_cat/ar/3/3.mp3",
            "stories/big_and_small_cat/ar/4/4.mp3",
            "stories/big_and_small_cat/ar/5/5.mp3",
            "stories/big_and_small_cat/ar/6/6.mp3",
            "stories/big_and_small_cat/ar/7/7.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/big_and_small_cat/tr/cover/cover.mp3",
            "stories/big_and_small_cat/tr/1/1.mp3",
            "stories/big_and_small_cat/tr/2/2.mp3",
            "stories/big_and_small_cat/tr/3/3.mp3",
            "stories/big_and_small_cat/tr/4/4.mp3",
            "stories/big_and_small_cat/tr/5/5.mp3",
            "stories/big_and_small_cat/tr/6/6.mp3",
            "stories/big_and_small_cat/tr/7/7.mp3"
        )
    ),
    Story(
        id = 5,
        englishTitle = "Choo-Choo to Bedtime",
        arabicTitle = "تشو-تشو إلى وقت النوم",
        turkishTitle = "Choo-Choo Uyku Zamanı",
        englishImagePaths = listOf(
            "stories/choo_choo_to_bedtime/en/cover/cover.webp",
            "stories/choo_choo_to_bedtime/en/1/1.webp",
            "stories/choo_choo_to_bedtime/en/2/2.webp",
            "stories/choo_choo_to_bedtime/en/3/3.webp",
            "stories/choo_choo_to_bedtime/en/4/4.webp",
            "stories/choo_choo_to_bedtime/en/5/5.webp",
            "stories/choo_choo_to_bedtime/en/6/6.webp",
            "stories/choo_choo_to_bedtime/en/7/7.webp",
            "stories/choo_choo_to_bedtime/en/8/8.webp"
        ),
        arabicImagePaths = listOf(
            "stories/choo_choo_to_bedtime/ar/cover/cover.webp",
            "stories/choo_choo_to_bedtime/ar/1/1.webp",
            "stories/choo_choo_to_bedtime/ar/2/ar_2.webp",
            "stories/choo_choo_to_bedtime/ar/3/ar_3.webp",
            "stories/choo_choo_to_bedtime/ar/4/ar_4.webp",
            "stories/choo_choo_to_bedtime/ar/5/ar_5.webp",
            "stories/choo_choo_to_bedtime/ar/6/ar_6.webp",
            "stories/choo_choo_to_bedtime/ar/7/ar_7.webp",
            "stories/choo_choo_to_bedtime/ar/8/ar_8.webp"
        ),
        turkishImagePaths = listOf(
            "stories/choo_choo_to_bedtime/tr/cover/cover.webp",
            "stories/choo_choo_to_bedtime/tr/1/1.webp",
            "stories/choo_choo_to_bedtime/tr/2/2.webp",
            "stories/choo_choo_to_bedtime/tr/3/3.webp",
            "stories/choo_choo_to_bedtime/tr/4/4.webp",
            "stories/choo_choo_to_bedtime/tr/5/5.webp",
            "stories/choo_choo_to_bedtime/tr/6/6.webp",
            "stories/choo_choo_to_bedtime/tr/7/7.webp",
            "stories/choo_choo_to_bedtime/tr/8/8.webp"
        ),
        englishAudioPaths = listOf(
            "stories/choo_choo_to_bedtime/en/cover/cover.mp3",
            "stories/choo_choo_to_bedtime/en/1/1.mp3",
            "stories/choo_choo_to_bedtime/en/2/2.mp3",
            "stories/choo_choo_to_bedtime/en/3/3.mp3",
            "stories/choo_choo_to_bedtime/en/4/4.mp3",
            "stories/choo_choo_to_bedtime/en/5/5.mp3",
            "stories/choo_choo_to_bedtime/en/6/6.mp3",
            "stories/choo_choo_to_bedtime/en/7/7.mp3",
            "stories/choo_choo_to_bedtime/en/8/8.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/choo_choo_to_bedtime/ar/cover/cover.mp3",
            "stories/choo_choo_to_bedtime/ar/1/1.mp3",
            "stories/choo_choo_to_bedtime/ar/2/2.mp3",
            "stories/choo_choo_to_bedtime/ar/3/3.mp3",
            "stories/choo_choo_to_bedtime/ar/4/4.mp3",
            "stories/choo_choo_to_bedtime/ar/5/5.mp3",
            "stories/choo_choo_to_bedtime/ar/6/6.mp3",
            "stories/choo_choo_to_bedtime/ar/7/7.mp3",
            "stories/choo_choo_to_bedtime/ar/8/8.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/choo_choo_to_bedtime/tr/cover/cover.mp3",
            "stories/choo_choo_to_bedtime/tr/1/1.mp3",
            "stories/choo_choo_to_bedtime/tr/2/2.mp3",
            "stories/choo_choo_to_bedtime/tr/3/3.mp3",
            "stories/choo_choo_to_bedtime/tr/4/4.mp3",
            "stories/choo_choo_to_bedtime/tr/5/5.mp3",
            "stories/choo_choo_to_bedtime/tr/6/6.mp3",
            "stories/choo_choo_to_bedtime/tr/7/7.mp3",
            "stories/choo_choo_to_bedtime/tr/8/8.mp3"
        )
    ),
    Story(
        id = 6,
        englishTitle = "Leo the Little Astronaut",
        arabicTitle = "ليو رائد الفضاء الصغير",
        turkishTitle = "Küçük Astronot Leo",
        englishImagePaths = listOf(
            "stories/leo_the_little_astronaut/en/cover/cover.webp",
            "stories/leo_the_little_astronaut/en/1/1.webp",
            "stories/leo_the_little_astronaut/en/2/2.webp",
            "stories/leo_the_little_astronaut/en/3/3.webp",
            "stories/leo_the_little_astronaut/en/4/4.webp",
            "stories/leo_the_little_astronaut/en/5/5.webp",
            "stories/leo_the_little_astronaut/en/6/6.webp"
        ),
        arabicImagePaths = listOf(
            "stories/leo_the_little_astronaut/ar/cover/cover.webp",
            "stories/leo_the_little_astronaut/ar/1/1.webp",
            "stories/leo_the_little_astronaut/ar/2/2.webp",
            "stories/leo_the_little_astronaut/ar/3/3.webp",
            "stories/leo_the_little_astronaut/ar/4/4.webp",
            "stories/leo_the_little_astronaut/ar/5/5.webp",
            "stories/leo_the_little_astronaut/ar/6/6.webp"
        ),
        turkishImagePaths = listOf(
            "stories/leo_the_little_astronaut/tr/cover/cover.webp",
            "stories/leo_the_little_astronaut/tr/1/1.webp",
            "stories/leo_the_little_astronaut/tr/2/2.webp",
            "stories/leo_the_little_astronaut/tr/3/3.webp",
            "stories/leo_the_little_astronaut/tr/4/4.webp",
            "stories/leo_the_little_astronaut/tr/5/5.webp",
            "stories/leo_the_little_astronaut/tr/6/6.webp"
        ),
        englishAudioPaths = listOf(
            "stories/leo_the_little_astronaut/en/cover/cover.mp3",
            "stories/leo_the_little_astronaut/en/1/1.mp3",
            "stories/leo_the_little_astronaut/en/2/2.mp3",
            "stories/leo_the_little_astronaut/en/3/3.mp3",
            "stories/leo_the_little_astronaut/en/4/4.mp3",
            "stories/leo_the_little_astronaut/en/5/5.mp3",
            "stories/leo_the_little_astronaut/en/6/6.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/leo_the_little_astronaut/ar/cover/cover.mp3",
            "stories/leo_the_little_astronaut/ar/1/1.mp3",
            "stories/leo_the_little_astronaut/ar/2/2.mp3",
            "stories/leo_the_little_astronaut/ar/3/3.mp3",
            "stories/leo_the_little_astronaut/ar/4/4.mp3",
            "stories/leo_the_little_astronaut/ar/5/5.mp3",
            "stories/leo_the_little_astronaut/ar/6/6.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/leo_the_little_astronaut/tr/cover/cover.mp3",
            "stories/leo_the_little_astronaut/tr/1/1.mp3",
            "stories/leo_the_little_astronaut/tr/2/2.mp3",
            "stories/leo_the_little_astronaut/tr/3/3.mp3",
            "stories/leo_the_little_astronaut/tr/4/4.mp3",
            "stories/leo_the_little_astronaut/tr/5/5.mp3",
            "stories/leo_the_little_astronaut/tr/6/6.mp3"
        )
    ),
    Story(
        id = 7,
        englishTitle = "Lila the Flying Butterfly",
        arabicTitle = "ليلى الفراشة الطائرة",
        turkishTitle = "Uçan Kelebek Lila",
        englishImagePaths = listOf(
            "stories/lila_the_flying_butterfly/en/cover/cover.webp",
            "stories/lila_the_flying_butterfly/en/1/1.webp",
            "stories/lila_the_flying_butterfly/en/2/2.webp",
            "stories/lila_the_flying_butterfly/en/3/3.webp",
            "stories/lila_the_flying_butterfly/en/4/4.webp",
            "stories/lila_the_flying_butterfly/en/5/5.webp",
            "stories/lila_the_flying_butterfly/en/6/6.webp",
            "stories/lila_the_flying_butterfly/en/7/7.webp",
            "stories/lila_the_flying_butterfly/en/8/8.webp"
        ),
        arabicImagePaths = listOf(
            "stories/lila_the_flying_butterfly/ar/cover/cover.webp",
            "stories/lila_the_flying_butterfly/ar/1/1.webp",
            "stories/lila_the_flying_butterfly/ar/2/2.webp",
            "stories/lila_the_flying_butterfly/ar/3/3.webp",
            "stories/lila_the_flying_butterfly/ar/4/4.webp",
            "stories/lila_the_flying_butterfly/ar/5/5.webp",
            "stories/lila_the_flying_butterfly/ar/6/6.webp",
            "stories/lila_the_flying_butterfly/ar/7/7.webp",
            "stories/lila_the_flying_butterfly/ar/8/8.webp"
        ),
        turkishImagePaths = listOf(
            "stories/lila_the_flying_butterfly/tr/cover/cover.webp",
            "stories/lila_the_flying_butterfly/tr/1/1.webp",
            "stories/lila_the_flying_butterfly/tr/2/2.webp",
            "stories/lila_the_flying_butterfly/tr/3/3.webp",
            "stories/lila_the_flying_butterfly/tr/4/4.webp",
            "stories/lila_the_flying_butterfly/tr/5/5.webp",
            "stories/lila_the_flying_butterfly/tr/6/6.webp",
            "stories/lila_the_flying_butterfly/tr/7/7.webp",
            "stories/lila_the_flying_butterfly/tr/8/8.webp"
        ),
        englishAudioPaths = listOf(
            "stories/lila_the_flying_butterfly/en/cover/cover.mp3",
            "stories/lila_the_flying_butterfly/en/1/1.mp3",
            "stories/lila_the_flying_butterfly/en/2/2.mp3",
            "stories/lila_the_flying_butterfly/en/3/3.mp3",
            "stories/lila_the_flying_butterfly/en/4/4.mp3",
            "stories/lila_the_flying_butterfly/en/5/5.mp3",
            "stories/lila_the_flying_butterfly/en/6/6.mp3",
            "stories/lila_the_flying_butterfly/en/7/7.mp3",
            "stories/lila_the_flying_butterfly/en/8/8.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/lila_the_flying_butterfly/ar/cover/cover.mp3",
            "stories/lila_the_flying_butterfly/ar/1/1.mp3",
            "stories/lila_the_flying_butterfly/ar/2/2.mp3",
            "stories/lila_the_flying_butterfly/ar/3/3.mp3",
            "stories/lila_the_flying_butterfly/ar/4/4.mp3",
            "stories/lila_the_flying_butterfly/ar/5/5.mp3",
            "stories/lila_the_flying_butterfly/ar/6/6.mp3",
            "stories/lila_the_flying_butterfly/ar/7/7.mp3",
            "stories/lila_the_flying_butterfly/ar/8/8.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/lila_the_flying_butterfly/tr/cover/cover.mp3",
            "stories/lila_the_flying_butterfly/tr/1/1.mp3",
            "stories/lila_the_flying_butterfly/tr/2/2.mp3",
            "stories/lila_the_flying_butterfly/tr/3/3.mp3",
            "stories/lila_the_flying_butterfly/tr/4/4.mp3",
            "stories/lila_the_flying_butterfly/tr/5/5.mp3",
            "stories/lila_the_flying_butterfly/tr/6/6.mp3",
            "stories/lila_the_flying_butterfly/tr/7/7.mp3",
            "stories/lila_the_flying_butterfly/tr/8/8.mp3"
        )
    ),
    Story(
        id = 8,
        englishTitle = "Lily the Ladybug's Colors",
        arabicTitle = "ألوان الدعسوقة ليلي",
        turkishTitle = "Uğurböceği Lily'nin Renkleri",
        englishImagePaths = listOf(
            "stories/lily_the_ladybug_s_colors/en/cover/cover.webp",
            "stories/lily_the_ladybug_s_colors/en/1/1.webp",
            "stories/lily_the_ladybug_s_colors/en/2/2.webp",
            "stories/lily_the_ladybug_s_colors/en/3/3.webp",
            "stories/lily_the_ladybug_s_colors/en/4/4.webp"
        ),
        arabicImagePaths = listOf(
            "stories/lily_the_ladybug_s_colors/ar/cover/cover.webp",
            "stories/lily_the_ladybug_s_colors/ar/1/1.webp",
            "stories/lily_the_ladybug_s_colors/ar/2/2.webp",
            "stories/lily_the_ladybug_s_colors/ar/3/3.webp",
            "stories/lily_the_ladybug_s_colors/ar/4/4.webp"
        ),
        turkishImagePaths = listOf(
            "stories/lily_the_ladybug_s_colors/tr/cover/cover.webp",
            "stories/lily_the_ladybug_s_colors/tr/1/1.webp",
            "stories/lily_the_ladybug_s_colors/tr/2/2.webp",
            "stories/lily_the_ladybug_s_colors/tr/3/3.webp",
            "stories/lily_the_ladybug_s_colors/tr/4/4.webp"
        ),
        englishAudioPaths = listOf(
            "stories/lily_the_ladybug_s_colors/en/cover/cover.mp3",
            "stories/lily_the_ladybug_s_colors/en/1/1.mp3",
            "stories/lily_the_ladybug_s_colors/en/2/2.mp3",
            "stories/lily_the_ladybug_s_colors/en/3/3.mp3",
            "stories/lily_the_ladybug_s_colors/en/4/4.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/lily_the_ladybug_s_colors/ar/cover/cover.mp3",
            "stories/lily_the_ladybug_s_colors/ar/1/1.mp3",
            "stories/lily_the_ladybug_s_colors/ar/2/2.mp3",
            "stories/lily_the_ladybug_s_colors/ar/3/3.mp3",
            "stories/lily_the_ladybug_s_colors/ar/4/4.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/lily_the_ladybug_s_colors/tr/cover/cover.mp3",
            "stories/lily_the_ladybug_s_colors/tr/1/1.mp3",
            "stories/lily_the_ladybug_s_colors/tr/2/2.mp3",
            "stories/lily_the_ladybug_s_colors/tr/3/3.mp3",
            "stories/lily_the_ladybug_s_colors/tr/4/4.mp3"
        )
    ),
    Story(
        id = 9,
        englishTitle = "Little Bear Honey's Picnic",
        arabicTitle = "نزهة الدب الصغير هوني",
        turkishTitle = "Küçük Ayı Honey'nin Pikniği",
        englishImagePaths = listOf(
            "stories/little_bear_honey_s_picnic/en/cover/cover.webp",
            "stories/little_bear_honey_s_picnic/en/1/1.webp",
            "stories/little_bear_honey_s_picnic/en/2/2.webp",
            "stories/little_bear_honey_s_picnic/en/3/3.webp",
            "stories/little_bear_honey_s_picnic/en/4/4.webp",
            "stories/little_bear_honey_s_picnic/en/5/5.webp",
            "stories/little_bear_honey_s_picnic/en/6/6.webp",
            "stories/little_bear_honey_s_picnic/en/7/7.webp"
        ),
        arabicImagePaths = listOf(
            "stories/little_bear_honey_s_picnic/ar/cover/cover.webp",
            "stories/little_bear_honey_s_picnic/ar/1/1.webp",
            "stories/little_bear_honey_s_picnic/ar/2/2.webp",
            "stories/little_bear_honey_s_picnic/ar/3/3.webp",
            "stories/little_bear_honey_s_picnic/ar/4/4.webp",
            "stories/little_bear_honey_s_picnic/ar/5/5.webp",
            "stories/little_bear_honey_s_picnic/ar/6/6.webp",
            "stories/little_bear_honey_s_picnic/ar/7/7.webp"
        ),
        turkishImagePaths = listOf(
            "stories/little_bear_honey_s_picnic/tr/cover/cover.webp",
            "stories/little_bear_honey_s_picnic/tr/1/1.webp",
            "stories/little_bear_honey_s_picnic/tr/2/2.webp",
            "stories/little_bear_honey_s_picnic/tr/3/3.webp",
            "stories/little_bear_honey_s_picnic/tr/4/4.webp",
            "stories/little_bear_honey_s_picnic/tr/5/5.webp",
            "stories/little_bear_honey_s_picnic/tr/6/6.webp",
            "stories/little_bear_honey_s_picnic/tr/7/7.webp"
        ),
        englishAudioPaths = listOf(
            "stories/little_bear_honey_s_picnic/en/cover/cover.mp3",
            "stories/little_bear_honey_s_picnic/en/1/1.mp3",
            "stories/little_bear_honey_s_picnic/en/2/2.mp3",
            "stories/little_bear_honey_s_picnic/en/3/3.mp3",
            "stories/little_bear_honey_s_picnic/en/4/4.mp3",
            "stories/little_bear_honey_s_picnic/en/5/5.mp3",
            "stories/little_bear_honey_s_picnic/en/6/6.mp3",
            "stories/little_bear_honey_s_picnic/en/7/7.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/little_bear_honey_s_picnic/ar/cover/cover.mp3",
            "stories/little_bear_honey_s_picnic/ar/1/1.mp3",
            "stories/little_bear_honey_s_picnic/ar/2/2.mp3",
            "stories/little_bear_honey_s_picnic/ar/3/3.mp3",
            "stories/little_bear_honey_s_picnic/ar/4/4.mp3",
            "stories/little_bear_honey_s_picnic/ar/5/5.mp3",
            "stories/little_bear_honey_s_picnic/ar/6/6.mp3",
            "stories/little_bear_honey_s_picnic/ar/7/7.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/little_bear_honey_s_picnic/tr/cover/cover.mp3",
            "stories/little_bear_honey_s_picnic/tr/1/1.mp3",
            "stories/little_bear_honey_s_picnic/tr/2/2.mp3",
            "stories/little_bear_honey_s_picnic/tr/3/3.mp3",
            "stories/little_bear_honey_s_picnic/tr/4/4.mp3",
            "stories/little_bear_honey_s_picnic/tr/5/5.mp3",
            "stories/little_bear_honey_s_picnic/tr/6/6.mp3",
            "stories/little_bear_honey_s_picnic/tr/7/7.mp3"
        )
    ),
    Story(
        id = 10,
        englishTitle = "Red, Yellow, Green - Traffic Light",
        arabicTitle = "أحمر، أصفر، أخضر - إشارة المرور",
        turkishTitle = "Kırmızı, Sarı, Yeşil - Trafik Işığı",
        englishImagePaths = listOf(
            "stories/red_yellow_green_traffic_light/en/cover/cover.webp",
            "stories/red_yellow_green_traffic_light/en/1/1.webp",
            "stories/red_yellow_green_traffic_light/en/2/2.webp",
            "stories/red_yellow_green_traffic_light/en/3/3.webp",
            "stories/red_yellow_green_traffic_light/en/4/4.webp",
            "stories/red_yellow_green_traffic_light/en/5/5.webp",
            "stories/red_yellow_green_traffic_light/en/6/6.webp",
            "stories/red_yellow_green_traffic_light/en/7/7.webp"
        ),
        arabicImagePaths = listOf(
            "stories/red_yellow_green_traffic_light/ar/cover/cover.webp",
            "stories/red_yellow_green_traffic_light/ar/1/1.webp",
            "stories/red_yellow_green_traffic_light/ar/2/2.webp",
            "stories/red_yellow_green_traffic_light/ar/3/3.webp",
            "stories/red_yellow_green_traffic_light/ar/4/4.webp",
            "stories/red_yellow_green_traffic_light/ar/5/5.webp",
            "stories/red_yellow_green_traffic_light/ar/6/6.webp"
        ),
        turkishImagePaths = listOf(
            "stories/red_yellow_green_traffic_light/tr/cover/cover.webp",
            "stories/red_yellow_green_traffic_light/tr/1/1.webp",
            "stories/red_yellow_green_traffic_light/tr/2/2.webp",
            "stories/red_yellow_green_traffic_light/tr/3/3.webp",
            "stories/red_yellow_green_traffic_light/tr/4/4.webp",
            "stories/red_yellow_green_traffic_light/tr/5/5.webp",
            "stories/red_yellow_green_traffic_light/tr/6/6.webp",
            "stories/red_yellow_green_traffic_light/tr/7/7.webp"
        ),
        englishAudioPaths = listOf(
            "stories/red_yellow_green_traffic_light/en/cover/cover.mp3",
            "stories/red_yellow_green_traffic_light/en/1/1.mp3",
            "stories/red_yellow_green_traffic_light/en/2/2.mp3",
            "stories/red_yellow_green_traffic_light/en/3/3.mp3",
            "stories/red_yellow_green_traffic_light/en/4/cover.mp3",
            "stories/red_yellow_green_traffic_light/en/5/5.mp3",
            "stories/red_yellow_green_traffic_light/en/6/6.mp3",
            "stories/red_yellow_green_traffic_light/en/7/7.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/red_yellow_green_traffic_light/ar/cover/cover.mp3",
            "stories/red_yellow_green_traffic_light/ar/1/1.mp3",
            "stories/red_yellow_green_traffic_light/ar/2/2.mp3",
            "stories/red_yellow_green_traffic_light/ar/3/3.mp3",
            "stories/red_yellow_green_traffic_light/ar/4/4.mp3",
            "stories/red_yellow_green_traffic_light/ar/5/5.mp3",
            "stories/red_yellow_green_traffic_light/ar/6/6.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/red_yellow_green_traffic_light/tr/cover/cover.mp3",
            "stories/red_yellow_green_traffic_light/tr/1/1.mp3",
            "stories/red_yellow_green_traffic_light/tr/2/2.mp3",
            "stories/red_yellow_green_traffic_light/tr/3/3.mp3",
            "stories/red_yellow_green_traffic_light/tr/4/4.mp3",
            "stories/red_yellow_green_traffic_light/tr/5/5.mp3",
            "stories/red_yellow_green_traffic_light/tr/6/6.mp3",
            "stories/red_yellow_green_traffic_light/tr/7/7.mp3"
        )
    ),
    Story(
        id = 11,
        englishTitle = "The Fingers Five",
        arabicTitle = "الأصابع الخمسة",
        turkishTitle = "Beş Parmak",
        englishImagePaths = listOf(
            "stories/the_finggers_five/en/cover/cover.webp",
            "stories/the_finggers_five/en/1/1.webp",
            "stories/the_finggers_five/en/2/2.webp",
            "stories/the_finggers_five/en/3/3.webp",
            "stories/the_finggers_five/en/4/4.webp",
            "stories/the_finggers_five/en/5/5.webp",
            "stories/the_finggers_five/en/6/6.webp"
        ),
        arabicImagePaths = listOf(
            "stories/the_finggers_five/ar/cover/cover.webp",
            "stories/the_finggers_five/ar/1/1.webp",
            "stories/the_finggers_five/ar/2/2.webp",
            "stories/the_finggers_five/ar/3/3.webp",
            "stories/the_finggers_five/ar/4/4.webp",
            "stories/the_finggers_five/ar/5/5.webp",
            "stories/the_finggers_five/ar/6/6.webp"
        ),
        turkishImagePaths = listOf(
            "stories/the_finggers_five/tr/cover/cover.webp",
            "stories/the_finggers_five/tr/1/1.webp",
            "stories/the_finggers_five/tr/2/2.webp",
            "stories/the_finggers_five/tr/3/3.webp",
            "stories/the_finggers_five/tr/4/4.webp",
            "stories/the_finggers_five/tr/5/5.webp",
            "stories/the_finggers_five/tr/6/6.webp"
        ),
        englishAudioPaths = listOf(
            "stories/the_finggers_five/en/cover/cover.mp3",
            "stories/the_finggers_five/en/1/1.mp3",
            "stories/the_finggers_five/en/2/2.mp3",
            "stories/the_finggers_five/en/3/3.mp3",
            "stories/the_finggers_five/en/4/4.mp3",
            "stories/the_finggers_five/en/5/5.mp3",
            "stories/the_finggers_five/en/6/6.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/the_finggers_five/ar/cover/cover.mp3",
            "stories/the_finggers_five/ar/1/1.mp3",
            "stories/the_finggers_five/ar/2/2.mp3",
            "stories/the_finggers_five/ar/3/3.mp3",
            "stories/the_finggers_five/ar/4/4.mp3",
            "stories/the_finggers_five/ar/5/5.mp3",
            "stories/the_finggers_five/ar/6/6.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/the_finggers_five/tr/cover/cover.mp3",
            "stories/the_finggers_five/tr/1/1.mp3",
            "stories/the_finggers_five/tr/2/2.mp3",
            "stories/the_finggers_five/tr/3/3.mp3",
            "stories/the_finggers_five/tr/4/4.mp3",
            "stories/the_finggers_five/tr/5/5.mp3",
            "stories/the_finggers_five/tr/6/6.mp3"
        )
    ),
    Story(
        id = 12,
        englishTitle = "The Little Blue Train",
        arabicTitle = "القطار الأزرق الصغير",
        turkishTitle = "Küçük Mavi Tren",
        englishImagePaths = listOf(
            "stories/the_little_blue_train/en/cover/cover.webp",
            "stories/the_little_blue_train/en/1/1.webp",
            "stories/the_little_blue_train/en/2/2.webp",
            "stories/the_little_blue_train/en/3/3.webp",
            "stories/the_little_blue_train/en/4/4.webp"
        ),
        arabicImagePaths = listOf(
            "stories/the_little_blue_train/ar/cover/cover.webp",
            "stories/the_little_blue_train/ar/1/1.webp",
            "stories/the_little_blue_train/ar/2/2.webp",
            "stories/the_little_blue_train/ar/3/3.webp",
            "stories/the_little_blue_train/ar/4/4.webp"
        ),
        turkishImagePaths = listOf(
            "stories/the_little_blue_train/tr/cover/cover.webp",
            "stories/the_little_blue_train/tr/1/1.webp",
            "stories/the_little_blue_train/tr/2/2.webp",
            "stories/the_little_blue_train/tr/3/3.webp",
            "stories/the_little_blue_train/tr/4/4.webp"
        ),
        englishAudioPaths = listOf(
            "stories/the_little_blue_train/en/cover/cover.mp3",
            "stories/the_little_blue_train/en/1/1.mp3",
            "stories/the_little_blue_train/en/2/2.mp3",
            "stories/the_little_blue_train/en/3/3.mp3",
            "stories/the_little_blue_train/en/4/4.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/the_little_blue_train/ar/cover/cover.mp3",
            "stories/the_little_blue_train/ar/1/1.mp3",
            "stories/the_little_blue_train/ar/2/2.mp3",
            "stories/the_little_blue_train/ar/3/3.mp3",
            "stories/the_little_blue_train/ar/4/4.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/the_little_blue_train/tr/cover/cover.mp3",
            "stories/the_little_blue_train/tr/1/1.mp3",
            "stories/the_little_blue_train/tr/2/2.mp3",
            "stories/the_little_blue_train/tr/3/3.mp3",
            "stories/the_little_blue_train/tr/4/4.mp3"
        )
    ),
    Story(
        id = 13,
        englishTitle = "The Lost Blue Sock",
        arabicTitle = "الجورب الأزرق المفقود",
        turkishTitle = "Kayıp Mavi Çorap",
        englishImagePaths = listOf(
            "stories/the_lost_blue_sock/en/cover/cover.webp",
            "stories/the_lost_blue_sock/en/1/1.webp",
            "stories/the_lost_blue_sock/en/2/2.webp",
            "stories/the_lost_blue_sock/en/3/3.webp",
            "stories/the_lost_blue_sock/en/4/4.webp",
            "stories/the_lost_blue_sock/en/5/5.webp",
            "stories/the_lost_blue_sock/en/6/6.webp",
            "stories/the_lost_blue_sock/en/7/7.webp"
        ),
        arabicImagePaths = listOf(
            "stories/the_lost_blue_sock/ar/cover/cover.webp",
            "stories/the_lost_blue_sock/ar/1/1.webp",
            "stories/the_lost_blue_sock/ar/2/2.webp",
            "stories/the_lost_blue_sock/ar/3/3.webp",
            "stories/the_lost_blue_sock/ar/4/4.webp",
            "stories/the_lost_blue_sock/ar/5/5.webp",
            "stories/the_lost_blue_sock/ar/6/6.webp",
            "stories/the_lost_blue_sock/ar/7/7.webp"
        ),
        turkishImagePaths = listOf(
            "stories/the_lost_blue_sock/tr/cover/cover.webp",
            "stories/the_lost_blue_sock/tr/1/1.webp",
            "stories/the_lost_blue_sock/tr/2/2.webp",
            "stories/the_lost_blue_sock/tr/3/3.webp",
            "stories/the_lost_blue_sock/tr/4/4.webp",
            "stories/the_lost_blue_sock/tr/5/5.webp",
            "stories/the_lost_blue_sock/tr/6/6.webp",
            "stories/the_lost_blue_sock/tr/7/7.webp"
        ),
        englishAudioPaths = listOf(
            "stories/the_lost_blue_sock/en/cover/cover.mp3",
            "stories/the_lost_blue_sock/en/1/1.mp3",
            "stories/the_lost_blue_sock/en/2/2.mp3",
            "stories/the_lost_blue_sock/en/3/3.mp3",
            "stories/the_lost_blue_sock/en/4/4.mp3",
            "stories/the_lost_blue_sock/en/5/5.mp3",
            "stories/the_lost_blue_sock/en/6/6.mp3",
            "stories/the_lost_blue_sock/en/7/7.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/the_lost_blue_sock/ar/cover/cover.mp3",
            "stories/the_lost_blue_sock/ar/1/1.mp3",
            "stories/the_lost_blue_sock/ar/2/2.mp3",
            "stories/the_lost_blue_sock/ar/3/3.mp3",
            "stories/the_lost_blue_sock/ar/4/4.mp3",
            "stories/the_lost_blue_sock/ar/5/5.mp3",
            "stories/the_lost_blue_sock/ar/6/6.mp3",
            "stories/the_lost_blue_sock/ar/7/7.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/the_lost_blue_sock/tr/cover/cover.mp3",
            "stories/the_lost_blue_sock/tr/1/1.mp3",
            "stories/the_lost_blue_sock/tr/2/2.mp3",
            "stories/the_lost_blue_sock/tr/3/3.mp3",
            "stories/the_lost_blue_sock/tr/4/4.mp3",
            "stories/the_lost_blue_sock/tr/5/5.mp3",
            "stories/the_lost_blue_sock/tr/6/6.mp3",
            "stories/the_lost_blue_sock/tr/7/7.mp3"
        )
    ),
    Story(
        id = 14,
        englishTitle = "Timmy the Tiny Turtle",
        arabicTitle = "تيمي السلحفاة الصغيرة",
        turkishTitle = "Minik Kaplumbağa Timmy",
        englishImagePaths = listOf(
            "stories/timmy_the_tiny_turtle/en/cover/cover.webp",
            "stories/timmy_the_tiny_turtle/en/1/1.webp",
            "stories/timmy_the_tiny_turtle/en/2/2.webp",
            "stories/timmy_the_tiny_turtle/en/3/3.webp",
            "stories/timmy_the_tiny_turtle/en/4/4.webp",
            "stories/timmy_the_tiny_turtle/en/5/5.webp",
            "stories/timmy_the_tiny_turtle/en/6/6.webp"
        ),
        arabicImagePaths = listOf(
            "stories/timmy_the_tiny_turtle/ar/cover/cover.webp",
            "stories/timmy_the_tiny_turtle/ar/1/1.webp",
            "stories/timmy_the_tiny_turtle/ar/2/2.webp",
            "stories/timmy_the_tiny_turtle/ar/3/3.webp",
            "stories/timmy_the_tiny_turtle/ar/4/4.webp",
            "stories/timmy_the_tiny_turtle/ar/5/5.webp",
            "stories/timmy_the_tiny_turtle/ar/6/6.webp"
        ),
        turkishImagePaths = listOf(
            "stories/timmy_the_tiny_turtle/tr/cover/cover.webp",
            "stories/timmy_the_tiny_turtle/tr/1/1.webp",
            "stories/timmy_the_tiny_turtle/tr/2/2.webp",
            "stories/timmy_the_tiny_turtle/tr/3/3.webp",
            "stories/timmy_the_tiny_turtle/tr/4/4.webp",
            "stories/timmy_the_tiny_turtle/tr/5/5.webp",
            "stories/timmy_the_tiny_turtle/tr/6/6.webp"
        ),
        englishAudioPaths = listOf(
            "stories/timmy_the_tiny_turtle/en/cover/cover.mp3",
            "stories/timmy_the_tiny_turtle/en/1/1.mp3",
            "stories/timmy_the_tiny_turtle/en/2/2.mp3",
            "stories/timmy_the_tiny_turtle/en/3/3.mp3",
            "stories/timmy_the_tiny_turtle/en/4/4.mp3",
            "stories/timmy_the_tiny_turtle/en/5/5.mp3",
            "stories/timmy_the_tiny_turtle/en/6/6.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/timmy_the_tiny_turtle/ar/cover/cover.mp3",
            "stories/timmy_the_tiny_turtle/ar/1/1.mp3",
            "stories/timmy_the_tiny_turtle/ar/2/2.mp3",
            "stories/timmy_the_tiny_turtle/ar/3/3.mp3",
            "stories/timmy_the_tiny_turtle/ar/4/4.mp3",
            "stories/timmy_the_tiny_turtle/ar/5/5.mp3",
            "stories/timmy_the_tiny_turtle/ar/6/6.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/timmy_the_tiny_turtle/tr/cover/cover.mp3",
            "stories/timmy_the_tiny_turtle/tr/1/1.mp3",
            "stories/timmy_the_tiny_turtle/tr/2/2.mp3",
            "stories/timmy_the_tiny_turtle/tr/3/3.mp3",
            "stories/timmy_the_tiny_turtle/tr/4/4.mp3",
            "stories/timmy_the_tiny_turtle/tr/5/5.mp3",
            "stories/timmy_the_tiny_turtle/tr/6/6.mp3"
        )
    ),
    Story(
        id = 15,
        englishTitle = "Ziko the Tall Giraffe",
        arabicTitle = "زيكو الزرافة الطويلة",
        turkishTitle = "Uzun Zürafa Ziko",
        englishImagePaths = listOf(
            "stories/ziko_the_tall_giraffe/en/cover/cover.webp",
            "stories/ziko_the_tall_giraffe/en/1/1.webp",
            "stories/ziko_the_tall_giraffe/en/2/2.webp",
            "stories/ziko_the_tall_giraffe/en/3/3.webp",
            "stories/ziko_the_tall_giraffe/en/4/4.webp",
            "stories/ziko_the_tall_giraffe/en/5/5.webp",
            "stories/ziko_the_tall_giraffe/en/6/6.webp",
            "stories/ziko_the_tall_giraffe/en/7/7.webp"
        ),
        arabicImagePaths = listOf(
            "stories/ziko_the_tall_giraffe/ar/cover/cover.webp",
            "stories/ziko_the_tall_giraffe/ar/1/1.webp",
            "stories/ziko_the_tall_giraffe/ar/2/2.webp",
            "stories/ziko_the_tall_giraffe/ar/3/3.webp",
            "stories/ziko_the_tall_giraffe/ar/4/4.webp",
            "stories/ziko_the_tall_giraffe/ar/5/5.webp",
            "stories/ziko_the_tall_giraffe/ar/6/6.webp",
            "stories/ziko_the_tall_giraffe/ar/7/7.webp"
        ),
        turkishImagePaths = listOf(
            "stories/ziko_the_tall_giraffe/tr/cover/cover.webp",
            "stories/ziko_the_tall_giraffe/tr/1/1.webp",
            "stories/ziko_the_tall_giraffe/tr/2/2.webp",
            "stories/ziko_the_tall_giraffe/tr/3/3.webp",
            "stories/ziko_the_tall_giraffe/tr/4/4.webp",
            "stories/ziko_the_tall_giraffe/tr/5/5.webp",
            "stories/ziko_the_tall_giraffe/tr/6/6.webp",
            "stories/ziko_the_tall_giraffe/tr/7/7.webp"
        ),
        englishAudioPaths = listOf(
            "stories/ziko_the_tall_giraffe/en/cover/cover.mp3",
            "stories/ziko_the_tall_giraffe/en/1/1.mp3",
            "stories/ziko_the_tall_giraffe/en/2/2.mp3",
            "stories/ziko_the_tall_giraffe/en/3/3.mp3",
            "stories/ziko_the_tall_giraffe/en/4/4.mp3",
            "stories/ziko_the_tall_giraffe/en/5/5.mp3",
            "stories/ziko_the_tall_giraffe/en/6/6.mp3",
            "stories/ziko_the_tall_giraffe/en/7/7.mp3"
        ),
        arabicAudioPaths = listOf(
            "stories/ziko_the_tall_giraffe/ar/cover/cover.mp3",
            "stories/ziko_the_tall_giraffe/ar/1/1.mp3",
            "stories/ziko_the_tall_giraffe/ar/2/2.mp3",
            "stories/ziko_the_tall_giraffe/ar/3/3.mp3",
            "stories/ziko_the_tall_giraffe/ar/4/4.mp3",
            "stories/ziko_the_tall_giraffe/ar/5/5.mp3",
            "stories/ziko_the_tall_giraffe/ar/6/6.mp3",
            "stories/ziko_the_tall_giraffe/ar/7/7.mp3"
        ),
        turkishAudioPaths = listOf(
            "stories/ziko_the_tall_giraffe/tr/cover/cover.mp3",
            "stories/ziko_the_tall_giraffe/tr/1/1.mp3",
            "stories/ziko_the_tall_giraffe/tr/2/2.mp3",
            "stories/ziko_the_tall_giraffe/tr/3/3.mp3",
            "stories/ziko_the_tall_giraffe/tr/4/4.mp3",
            "stories/ziko_the_tall_giraffe/tr/5/5.mp3",
            "stories/ziko_the_tall_giraffe/tr/6/6.mp3",
            "stories/ziko_the_tall_giraffe/tr/7/7.mp3"
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



