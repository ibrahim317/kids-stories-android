package com.example.kidsstorybook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.kidsstorybook.models.AgeGroup
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.components.SmallCartoonButton
import com.example.kidsstorybook.ui.theme.*

@Composable
fun SettingsDialog(
    currentSettings: AppSettings,
    onDismiss: () -> Unit,
    onSettingsChange: (AppSettings) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedLanguage by remember { mutableStateOf(currentSettings.language) }
    var selectedAgeGroup by remember { mutableStateOf(currentSettings.ageGroup) }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .shadow(16.dp, RoundedCornerShape(32.dp))
                .clip(RoundedCornerShape(32.dp))
                .background(White)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header with close button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when (currentSettings.language) {
                            "ar" -> "الإعدادات"
                            "tr" -> "Ayarlar"
                            else -> "Settings"
                        },
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )

                    AssetIconButton(
                        assetPath = "buttons/settings.png",
                        contentDescription = "Close",
                        onClick = onDismiss,
                        size = 40.dp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Age Group Section
                Text(
                    text = when (currentSettings.language) {
                        "ar" -> "الفئة العمرية"
                        "tr" -> "Yaş Grubu"
                        else -> "Age Group"
                    },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Age options
                AgeGroup.values().forEach { ageGroup ->
                    AgeOptionItem(
                        text = ageGroup.getDisplayName(selectedLanguage),
                        selected = selectedAgeGroup == ageGroup,
                        onClick = { selectedAgeGroup = ageGroup }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Language Section
                Text(
                    text = when (currentSettings.language) {
                        "ar" -> "اللغة"
                        "tr" -> "Dil"
                        else -> "Language"
                    },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Language options
                LanguageOptionItem(
                    text = "اللغة العربية",
                    selected = selectedLanguage == "ar",
                    onClick = { selectedLanguage = "ar" }
                )
                Spacer(modifier = Modifier.height(8.dp))

                LanguageOptionItem(
                    text = "English",
                    selected = selectedLanguage == "en",
                    onClick = { selectedLanguage = "en" }
                )
                Spacer(modifier = Modifier.height(8.dp))

                LanguageOptionItem(
                    text = "Türkçe",
                    selected = selectedLanguage == "tr",
                    onClick = { selectedLanguage = "tr" }
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Apply button
                SmallCartoonButton(
                    text = when (selectedLanguage) {
                        "ar" -> "تطبيق"
                        "tr" -> "Uygula"
                        else -> "Apply"
                    },
                    onClick = {
                        onSettingsChange(AppSettings(selectedLanguage, selectedAgeGroup))
                        onDismiss()
                    },
                    gradientColors = listOf(GradientBlueStart, GradientBlueEnd),
                    modifier = Modifier.fillMaxWidth(0.6f)
                )
            }
        }
    }
}

@Composable
private fun AgeOptionItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) GradientYellowStart else LightGray)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = BrightOrange,
                unselectedColor = DisabledGray
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            color = TextDark
        )
    }
}

@Composable
private fun LanguageOptionItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) GradientPurpleStart else LightGray)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = VibrantPurple,
                unselectedColor = DisabledGray
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            color = TextDark
        )
    }
}

