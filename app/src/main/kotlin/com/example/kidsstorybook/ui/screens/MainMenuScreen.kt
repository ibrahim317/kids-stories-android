package com.example.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.ui.components.BackgroundImage
import com.example.kidsstorybook.ui.components.CartoonButton
import com.example.kidsstorybook.ui.theme.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MainMenuScreen(
    settings: AppSettings,
    onPlayClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background
        BackgroundImage(assetPath = "backgrounds/main_menu.png")

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
                    .data("file:///android_asset/title.png")
                    .crossfade(true)
                    .build(),
                contentDescription = "Game Title",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 64.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.weight(1f))

            // Play Button
            CartoonButton(
                text = when (settings.language) {
                    "ar" -> "العب"
                    "tr" -> "Oyna"
                    else -> "Play"
                },
                onClick = onPlayClick,
                gradientColors = listOf(GradientYellowStart, GradientOrangeEnd),
                fontSize = if (settings.ageGroup.name == "AGE_3_4") 28 else 24,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 12.dp)
            )

            // Settings Button
            CartoonButton(
                text = when (settings.language) {
                    "ar" -> "الإعدادات"
                    "tr" -> "Ayarlar"
                    else -> "Settings"
                },
                onClick = onSettingsClick,
                gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                fontSize = if (settings.ageGroup.name == "AGE_3_4") 28 else 24,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 12.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

