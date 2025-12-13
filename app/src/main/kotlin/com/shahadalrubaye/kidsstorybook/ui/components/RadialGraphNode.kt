package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun RadialGraphNode(
    imagePath: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Int = 120,
    isExpanded: Boolean = true
) {
    val animatedScale by animateFloatAsState(
        targetValue = if (isExpanded) 1f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "nodeScale"
    )

    Surface(
        shape = CircleShape,
        modifier = modifier
            .size(size.dp)
            .scale(animatedScale)
            .clickable(onClick = onClick),
        shadowElevation = if (isExpanded) 8.dp else 0.dp,
        tonalElevation = if (isExpanded) 4.dp else 0.dp
    ) {
        val context = LocalContext.current
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("file:///android_asset/$imagePath")
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

