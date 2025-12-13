package com.shahadalrubaye.kidsstorybook.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = BrightOrange,
    onPrimary = TextLight,
    primaryContainer = GradientOrangeStart,
    onPrimaryContainer = TextDark,
    secondary = VibrantPurple,
    onSecondary = TextLight,
    secondaryContainer = GradientPurpleStart,
    onSecondaryContainer = TextDark,
    tertiary = SkyBlue,
    onTertiary = TextLight,
    background = BackgroundLight,
    onBackground = TextDark,
    surface = White,
    onSurface = TextDark,
    surfaceVariant = LightGray,
    onSurfaceVariant = TextDark,
    outline = DisabledGray,
    error = PlayfulPink,
    onError = TextLight
)

@Composable
fun KidsStoryBookTheme(
    @Suppress("UNUSED_PARAMETER") darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Always use light theme for kids - bright and colorful
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = KidsTypography,
        content = content
    )
}

