package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahadalrubaye.kidsstorybook.ui.theme.*

@Composable
fun CartoonButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(GradientYellowStart, GradientYellowEnd),
    fontSize: Int = 24,
    height: Dp = 80.dp,
    enabled: Boolean = true,
    borderColor: Color? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    // Bounce animation
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "button_scale"
    )

    Box(
        modifier = modifier
            .height(height)
            .scale(scale)
            .shadow(
                elevation = if (isPressed) 4.dp else 8.dp,
                shape = RoundedCornerShape(28.dp),
                clip = false
            )
            .clip(RoundedCornerShape(28.dp))
            .background(
                brush = if (enabled) {
                    Brush.verticalGradient(gradientColors)
                } else {
                    Brush.verticalGradient(listOf(DisabledGray, DisabledGray))
                }
            )
            .then(
                if (borderColor != null) {
                    Modifier.border(2.dp, borderColor, RoundedCornerShape(28.dp))
                } else {
                    Modifier
                }
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
            .padding(horizontal = 32.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            color = if (enabled) TextLight else Color.Gray,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun SmallCartoonButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(GradientBlueStart, GradientBlueEnd),
    enabled: Boolean = true,
    borderColor: Color? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "small_button_scale"
    )

    Box(
        modifier = modifier
            .height(56.dp)
            .scale(scale)
            .shadow(
                elevation = if (isPressed) 3.dp else 6.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false
            )
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = if (enabled) {
                    Brush.verticalGradient(gradientColors)
                } else {
                    Brush.verticalGradient(listOf(DisabledGray, DisabledGray))
                }
            )
            .then(
                if (borderColor != null) {
                    Modifier.border(2.dp, borderColor, RoundedCornerShape(20.dp))
                } else {
                    Modifier
                }
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
            .padding(horizontal = 24.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = if (enabled) TextLight else Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Compact cartoon button variant - perfect for settings grids and smaller UI elements
 */
@Composable
fun CompactCartoonOptionButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedGradient: List<Color> = listOf(GradientPurpleStart, GradientPurpleEnd),
    unselectedGradient: List<Color> = listOf(Color(0xFFF5F5F5), Color(0xFFE8E8E8))
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.92f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "compact_option_scale"
    )

    Box(
        modifier = modifier
            .heightIn(min = 38.dp)
            .scale(scale)
            .shadow(
                elevation = if (selected) 6.dp else 2.dp,
                shape = RoundedCornerShape(14.dp),
                clip = false,
                spotColor = if (selected) Color(0x60FFD700) else Color.Black.copy(alpha = 0.15f)
            )
            .clip(RoundedCornerShape(14.dp))
            .background(
                brush = if (selected) {
                    Brush.verticalGradient(selectedGradient)
                } else {
                    Brush.verticalGradient(unselectedGradient)
                }
            )
            .then(
                if (selected) {
                    Modifier.border(
                        width = 2.dp,
                        brush = Brush.verticalGradient(
                            listOf(Color.White.copy(alpha = 0.7f), Color.White.copy(alpha = 0.3f))
                        ),
                        shape = RoundedCornerShape(14.dp)
                    )
                } else {
                    Modifier.border(
                        width = 1.dp,
                        color = Color(0x30000000),
                        shape = RoundedCornerShape(14.dp)
                    )
                }
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Compact check indicator
            Text(
                text = if (selected) "✓" else "○",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = if (selected) Color.White else Color.Gray
            )
            
            Spacer(modifier = Modifier.width(6.dp))
            
            Text(
                text = text,
                fontSize = if (selected) 14.sp else 13.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.SemiBold,
                color = if (selected) Color.White else Color(0xFF555555),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}

/**
 * Mini cartoon action button for compact layouts
 */
@Composable
fun MiniCartoonButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(GradientBlueStart, GradientBlueEnd),
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.93f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "mini_button_scale"
    )

    Box(
        modifier = modifier
            .height(44.dp)
            .scale(scale)
            .shadow(
                elevation = if (isPressed) 2.dp else 4.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = if (enabled) {
                    Brush.verticalGradient(gradientColors)
                } else {
                    Brush.verticalGradient(listOf(DisabledGray, DisabledGray))
                }
            )
            .border(
                width = 2.dp,
                brush = Brush.verticalGradient(
                    listOf(Color.White.copy(alpha = 0.5f), Color.White.copy(alpha = 0.2f))
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
            .padding(horizontal = 20.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = if (enabled) TextLight else Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}
