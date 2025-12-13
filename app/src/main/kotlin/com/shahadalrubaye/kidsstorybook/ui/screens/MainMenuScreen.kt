package com.shahadalrubaye.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shahadalrubaye.kidsstorybook.models.AgeGroup
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.ui.components.BackgroundImage
import com.shahadalrubaye.kidsstorybook.ui.components.CartoonButton
import com.shahadalrubaye.kidsstorybook.ui.theme.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MainMenuScreen(
    settings: AppSettings,
    onPlayClick: () -> Unit,
    onAnimalsClick: () -> Unit,
    onMorningEveningClick: () -> Unit,
    onComparisonsClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background
        BackgroundImage(
            assetPath = "backgrounds/main_menu.webp",
            modifier = Modifier.matchParentSize()
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title image
            val context = LocalContext.current
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/title.webp")
                    .crossfade(true)
                    .build(),
                contentDescription = "Game Title",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 64.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.weight(1f))

            val isToddler = settings.ageGroup == AgeGroup.AGE_2_4

            if (isToddler) {
                CartoonButton(
                    text = when (settings.language) {
                        "ar" -> "العب"
                        "tr" -> "Oyna"
                        else -> "Play"
                    },
                    onClick = onPlayClick,
                    gradientColors = listOf(GradientYellowStart, GradientOrangeEnd),
                    fontSize = 28,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 12.dp)
                )

                CartoonButton(
                    text = when (settings.language) {
                        "ar" -> "الإعدادات"
                        "tr" -> "Ayarlar"
                        else -> "Settings"
                    },
                    onClick = onSettingsClick,
                    gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                    fontSize = 28,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 12.dp)
                )
            } else {
                CartoonButton(
                    text = when (settings.language) {
                        "ar" -> "الروتين"
                        "tr" -> "Routine"
                        else -> "Routine"
                    },
                    onClick = onMorningEveningClick,
                    gradientColors = listOf(GradientYellowStart, GradientOrangeEnd),
                    fontSize = 24,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 12.dp)
                )

                CartoonButton(
                    text = when (settings.language) {
                        "ar" -> "الحيوانات"
                        "tr" -> "Hayvanlar"
                        else -> "Animals"
                    },
                    onClick = onAnimalsClick,
                    gradientColors = listOf(GradientBlueStart, GradientBlueEnd),
                    fontSize = 24,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 12.dp)
                )

                CartoonButton(
                    text = when (settings.language) {
                        "ar" -> "افعل ولا تفعل"
                        "tr" -> "Yap & Yapma"
                        else -> "Do & Don't"
                    },
                    onClick = onComparisonsClick,
                    gradientColors = listOf(GradientOrangeStart, GradientOrangeEnd),
                    fontSize = 24,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 12.dp)
                )

                CartoonButton(
                    text = when (settings.language) {
                        "ar" -> "الإعدادات"
                        "tr" -> "Ayarlar"
                        else -> "Settings"
                    },
                    onClick = onSettingsClick,
                    gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                    fontSize = 24,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 12.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

