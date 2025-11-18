package com.example.kidsstorybook.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kidsstorybook.models.AgeGroup
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.components.BackgroundImage
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
    var playerName by remember { mutableStateOf(currentSettings.playerName) }
    var isNameError by remember { mutableStateOf(false) }
    val isNameRequired = selectedAgeGroup == AgeGroup.AGE_5_6

    LaunchedEffect(selectedAgeGroup) {
        if (selectedAgeGroup != AgeGroup.AGE_5_6) {
            isNameError = false
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false
        )
    ) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            // Background image from assets
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/settings_menu/menu.png")
                    .crossfade(true)
                    .build(),
                contentDescription = "Settings Menu Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Top bar with navigation buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 26.dp, end = 26.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AssetIconButton(
                        assetPath = "buttons/menu.png",
                        contentDescription = "Back",
                        onClick = onDismiss,
                        size = 48.dp
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AssetIconButton(
                            assetPath = "buttons/home.png",
                            contentDescription = "Home",
                            onClick = onDismiss,
                            size = 48.dp
                        )
                    }
                }

            // Scrollable content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 40.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                // Age Group Section
                Text(
                    text = when (selectedLanguage) {
                        "ar" -> "الفئة العمرية"
                        "tr" -> "Yaş Grubu"
                        else -> "Age Group"
                    },
                    fontSize = 22.sp,
                    fontFamily = FredokaFontFamily,
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

                if (selectedAgeGroup == AgeGroup.AGE_5_6) {
                    Spacer(modifier = Modifier.height(8.dp))

                    val nameLabel = when (selectedLanguage) {
                        "ar" -> "اسم الطفل"
                        "tr" -> "Çocuğun Adı"
                        else -> "Child Name"
                    }
                    val namePlaceholder = when (selectedLanguage) {
                        "ar" -> "أدخل الاسم هنا"
                        "tr" -> "İsmi buraya yazın"
                        else -> "Type the name here"
                    }
                    val nameErrorMessage = when (selectedLanguage) {
                        "ar" -> "الاسم مطلوب لهذه الفئة العمرية"
                        "tr" -> "Bu yaş grubu için isim gerekli"
                        else -> "Name is required for this age group"
                    }

                    Text(
                        text = nameLabel,
                        fontSize = 20.sp,
                        fontFamily = FredokaFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3D0066),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = playerName,
                        onValueChange = {
                            playerName = it.take(30)
                            if (playerName.isNotBlank()) {
                                isNameError = false
                            }
                        },
                        modifier = Modifier.fillMaxWidth(0.9f),
                        placeholder = {
                            Text(text = namePlaceholder)
                        },
                        singleLine = true,
                        isError = isNameError,
                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
                    )

                    if (playerName.isNotBlank()) {
                        Text(
                            text = "${nameLabel}: ${playerName.trim()}",
                            fontSize = 16.sp,
                            fontFamily = FredokaFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF004D66),
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 8.dp)
                        )
                    }

                    if (isNameError) {
                        Text(
                            text = nameErrorMessage,
                            fontSize = 14.sp,
                            color = Color.Red,
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .padding(top = 4.dp)
                        )
                    }

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
                    fontFamily = FredokaFontFamily,
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
                    enabled = !isNameRequired || playerName.isNotBlank(),
                    onClick = {
                        val trimmedName = playerName.trim()
                        if (isNameRequired && trimmedName.isBlank()) {
                            isNameError = true
                            return@SmallCartoonButton
                        }
                        onSettingsChange(
                            AppSettings(
                                language = selectedLanguage,
                                ageGroup = selectedAgeGroup,
                                playerName = trimmedName
                            )
                        )
                        onDismiss()
                    },
                    gradientColors = listOf(Color(0xFF4CAF50), Color(0xFF2E7D32)),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
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
                fontFamily = FredokaFontFamily,
                fontWeight = FontWeight.Bold,
                color = if (selected) Color.White else Color.Gray
            )
            
            Spacer(modifier = Modifier.width(10.dp))
            
            Text(
                text = text,
                fontSize = if (selected) 18.sp else 16.sp,
                fontFamily = FredokaFontFamily,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.SemiBold,
                color = if (selected) TextLight else Color.DarkGray,
                textAlign = TextAlign.Center
            )
        }
    }
}
