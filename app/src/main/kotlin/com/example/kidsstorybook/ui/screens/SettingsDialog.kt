package com.example.kidsstorybook.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
    val context = LocalContext.current
    var selectedLanguage by remember { mutableStateOf(currentSettings.language) }
    var selectedAgeGroup by remember { mutableStateOf(currentSettings.ageGroup) }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = modifier
                .size(800.dp)
        ) {
            // Background image from assets
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/settings_menu/menu.png")
                    .crossfade(true)
                    .build(),
                contentDescription = "Settings Menu Background",
                modifier = Modifier
                    .size(800.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            // Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(6.dp))

                // Title image from assets
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data("file:///android_asset/settings_menu/title.png")
                        .crossfade(true)
                        .build(),
                    contentDescription = "Settings Title",
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .zIndex(1f),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Age Group Section
                Text(
                    text = when (selectedLanguage) {
                        "ar" -> "الفئة العمرية"
                        "tr" -> "Yaş Grubu"
                        else -> "Age Group"
                    },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF3D0066),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Age options - Vertical Stack
                AgeGroup.values().forEach { ageGroup ->
                    KidsFriendlyOptionButton(
                        text = ageGroup.getDisplayName(selectedLanguage),
                        selected = selectedAgeGroup == ageGroup,
                        onClick = { selectedAgeGroup = ageGroup },
                        gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Language Section
                Text(
                    text = when (selectedLanguage) {
                        "ar" -> "اللغة"
                        "tr" -> "Dil"
                        else -> "Language"
                    },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF004D66),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Language options - Vertical Stack
                KidsFriendlyOptionButton(
                    text = "🇸🇦 العربية",
                    selected = selectedLanguage == "ar",
                    onClick = { selectedLanguage = "ar" },
                    gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
                Spacer(modifier = Modifier.height(12.dp))
                
                KidsFriendlyOptionButton(
                    text = "🇬🇧 English",
                    selected = selectedLanguage == "en",
                    onClick = { selectedLanguage = "en" },
                    gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
                Spacer(modifier = Modifier.height(12.dp))
                
                KidsFriendlyOptionButton(
                    text = "🇹🇷 Türkçe",
                    selected = selectedLanguage == "tr",
                    onClick = { selectedLanguage = "tr" },
                    gradientColors = listOf(GradientPurpleStart, GradientPurpleEnd),
                    modifier = Modifier.fillMaxWidth(0.9f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Apply button - Green for clear CTA
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
                    gradientColors = listOf(Color(0xFF4CAF50), Color(0xFF2E7D32)),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Close button
                AssetIconButton(
                    assetPath = "buttons/home.png",
                    contentDescription = "Close",
                    onClick = onDismiss,
                    size = 48.dp,
                    modifier = Modifier.zIndex(2f)
                )
                
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}

@Composable
private fun KidsFriendlyOptionButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    gradientColors: List<Color>,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "option_scale"
    )

    Box(
        modifier = modifier
            .heightIn(min = 48.dp)
            .scale(scale)
            .shadow(
                elevation = if (selected) 12.dp else 4.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false,
                spotColor = if (selected) Color(0x80FFD700) else Color.Black.copy(alpha = 0.25f)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = if (selected) {
                    Brush.verticalGradient(gradientColors)
                } else {
                    Brush.verticalGradient(listOf(LightGray, Color(0xFFE0E0E0)))
                }
            )
            .then(
                if (selected) {
                    Modifier.border(
                        width = 2.dp,
                        color = Color(0x80FFFFFF),
                        shape = RoundedCornerShape(20.dp)
                    )
                } else {
                    Modifier
                }
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Check mark emoji or circle for selection
            Text(
                text = if (selected) "✓" else "○",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if (selected) Color.White else Color.Gray
            )
            
            Spacer(modifier = Modifier.width(10.dp))
            
            Text(
                text = text,
                fontSize = if (selected) 18.sp else 16.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.SemiBold,
                color = if (selected) TextLight else Color.DarkGray,
                textAlign = TextAlign.Center
            )
        }
    }
}
