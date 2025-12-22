package com.shahadalrubaye.kidsstorybook.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahadalrubaye.kidsstorybook.models.AgeGroup
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.ui.components.CompactCartoonOptionButton
import com.shahadalrubaye.kidsstorybook.ui.components.MiniCartoonButton
import com.shahadalrubaye.kidsstorybook.ui.theme.*

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
                    .data("file:///android_asset/settings_menu/menu.webp")
                    .crossfade(true)
                    .build(),
                contentDescription = "Settings Menu Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )


            // Scrollable content - Compact layout
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 70.dp, vertical = 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(95.dp))

                // Age Group Section - Compact header
                Text(
                    text = when (selectedLanguage) {
                        "ar" -> "الفئة العمرية"
                        "tr" -> "Yaş Grubu"
                        else -> "Age Group"
                    },
                    fontSize = 18.sp,
                    fontFamily = FredokaFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF3D0066),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Age options - Horizontal Row (side by side)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
                ) {
                    AgeGroup.values().forEach { ageGroup ->
                        CompactCartoonOptionButton(
                            text = ageGroup.getDisplayName(selectedLanguage),
                            selected = selectedAgeGroup == ageGroup,
                            onClick = { selectedAgeGroup = ageGroup },
                            selectedGradient = listOf(GradientPurpleStart, GradientPurpleEnd),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Name input section - Animated visibility for AGE_5_6
                AnimatedVisibility(
                    visible = selectedAgeGroup == AgeGroup.AGE_5_6,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
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
                            "ar" -> "الاسم مطلوب"
                            "tr" -> "İsim gerekli"
                            else -> "Name required"
                        }

                        // Cartoon styled text input
                        CartoonTextField(
                            value = playerName,
                            onValueChange = {
                                playerName = it.take(30)
                                if (playerName.isNotBlank()) {
                                    isNameError = false
                                }
                            },
                            label = nameLabel,
                            placeholder = namePlaceholder,
                            isError = isNameError,
                            errorMessage = if (isNameError) nameErrorMessage else null,
                            modifier = Modifier.fillMaxWidth(0.95f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Language Section - Compact header
                Text(
                    text = when (selectedLanguage) {
                        "ar" -> "اللغة"
                        "tr" -> "Dil"
                        else -> "Language"
                    },
                    fontSize = 18.sp,
                    fontFamily = FredokaFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF004D66),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Language options - Two rows for compact layout
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
                ) {
                    CompactCartoonOptionButton(
                        text = "🇸🇦 العربية",
                        selected = selectedLanguage == "ar",
                        onClick = { selectedLanguage = "ar" },
                        selectedGradient = listOf(Color(0xFF42A5F5), Color(0xFF1565C0)),
                        modifier = Modifier.weight(1f)
                    )
                    
                    CompactCartoonOptionButton(
                        text = "🇬🇧 English",
                        selected = selectedLanguage == "en",
                        onClick = { selectedLanguage = "en" },
                        selectedGradient = listOf(Color(0xFF42A5F5), Color(0xFF1565C0)),
                        modifier = Modifier.weight(1f)
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                CompactCartoonOptionButton(
                    text = "🇹🇷 Türkçe",
                    selected = selectedLanguage == "tr",
                    onClick = { selectedLanguage = "tr" },
                    selectedGradient = listOf(Color(0xFF42A5F5), Color(0xFF1565C0)),
                    modifier = Modifier.fillMaxWidth(0.5f)
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Apply button - Compact green CTA
                MiniCartoonButton(
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
                            return@MiniCartoonButton
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
                    gradientColors = listOf(Color(0xFF66BB6A), Color(0xFF388E3C)),
                    modifier = Modifier.fillMaxWidth(0.6f)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

/**
 * Cartoon styled text field that matches the app's playful aesthetic
 */
@Composable
private fun CartoonTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column(modifier = modifier) {
        // Label
        Text(
            text = label,
            fontSize = 14.sp,
            fontFamily = FredokaFontFamily,
            fontWeight = FontWeight.Bold,
            color = if (isError) Color(0xFFD32F2F) else Color(0xFF3D0066),
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
        )
        
        // Cartoon styled input box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(14.dp),
                    clip = false
                )
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.verticalGradient(
                        if (isError) {
                            listOf(Color(0xFFFFEBEE), Color(0xFFFFCDD2))
                        } else {
                            listOf(Color(0xFFFFFDE7), Color(0xFFFFF9C4))
                        }
                    )
                )
                .border(
                    width = 2.dp,
                    color = if (isError) Color(0xFFEF5350) else Color(0xFFFFB74D),
                    shape = RoundedCornerShape(14.dp)
                )
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FredokaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF3D0066)
                ),
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                cursorBrush = SolidColor(Color(0xFF7B1FA2)),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontSize = 14.sp,
                            fontFamily = FredokaFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF9E9E9E)
                        )
                    }
                    innerTextField()
                }
            )
        }
        
        // Error message
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                fontSize = 11.sp,
                fontFamily = FredokaFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD32F2F),
                modifier = Modifier.padding(start = 8.dp, top = 2.dp)
            )
        }
        
        // Show entered name preview
        if (value.isNotBlank() && !isError) {
            Text(
                text = "✨ ${value.trim()}",
                fontSize = 12.sp,
                fontFamily = FredokaFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4CAF50),
                modifier = Modifier.padding(start = 8.dp, top = 3.dp)
            )
        }
    }
}

