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
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

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
            // Title with playful styling
            val title = when (settings.language) {
                "ar" -> "كتاب قصص الأطفال"
                "tr" -> "Çocuk Hikaye Kitabı"
                else -> "Kids Story Book"
            }
            
            // Multiple shadow layers for a cartoony pop effect
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 64.dp),
                contentAlignment = Alignment.Center
            ) {
                // Bottom shadow layer (black)
                Text(
                    text = title,
                    fontSize = if (settings.ageGroup.name == "AGE_3_4") 52.sp else 48.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.offset(y = 6.dp),
                    maxLines = 1
                )
                // Middle shadow layer (dark)
                Text(
                    text = title,
                    fontSize = if (settings.ageGroup.name == "AGE_3_4") 52.sp else 48.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF663300),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.offset(y = 3.dp),
                    maxLines = 1
                )
                // Main text layer (bright yellow)
                Text(
                    text = title,
                    fontSize = if (settings.ageGroup.name == "AGE_3_4") 52.sp else 48.sp,
                    fontWeight = FontWeight.Black,
                    color = SunnyYellow,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        letterSpacing = 1.sp
                    ),
                    maxLines = 1
                )
            }

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

