package com.example.kidsstorybook.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

enum class PinColor(val assetPath: String) {
    BLUE("level_map_buttons/Button Blue/Pin_1.png"),
    ORANGE("level_map_buttons/Button Orange/Pin_1.png"),
    PINK("level_map_buttons/Button Pink/Pin_1.png"),
    VIOLET("level_map_buttons/Button Violet/Pin_1.png"),
    DISABLED("level_map_buttons/Button Disabled/Pin_2.png")
}

@Composable
fun LevelPin(
    levelNumber: Int,
    isUnlocked: Boolean,
    isCompleted: Boolean,
    pinColor: PinColor,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    // Bounce animation on press
    val scale by animateFloatAsState(
        targetValue = if (isPressed && isUnlocked) 0.9f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "pin_scale"
    )

    // Floating animation for unlocked levels
    val infiniteTransition = rememberInfiniteTransition(label = "float_animation")
    val floatOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = if (isUnlocked) 10f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float_offset"
    )

    Box(
        modifier = modifier
            .size(120.dp)
            .offset(y = (-floatOffset).dp)
            .scale(scale)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = isUnlocked,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        // Pin button background
        val pinAsset = if (isUnlocked) pinColor.assetPath else PinColor.DISABLED.assetPath
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/$pinAsset")
                    .crossfade(true)
                    .build()
            ),
            contentDescription = "Level $levelNumber",
            modifier = Modifier.fillMaxSize()
        )

        // Lock icon for locked levels
        if (!isUnlocked) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(context)
                        .data("file:///android_asset/level_map_buttons/Button Disabled/Lock.png")
                        .crossfade(true)
                        .build()
                ),
                contentDescription = "Locked",
                modifier = Modifier
                    .size(48.dp)
                    .offset(y = (-8).dp)
            )
        } else {
            // Level number
            Text(
                text = levelNumber.toString(),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.offset(y = (-8).dp)
            )
        }

        // Stars for completed levels
        if (isCompleted && isUnlocked) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(context)
                        .data("file:///android_asset/level_map_buttons/Button Blue/Stars/Full_stars.png")
                        .crossfade(true)
                        .build()
                ),
                contentDescription = "Completed",
                modifier = Modifier
                    .size(60.dp)
                    .offset(y = 40.dp)
            )
        }
    }
}

