package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahadalrubaye.kidsstorybook.models.Animal
import com.shahadalrubaye.kidsstorybook.ui.theme.TextDark

@Composable
fun AnimalCard(
    animal: Animal,
    language: String,
    isLocked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    lockedCtaLabel: String? = null
) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    // Bounce animation
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "animal_card_scale"
    )
    
    // Glass effect colors
    val glassBackground = Color(0xFFFAFAFA).copy(alpha = 0.85f)
    val glassBorder = Color.White.copy(alpha = 0.6f)
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .scale(scale)
            .shadow(
                elevation = if (isPressed) 4.dp else 8.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false
            )
            .clip(RoundedCornerShape(20.dp))
            .background(glassBackground)
            .border(
                width = 1.5.dp,
                color = glassBorder,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 0.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Animal Image
            val saturation = if (isLocked) 0f else 1f
            val colorMatrix = remember(saturation) {
                val matrix = ColorMatrix()
                matrix.setToSaturation(saturation)
                matrix
            }

            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/${animal.imagePath}")
                    .crossfade(true)
                    .build(),
                contentDescription = animal.getDisplayName(language),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.colorMatrix(colorMatrix)
            )
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // Animal Name
            Text(
                text = animal.getDisplayName(language),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (isLocked) TextDark.copy(alpha = 0.4f) else TextDark,
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            if (isLocked) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = lockedCtaLabel ?: "Watch Ad",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF555555),
                    textAlign = TextAlign.Center
                )
            }
        }

        if (isLocked) {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                tint = Color(0xFF555555),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(28.dp)
            )
        }
    }
}

