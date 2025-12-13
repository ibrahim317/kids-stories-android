package com.shahadalrubaye.kidsstorybook.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.shahadalrubaye.kidsstorybook.R

/**
 * Kid-Friendly Typography with Multi-Language Support
 * 
 * Primary Font: Fredoka - Super playful, rounded, and perfect for kids
 * Fallback Font: Nunito - Alternative rounded font with good Latin support
 * System Fallback: For scripts not covered (Arabic, CJK, Thai, etc.)
 * 
 * Key Features:
 * - Large, readable sizes suitable for young children
 * - Playful, rounded letterforms (Fredoka)
 * - Proper line heights (1.4-1.5x ratio) for comfortable reading
 * - includeFontPadding = false for consistent cross-language rendering
 * - Centered line height alignment for better multi-script support
 */

// Fredoka Font Family - Primary playful font for kids (Variable Font)
// Using heavier weights for better visibility and kid-friendly chunky look
val FredokaFontFamily = FontFamily(
    Font(R.font.fredoka_variable, FontWeight.Medium),      // Was Normal, now Medium (500)
    Font(R.font.fredoka_variable, FontWeight.SemiBold),    // Was Medium, now SemiBold (600)
    Font(R.font.fredoka_variable, FontWeight.Bold),        // Was SemiBold, now Bold (700)
    Font(R.font.fredoka_variable, FontWeight.ExtraBold)    // Was Bold, now ExtraBold (800)
)

// Platform text style for better cross-platform and multi-language support
private val platformStyle = PlatformTextStyle(
    includeFontPadding = false  // Critical for consistent rendering across languages
)

// Line height style for proper text alignment
private val lineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

// Typography with large, clear, PLAYFUL fonts perfect for kids
val KidsTypography = Typography(
    // Display styles - For titles and big, attention-grabbing text
    displayLarge = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 67.sp,  // 1.4x ratio for comfortable reading
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    displayMedium = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 56.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    displaySmall = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 45.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    
    // Headline styles - For section headers and important text
    headlineLarge = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 39.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    headlineMedium = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 34.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    headlineSmall = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 31.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    
    // Title styles - For card titles and medium emphasis text
    titleLarge = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 28.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    titleMedium = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 25.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    titleSmall = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 22.sp,  // 1.4x ratio
        letterSpacing = 0.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    
    // Body styles - For main content and reading text
    bodyLarge = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Medium,  // Heavier for better visibility
        fontSize = 18.sp,
        lineHeight = 27.sp,  // 1.5x ratio for body text (better readability)
        letterSpacing = 0.2.sp,  // Slight letter spacing for readability
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    bodyMedium = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Medium,  // Heavier for better visibility
        fontSize = 16.sp,
        lineHeight = 24.sp,  // 1.5x ratio
        letterSpacing = 0.2.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    bodySmall = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Medium,  // Heavier for better visibility
        fontSize = 14.sp,
        lineHeight = 21.sp,  // 1.5x ratio
        letterSpacing = 0.2.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    
    // Label styles - For buttons and UI labels
    labelLarge = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 22.sp,  // 1.4x ratio
        letterSpacing = 0.1.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    labelMedium = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,  // 1.4x ratio
        letterSpacing = 0.1.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    ),
    labelSmall = TextStyle(
        fontFamily = FredokaFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 17.sp,  // 1.4x ratio
        letterSpacing = 0.1.sp,
        platformStyle = platformStyle,
        lineHeightStyle = lineHeightStyle
    )
)
