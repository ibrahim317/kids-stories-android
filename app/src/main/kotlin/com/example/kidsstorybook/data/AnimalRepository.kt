package com.example.kidsstorybook.data

import com.example.kidsstorybook.models.Animal

object AnimalRepository {
    fun getAllAnimals(): List<Animal> {
        return listOf(
            Animal(
                name = "bear",
                englishName = "Bear",
                arabicName = "دب",
                turkishName = "Ayı",
                imagePath = "animals/bear/image.png",
                englishAudioPath = "animals/bear/Bear_English.wav",
                arabicAudioPath = "animals/bear/Dub_Arabic.wav",
                turkishAudioPath = "animals/bear/Ayı_Turkce.wav"
            ),
            Animal(
                name = "cat",
                englishName = "Cat",
                arabicName = "قطة",
                turkishName = "Kedi",
                imagePath = "animals/cat/image.png",
                englishAudioPath = "animals/cat/Cat_English.wav",
                arabicAudioPath = "animals/cat/QittahLateefah_Arabic.wav",
                turkishAudioPath = "animals/cat/Kedi_Turkce.wav"
            ),
            Animal(
                name = "dog",
                englishName = "Dog",
                arabicName = "كلب",
                turkishName = "Köpek",
                imagePath = "animals/dog/image.png",
                englishAudioPath = "animals/dog/Dog_English.wav",
                arabicAudioPath = "animals/dog/KalbSagheer_Arabic.wav",
                turkishAudioPath = "animals/dog/KopekYavrusu_Turkce.wav"
            ),
            Animal(
                name = "duck",
                englishName = "Duck",
                arabicName = "بطة",
                turkishName = "Ördek",
                imagePath = "animals/duck/image.png",
                englishAudioPath = "animals/duck/Duck_English.wav",
                arabicAudioPath = "animals/duck/BattahSagheerah_Arabic.wav",
                turkishAudioPath = "animals/duck/Ordek_Turkce.wav"
            ),
            Animal(
                name = "elephant",
                englishName = "Elephant",
                arabicName = "فيل",
                turkishName = "Fil",
                imagePath = "animals/elephant/image.png",
                englishAudioPath = "animals/elephant/Elephant_English.wav",
                arabicAudioPath = "animals/elephant/FilSagheer_Arabic.wav",
                turkishAudioPath = "animals/elephant/FilYavrusu_Turkce.wav"
            ),
            Animal(
                name = "fox",
                englishName = "Fox",
                arabicName = "ثعلب",
                turkishName = "Tilki",
                imagePath = "animals/fox/image.png",
                englishAudioPath = "animals/fox/Fox_English.wav",
                arabicAudioPath = "animals/fox/Tha'labSagheer_Arabic.wav",
                turkishAudioPath = "animals/fox/TilkiYavrusu_Turkce.wav"
            ),
            Animal(
                name = "giraffe",
                englishName = "Giraffe",
                arabicName = "زرافة",
                turkishName = "Zürafa",
                imagePath = "animals/giraffe/image.png",
                englishAudioPath = "animals/giraffe/Giraffe_English.wav",
                arabicAudioPath = "animals/giraffe/ZarafaSagheera_Arabic.wav",
                turkishAudioPath = "animals/giraffe/ZurafaYavrusu_Turkce.wav"
            ),
            Animal(
                name = "hippopotamus",
                englishName = "Hippopotamus",
                arabicName = "فرس النهر",
                turkishName = "Su Aygırı",
                imagePath = "animals/hippopotamus/image.png",
                englishAudioPath = "animals/hippopotamus/Hippo_English.wav",
                arabicAudioPath = "animals/hippopotamus/FarasNahrSagheer_Arabic.wav",
                turkishAudioPath = "animals/hippopotamus/SuAygiri_Turkce.wav"
            ),
            Animal(
                name = "lamb",
                englishName = "Lamb",
                arabicName = "خروف",
                turkishName = "Kuzu",
                imagePath = "animals/lamb/image.png",
                englishAudioPath = "animals/lamb/Lamb_English.wav",
                arabicAudioPath = "animals/lamb/HamalSagheer_Arabic.wav",
                turkishAudioPath = "animals/lamb/Kuzu_Turkce.wav"
            ),
            Animal(
                name = "lion",
                englishName = "Lion",
                arabicName = "أسد",
                turkishName = "Aslan",
                imagePath = "animals/lion/image.png",
                englishAudioPath = "animals/lion/LionCub_English.wav",
                arabicAudioPath = "animals/lion/ShiblAsad_Arabic.wav",
                turkishAudioPath = "animals/lion/AslanYavrusu_Turkce.wav"
            ),
            Animal(
                name = "monkey",
                englishName = "Monkey",
                arabicName = "قرد",
                turkishName = "Maymun",
                imagePath = "animals/monkey/image.png",
                englishAudioPath = "animals/monkey/Monkey_English.wav",
                arabicAudioPath = "animals/monkey/QirdSagheer_Arabic.wav",
                turkishAudioPath = "animals/monkey/Maymun_Turkce.wav"
            ),
            Animal(
                name = "owl",
                englishName = "Owl",
                arabicName = "بومة",
                turkishName = "Baykuş",
                imagePath = "animals/owl/image.png",
                englishAudioPath = "animals/owl/Owl_English.wav",
                arabicAudioPath = "animals/owl/BumahSagheerah_Arabic.wav",
                turkishAudioPath = "animals/owl/Baykus_Turkce.wav"
            ),
            Animal(
                name = "penguin",
                englishName = "Penguin",
                arabicName = "بطريق",
                turkishName = "Penguen",
                imagePath = "animals/penguin/image.png",
                englishAudioPath = "animals/penguin/Penguin_English.wav",
                arabicAudioPath = "animals/penguin/BatriqSagheer_Arabic.wav",
                turkishAudioPath = "animals/penguin/Penguen_Turkce.wav"
            ),
            Animal(
                name = "rabbit",
                englishName = "Rabbit",
                arabicName = "أرنب",
                turkishName = "Tavşan",
                imagePath = "animals/rabbit/image.png",
                englishAudioPath = "animals/rabbit/Rabbit_English.wav",
                arabicAudioPath = "animals/rabbit/Arnab_Arabic.wav",
                turkishAudioPath = "animals/rabbit/Tavşan_Turkce.wav"
            ),
            Animal(
                name = "squirrel",
                englishName = "Squirrel",
                arabicName = "سنجاب",
                turkishName = "Sincap",
                imagePath = "animals/squirrel/image.png",
                englishAudioPath = "animals/squirrel/Squirrel_English.wav",
                arabicAudioPath = "animals/squirrel/Sinjab_Arabic.wav",
                turkishAudioPath = "animals/squirrel/Sincap_Turkce.wav"
            ),
            Animal(
                name = "zebra",
                englishName = "Zebra",
                arabicName = "حمار وحشي",
                turkishName = "Zebra",
                imagePath = "animals/zebra/image.png",
                englishAudioPath = "animals/zebra/Zebra_English.wav",
                arabicAudioPath = "animals/zebra/HimarWahshi_Arabic.wav",
                turkishAudioPath = "animals/zebra/Zebra_Turkce.wav"
            )
        )
    }
}

