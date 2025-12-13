package com.shahadalrubaye.kidsstorybook.data

import com.shahadalrubaye.kidsstorybook.models.Animal

object AnimalRepository {
    fun getAllAnimals(): List<Animal> {
        return listOf(
            Animal(
                name = "bear",
                englishName = "Bear",
                arabicName = "دب",
                turkishName = "Ayı",
                imagePath = "animals/bear/image.webp",
                englishAudioPath = "animals/bear/Bear_English.mp3",
                arabicAudioPath = "animals/bear/Dub_Arabic.mp3",
                turkishAudioPath = "animals/bear/Ayı_Turkce.mp3"
            ),
            Animal(
                name = "cat",
                englishName = "Cat",
                arabicName = "قطة",
                turkishName = "Kedi",
                imagePath = "animals/cat/image.webp",
                englishAudioPath = "animals/cat/Cat_English.mp3",
                arabicAudioPath = "animals/cat/QittahLateefah_Arabic.mp3",
                turkishAudioPath = "animals/cat/Kedi_Turkce.mp3"
            ),
            Animal(
                name = "dog",
                englishName = "Dog",
                arabicName = "كلب",
                turkishName = "Köpek",
                imagePath = "animals/dog/image.webp",
                englishAudioPath = "animals/dog/Dog_English.mp3",
                arabicAudioPath = "animals/dog/KalbSagheer_Arabic.mp3",
                turkishAudioPath = "animals/dog/KopekYavrusu_Turkce.mp3"
            ),
            Animal(
                name = "duck",
                englishName = "Duck",
                arabicName = "بطة",
                turkishName = "Ördek",
                imagePath = "animals/duck/image.webp",
                englishAudioPath = "animals/duck/Duck_English.mp3",
                arabicAudioPath = "animals/duck/BattahSagheerah_Arabic.mp3",
                turkishAudioPath = "animals/duck/Ordek_Turkce.mp3"
            ),
            Animal(
                name = "elephant",
                englishName = "Elephant",
                arabicName = "فيل",
                turkishName = "Fil",
                imagePath = "animals/elephant/image.webp",
                englishAudioPath = "animals/elephant/Elephant_English.mp3",
                arabicAudioPath = "animals/elephant/FilSagheer_Arabic.mp3",
                turkishAudioPath = "animals/elephant/FilYavrusu_Turkce.mp3"
            ),
            Animal(
                name = "fox",
                englishName = "Fox",
                arabicName = "ثعلب",
                turkishName = "Tilki",
                imagePath = "animals/fox/image.webp",
                englishAudioPath = "animals/fox/Fox_English.mp3",
                arabicAudioPath = "animals/fox/Tha'labSagheer_Arabic.mp3",
                turkishAudioPath = "animals/fox/TilkiYavrusu_Turkce.mp3"
            ),
            Animal(
                name = "giraffe",
                englishName = "Giraffe",
                arabicName = "زرافة",
                turkishName = "Zürafa",
                imagePath = "animals/giraffe/image.webp",
                englishAudioPath = "animals/giraffe/Giraffe_English.mp3",
                arabicAudioPath = "animals/giraffe/ZarafaSagheera_Arabic.mp3",
                turkishAudioPath = "animals/giraffe/ZurafaYavrusu_Turkce.mp3"
            ),
            Animal(
                name = "hippopotamus",
                englishName = "Hippopotamus",
                arabicName = "فرس النهر",
                turkishName = "Su Aygırı",
                imagePath = "animals/hippopotamus/image.webp",
                englishAudioPath = "animals/hippopotamus/Hippo_English.mp3",
                arabicAudioPath = "animals/hippopotamus/FarasNahrSagheer_Arabic.mp3",
                turkishAudioPath = "animals/hippopotamus/SuAygiri_Turkce.mp3"
            ),
            Animal(
                name = "lamb",
                englishName = "Lamb",
                arabicName = "خروف",
                turkishName = "Kuzu",
                imagePath = "animals/lamb/image.webp",
                englishAudioPath = "animals/lamb/Lamb_English.mp3",
                arabicAudioPath = "animals/lamb/HamalSagheer_Arabic.mp3",
                turkishAudioPath = "animals/lamb/Kuzu_Turkce.mp3"
            ),
            Animal(
                name = "lion",
                englishName = "Lion",
                arabicName = "أسد",
                turkishName = "Aslan",
                imagePath = "animals/lion/image.webp",
                englishAudioPath = "animals/lion/LionCub_English.mp3",
                arabicAudioPath = "animals/lion/ShiblAsad_Arabic.mp3",
                turkishAudioPath = "animals/lion/AslanYavrusu_Turkce.mp3"
            ),
            Animal(
                name = "monkey",
                englishName = "Monkey",
                arabicName = "قرد",
                turkishName = "Maymun",
                imagePath = "animals/monkey/image.webp",
                englishAudioPath = "animals/monkey/Monkey_English.mp3",
                arabicAudioPath = "animals/monkey/QirdSagheer_Arabic.mp3",
                turkishAudioPath = "animals/monkey/Maymun_Turkce.mp3"
            ),
            Animal(
                name = "owl",
                englishName = "Owl",
                arabicName = "بومة",
                turkishName = "Baykuş",
                imagePath = "animals/owl/image.webp",
                englishAudioPath = "animals/owl/Owl_English.mp3",
                arabicAudioPath = "animals/owl/BumahSagheerah_Arabic.mp3",
                turkishAudioPath = "animals/owl/Baykus_Turkce.mp3"
            ),
            Animal(
                name = "penguin",
                englishName = "Penguin",
                arabicName = "بطريق",
                turkishName = "Penguen",
                imagePath = "animals/penguin/image.webp",
                englishAudioPath = "animals/penguin/Penguin_English.mp3",
                arabicAudioPath = "animals/penguin/BatriqSagheer_Arabic.mp3",
                turkishAudioPath = "animals/penguin/Penguen_Turkce.mp3"
            ),
            Animal(
                name = "rabbit",
                englishName = "Rabbit",
                arabicName = "أرنب",
                turkishName = "Tavşan",
                imagePath = "animals/rabbit/image.webp",
                englishAudioPath = "animals/rabbit/Rabbit_English.mp3",
                arabicAudioPath = "animals/rabbit/Arnab_Arabic.mp3",
                turkishAudioPath = "animals/rabbit/Tavşan_Turkce.mp3"
            ),
            Animal(
                name = "squirrel",
                englishName = "Squirrel",
                arabicName = "سنجاب",
                turkishName = "Sincap",
                imagePath = "animals/squirrel/image.webp",
                englishAudioPath = "animals/squirrel/Squirrel_English.mp3",
                arabicAudioPath = "animals/squirrel/Sinjab_Arabic.mp3",
                turkishAudioPath = "animals/squirrel/Sincap_Turkce.mp3"
            ),
            Animal(
                name = "zebra",
                englishName = "Zebra",
                arabicName = "حمار وحشي",
                turkishName = "Zebra",
                imagePath = "animals/zebra/image.webp",
                englishAudioPath = "animals/zebra/Zebra_English.mp3",
                arabicAudioPath = "animals/zebra/HimarWahshi_Arabic.mp3",
                turkishAudioPath = "animals/zebra/Zebra_Turkce.mp3"
            )
        )
    }
}

