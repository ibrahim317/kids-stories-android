package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.*

@Composable
fun RadialGraphLayout(
    centerNode: @Composable (modifier: Modifier) -> Unit,
    childNodes: List<@Composable (modifier: Modifier) -> Unit>,
    isExpanded: Boolean = false,
    radius: Dp = 180.dp,
    modifier: Modifier = Modifier
) {
    var containerSize by remember { mutableStateOf(Offset.Zero) }
    val density = LocalDensity.current
    
    val centerX = if (containerSize.x > 0) containerSize.x / 2 else 0f
    val centerY = if (containerSize.y > 0) containerSize.y / 2 else 0f
    val radiusPx = with(density) { radius.toPx() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                containerSize = Offset(
                    coordinates.size.width.toFloat(),
                    coordinates.size.height.toFloat()
                )
            },
        contentAlignment = Alignment.Center
    ) {
        // Draw connections
        if (isExpanded && containerSize != Offset.Zero && childNodes.isNotEmpty()) {
            val animatedAlpha by animateFloatAsState(
                targetValue = if (isExpanded) 1f else 0f,
                animationSpec = tween(durationMillis = 300),
                label = "connectionAlpha"
            )
            
            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {
                childNodes.forEachIndexed { index, _ ->
                    val angle = (2 * PI * index) / childNodes.size - PI / 2 // Start from top
                    val childX = centerX + radiusPx * cos(angle).toFloat()
                    val childY = centerY + radiusPx * sin(angle).toFloat()
                    
                    drawLine(
                        color = Color(0x80000000).copy(alpha = animatedAlpha),
                        start = Offset(centerX, centerY),
                        end = Offset(childX, childY),
                        strokeWidth = 3.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                }
            }
        }

        // Center node
        centerNode(
            Modifier.align(Alignment.Center)
        )

        // Child nodes
        if (isExpanded && containerSize != Offset.Zero && childNodes.isNotEmpty()) {
            childNodes.forEachIndexed { index, node ->
                val angle = (2 * PI * index) / childNodes.size - PI / 2 // Start from top
                val childX = centerX + radiusPx * cos(angle).toFloat()
                val childY = centerY + radiusPx * sin(angle).toFloat()
                
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(
                            x = with(density) { (childX - centerX).toDp() - 60.dp },
                            y = with(density) { (childY - centerY).toDp() - 60.dp }
                        )
                ) {
                    node(Modifier)
                }
            }
        }
    }
}

