package com.example.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.components.BackgroundImage
import com.example.kidsstorybook.ui.components.CartoonButton
import com.example.kidsstorybook.ui.theme.*

@Composable
fun DayNightSelectionScreen(
    settings: AppSettings,
    onMorningClick: () -> Unit,
    onEveningClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background with day and night split
        BackgroundImage(
            assetPath = "backgrounds/day_and_night2.png",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AssetIconButton(
                    assetPath = "buttons/home.png",
                    contentDescription = "Home",
                    onClick = onHomeClick,
                    size = 48.dp
                )

                Spacer(modifier = Modifier.weight(1f))

                AssetIconButton(
                    assetPath = "buttons/settings.png",
                    contentDescription = "Settings",
                    onClick = onSettingsClick,
                    size = 48.dp
                )
            }

            // Content area with buttons positioned next to sun and moon
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                // Morning button - positioned on the right side of the sun (top half)
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 120.dp, end = 32.dp)
                ) {
                    CartoonButton(
                        text = when (settings.language) {
                            "ar" -> "الصباح"
                            "tr" -> "Sabah"
                            else -> "Morning"
                        },
                        onClick = onMorningClick,
                        gradientColors = listOf(GradientYellowStart, GradientOrangeEnd),
                        fontSize = if (settings.ageGroup.name == "AGE_2_4") 28 else 24,
                        modifier = Modifier.width(200.dp)
                    )
                }

                // Evening button - positioned on the right side of the moon (bottom half)
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 120.dp, end = 32.dp)
                ) {
                    CartoonButton(
                        text = when (settings.language) {
                            "ar" -> "المساء"
                            "tr" -> "Akşam"
                            else -> "Evening"
                        },
                        onClick = onEveningClick,
                        gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                        fontSize = if (settings.ageGroup.name == "AGE_2_4") 28 else 24,
                        modifier = Modifier.width(200.dp)
                    )
                }
            }
        }
    }
}

