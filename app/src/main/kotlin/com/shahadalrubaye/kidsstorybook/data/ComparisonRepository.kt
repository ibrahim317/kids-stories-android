package com.shahadalrubaye.kidsstorybook.data

import android.content.Context
import com.shahadalrubaye.kidsstorybook.models.ComparisonCategory
import com.shahadalrubaye.kidsstorybook.models.ComparisonGroup
import com.shahadalrubaye.kidsstorybook.models.ComparisonItem
import java.util.LinkedHashSet

object ComparisonRepository {

    private data class ComparisonContent(
        val title: String,
        val doText: String,
        val dontText: String
    )

    private val supportedIds = listOf(
        "parents",
        "brothers",
        "sisters",
        "grand_father",
        "grand_mother",
        "birthday",
        "bus",
        "dining_table",
        "friend_house",
        "house",
        "in_the_street",
        "mall",
        "school",
        "strangers"
    )

    private val englishContent = mapOf(
        "parents" to ComparisonContent(
            title = "With Parents",
            doText = "Listen to your parents and answer politely.",
            dontText = "Do not argue or ignore what they ask."
        ),
        "brothers" to ComparisonContent(
            title = "With Brothers",
            doText = "Share toys and take turns.",
            dontText = "Do not grab things or push your brothers."
        ),
        "sisters" to ComparisonContent(
            title = "With Sisters",
            doText = "Use kind words and offer help.",
            dontText = "Do not call names or shout at them."
        ),
        "grand_father" to ComparisonContent(
            title = "With Grandpa",
            doText = "Greet him warmly and help when he needs it.",
            dontText = "Do not turn away or refuse to help."
        ),
        "grand_mother" to ComparisonContent(
            title = "With Grandma",
            doText = "Sit close and listen to her stories.",
            dontText = "Do not interrupt or run off while she talks."
        ),
        "birthday" to ComparisonContent(
            title = "At a Birthday",
            doText = "Wait for your turn and thank others for gifts.",
            dontText = "Do not demand presents or grab before others."
        ),
        "bus" to ComparisonContent(
            title = "On the Bus",
            doText = "Sit safely and hold the rail.",
            dontText = "Do not run in the aisle or distract the driver."
        ),
        "dining_table" to ComparisonContent(
            title = "At the Table",
            doText = "Wash your hands and chew with your mouth closed.",
            dontText = "Do not talk with food in your mouth or play with dishes."
        ),
        "friend_house" to ComparisonContent(
            title = "At a Friend's Home",
            doText = "Follow their house rules and be gentle.",
            dontText = "Do not touch things without permission."
        ),
        "house" to ComparisonContent(
            title = "At Home",
            doText = "Help tidy up and speak calmly.",
            dontText = "Do not leave a mess or slam doors."
        ),
        "in_the_street" to ComparisonContent(
            title = "In the Street",
            doText = "Hold an adult's hand and look both ways.",
            dontText = "Do not run off or step into the road alone."
        ),
        "mall" to ComparisonContent(
            title = "In the Mall",
            doText = "Stay close to your family.",
            dontText = "Do not wander away or hide."
        ),
        "school" to ComparisonContent(
            title = "At School",
            doText = "Listen to your teacher and raise your hand.",
            dontText = "Do not interrupt the class or yell."
        ),
        "strangers" to ComparisonContent(
            title = "With Strangers",
            doText = "Stay near trusted adults and say no politely.",
            dontText = "Do not go anywhere or accept gifts from strangers."
        )
    )

    private val arabicContent = mapOf(
        "parents" to ComparisonContent(
            title = "مع الوالدين",
            doText = "استمع إلى والديك وتحدث بأدب.",
            dontText = "لا تجادل ولا تتجاهل طلبهما."
        ),
        "brothers" to ComparisonContent(
            title = "مع الإخوة",
            doText = "شارك ألعابك وتعاقب على الدور.",
            dontText = "لا تخطف الأشياء أو تدفع إخوتك."
        ),
        "sisters" to ComparisonContent(
            title = "مع الأخوات",
            doText = "استخدم كلمات لطيفة وقدم المساعدة.",
            dontText = "لا تنادِ بألقاب أو تصرخ عليهن."
        ),
        "grand_father" to ComparisonContent(
            title = "مع الجد",
            doText = "سلّم عليه بمحبة وساعده عند الحاجة.",
            dontText = "لا تدير ظهرك أو ترفض مساعدته."
        ),
        "grand_mother" to ComparisonContent(
            title = "مع الجدة",
            doText = "اجلس بقربها واستمع لقصصها.",
            dontText = "لا تقاطعها أو تبتعد وهي تتكلم."
        ),
        "birthday" to ComparisonContent(
            title = "في حفلة الميلاد",
            doText = "انتظر دورك واشكر الآخرين على الهدايا.",
            dontText = "لا تطلب الهدايا بإلحاح أو تخطفها."
        ),
        "bus" to ComparisonContent(
            title = "في الحافلة",
            doText = "اجلس بهدوء وتمسك بالمقبض.",
            dontText = "لا تركض في الممر أو تشتت السائق."
        ),
        "dining_table" to ComparisonContent(
            title = "على طاولة الطعام",
            doText = "اغسل يديك وامضغ وفمك مغلق.",
            dontText = "لا تتحدث وفمك ممتلئ أو تلعب بالأطباق."
        ),
        "friend_house" to ComparisonContent(
            title = "في بيت الصديق",
            doText = "اتبع قواعد البيت وكن رقيقاً.",
            dontText = "لا تلمس شيئاً دون إذن."
        ),
        "house" to ComparisonContent(
            title = "في المنزل",
            doText = "ساعد في الترتيب وتحدث بهدوء.",
            dontText = "لا تترك الفوضى أو تغلق الأبواب بقوة."
        ),
        "in_the_street" to ComparisonContent(
            title = "في الشارع",
            doText = "أمسك يد الراشد وانظر يميناً ويساراً.",
            dontText = "لا تركض وحدك إلى الطريق."
        ),
        "mall" to ComparisonContent(
            title = "في السوق",
            doText = "ابق قريباً من عائلتك.",
            dontText = "لا تبتعد أو تختبئ."
        ),
        "school" to ComparisonContent(
            title = "في المدرسة",
            doText = "استمع للمعلمة وارفع يدك.",
            dontText = "لا تقاطع الدرس أو تصرخ."
        ),
        "strangers" to ComparisonContent(
            title = "مع الغرباء",
            doText = "ابق قرب الكبار الذين تثق بهم وقل لا بأدب.",
            dontText = "لا تذهب مع شخص غريب أو تأخذ منه شيئاً."
        )
    )

    private val turkishContent = mapOf(
        "parents" to ComparisonContent(
            title = "Ebeveynlerle",
            doText = "Anne babanı dikkatle dinle ve nazikçe cevap ver.",
            dontText = "Onlarla tartışma ya da söylediklerini yok sayma."
        ),
        "brothers" to ComparisonContent(
            title = "Kardeşlerle",
            doText = "Oyuncakları paylaş ve sıranı bekle.",
            dontText = "Eşyaları kapma ya da kardeşini itme."
        ),
        "sisters" to ComparisonContent(
            title = "Kız kardeşlerle",
            doText = "Nazik sözler kullan ve yardım et.",
            dontText = "İsim takma ya da onlara bağırma."
        ),
        "grand_father" to ComparisonContent(
            title = "Dede ile",
            doText = "Sevgiyle selam ver ve ihtiyaç duyunca yardım et.",
            dontText = "Sırtını dönme ya da yardım etmeyi reddetme."
        ),
        "grand_mother" to ComparisonContent(
            title = "Büyükanne ile",
            doText = "Yanında otur ve hikâyelerini dinle.",
            dontText = "Sözünü kesme ya da o konuşurken uzaklaşma."
        ),
        "birthday" to ComparisonContent(
            title = "Doğum gününde",
            doText = "Sıranı bekle ve hediyeler için teşekkür et.",
            dontText = "Hediye isteme ya da başkasının önüne geçme."
        ),
        "bus" to ComparisonContent(
            title = "Otobüste",
            doText = "Güvenli şekilde otur ve tutun.",
            dontText = "Koridorda koşma ya da şoförü oyalama."
        ),
        "dining_table" to ComparisonContent(
            title = "Yemek masasında",
            doText = "Ellerini yıka ve ağzın kapalı çiğne.",
            dontText = "Ağzında yemek varken konuşma ya da tabaklarla oynama."
        ),
        "friend_house" to ComparisonContent(
            title = "Arkadaşın evinde",
            doText = "Ev kurallarına uy ve nazik ol.",
            dontText = "İzin almadan eşyalara dokunma."
        ),
        "house" to ComparisonContent(
            title = "Evde",
            doText = "Evi toplamaya yardım et ve sakin konuş.",
            dontText = "Dağınık bırakma ya da kapıları çarpma."
        ),
        "in_the_street" to ComparisonContent(
            title = "Sokakta",
            doText = "Bir yetişkinin elini tut ve iki yana bak.",
            dontText = "Tek başına yola koşma ya da adım atma."
        ),
        "mall" to ComparisonContent(
            title = "Alışveriş merkezinde",
            doText = "Ailene yakın dur.",
            dontText = "Tek başına dolaşma ya da saklanma."
        ),
        "school" to ComparisonContent(
            title = "Okulda",
            doText = "Öğretmeni dinle ve el kaldır.",
            dontText = "Dersi bölme ya da bağırma."
        ),
        "strangers" to ComparisonContent(
            title = "Yabancılarla",
            doText = "Güvendiğin büyüklerin yanında kal ve nazikçe hayır de.",
            dontText = "Tanımadığın biriyle bir yere gitme ya da ondan bir şey alma."
        )
    )

    fun getComparisonItems(context: Context, language: String): List<ComparisonItem> {
        val langKey = when (language) {
            "ar" -> "ar"
            "tr" -> "tr"
            else -> "en"
        }
        val contentByLanguage = when (langKey) {
            "ar" -> arabicContent
            "tr" -> turkishContent
            else -> englishContent
        }

        return supportedIds.mapNotNull { id ->
            val content =
                contentByLanguage[id]
                    ?: englishContent[id]
                    ?: return@mapNotNull null

            val imagePath =
                resolveAssetPath(context, "comparisons/$langKey", "$id.webp")
                    ?: resolveAssetPath(context, "comparisons/en", "$id.webp")
                    ?: return@mapNotNull null

            val audioPath =
                resolveAssetPath(context, "comparisons/$langKey/sound", "$id.mp3")
                    ?: resolveAssetPath(context, "comparisons/en/sound", "$id.mp3")

            val thumbnailPath = resolveThumbnailImage(context, id) ?: imagePath

            val category = when (id) {
                "parents", "brothers", "sisters", "grand_father", "grand_mother" -> ComparisonCategory.FAMILY
                "birthday", "bus", "dining_table", "friend_house", "house", "in_the_street", "mall", "school" -> ComparisonCategory.PLACES
                else -> ComparisonCategory.OTHER
            }

            ComparisonItem(
                id = id,
                title = content.title,
                doText = content.doText,
                dontText = content.dontText,
                imagePath = imagePath,
                audioPath = audioPath,
                category = category,
                thumbnailPath = thumbnailPath
            )
        }
    }

    fun getComparisonGroups(context: Context, language: String): List<ComparisonGroup> {
        val items = getComparisonItems(context, language)
        val langKey = when (language) {
            "ar" -> "ar"
            "tr" -> "tr"
            else -> "en"
        }

        val groups = mutableListOf<ComparisonGroup>()

        // Family group
        val familyItems = items.filter { it.category == ComparisonCategory.FAMILY }
        if (familyItems.isNotEmpty()) {
            val familyImage = resolveAssetPath(context, "comparisons/$langKey", "family.webp")
                ?: resolveAssetPath(context, "comparisons/en", "family.webp")
                ?: familyItems.first().imagePath

            val familyTitle = when (language) {
                "ar" -> "العائلة"
                "tr" -> "Aile"
                else -> "Family"
            }
            groups.add(
                ComparisonGroup(
                    id = "family",
                    title = familyTitle,
                    imagePath = familyImage,
                    category = ComparisonCategory.FAMILY,
                    children = familyItems
                )
            )
        }

        // Places group
        val placesItems = items.filter { it.category == ComparisonCategory.PLACES }
        if (placesItems.isNotEmpty()) {
            val placesImage = resolveAssetPath(context, "comparisons/$langKey", "places.webp")
                ?: resolveAssetPath(context, "comparisons/en", "places.webp")
                ?: placesItems.first().imagePath

            val placesTitle = when (language) {
                "ar" -> "الأماكن"
                "tr" -> "Yerler"
                else -> "Places"
            }
            groups.add(
                ComparisonGroup(
                    id = "places",
                    title = placesTitle,
                    imagePath = placesImage,
                    category = ComparisonCategory.PLACES,
                    children = placesItems
                )
            )
        }

        // Other group
        val otherItems = items.filter { it.category == ComparisonCategory.OTHER }
        if (otherItems.isNotEmpty()) {
            val otherImage = resolveAssetPath(context, "comparisons/$langKey", "other.webp")
                ?: resolveAssetPath(context, "comparisons/en", "other.webp")
                ?: otherItems.first().imagePath

            val otherTitle = when (language) {
                "ar" -> "أخرى"
                "tr" -> "Diğer"
                else -> "Other"
            }
            groups.add(
                ComparisonGroup(
                    id = "other",
                    title = otherTitle,
                    imagePath = otherImage,
                    category = ComparisonCategory.OTHER,
                    children = otherItems
                )
            )
        }

        return groups
    }

    private fun resolveThumbnailImage(
        context: Context,
        id: String
    ): String? {
        return try {
            val files = context.assets.list("comparisons")?.toSet() ?: return null
            val candidates = LinkedHashSet<String>().apply {
                add(id)
                add(id.replace("_", ""))
                if (id.endsWith("s")) {
                    val singular = id.dropLast(1)
                    add(singular)
                    add(singular.replace("_", ""))
                }
            }.filter { it.isNotBlank() }

            val fileCandidates = candidates.flatMap { base ->
                listOf("$base.jpg", "$base.webp")
            }

            val match = fileCandidates.firstOrNull { files.contains(it) } ?: return null
            "comparisons/$match"
        } catch (e: Exception) {
            null
        }
    }

    private fun resolveAssetPath(
        context: Context,
        folder: String,
        fileName: String
    ): String? {
        return try {
            val files = context.assets.list(folder) ?: return null
            if (files.contains(fileName)) {
                "$folder/$fileName"
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}

