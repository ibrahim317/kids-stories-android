package com.example.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.kidsstorybook.data.StoryRepository
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.GameProgress
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.components.BackgroundImage
import com.example.kidsstorybook.ui.components.LevelPin
import com.example.kidsstorybook.ui.components.PinColor
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color

@Composable
fun RoadmapScreen(
    @Suppress("UNUSED_PARAMETER") settings: AppSettings,
    progress: GameProgress,
    onLevelClick: (Int) -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val totalLevels = StoryRepository.getTotalLevels()
    val levelsPerSection = 5
    
    // Map roadmaps to their specific pin colors
    val roadmapConfigs = listOf(
        Triple("backgrounds/roadmap1.png", PinColor.BLUE, 1),
        Triple("backgrounds/roadmap2.png", PinColor.PINK, 2),
        Triple("backgrounds/roadmap3.png", PinColor.VIOLET, 3)
    )
    
    val sectionsAscending = remember(totalLevels) {
        roadmapConfigs.mapIndexed { index, (asset, color, _) ->
            val startLevel = index * levelsPerSection + 1
            val endLevel = minOf(totalLevels, startLevel + levelsPerSection - 1)
            Triple(asset, (startLevel..endLevel).toList(), color)
        }.filter { it.second.isNotEmpty() }
    }
    val sectionsForDisplay = remember(sectionsAscending) { sectionsAscending.reversed() }
    
    val scrollState = rememberScrollState()
    
    // Scroll to bottom once scrollState.maxValue is available
    LaunchedEffect(Unit) {
        // Wait for maxValue to be calculated - poll until it's ready
        var attempts = 0
        while (attempts < 100) {
            val currentMax = scrollState.maxValue
            if (currentMax > 0) {
                // Small delay to ensure everything is stable
                delay(50)
                scrollState.animateScrollTo(currentMax)
                break
            }
            delay(16) // ~1 frame at 60fps
            attempts++
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            sectionsForDisplay.forEach { (backgroundAsset, levels, roadmapColor) ->
                RoadmapSection(
                    backgroundAsset = backgroundAsset,
                    levels = levels,
                    progress = progress,
                    roadmapColor = roadmapColor,
                    onLevelClick = onLevelClick
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AssetIconButton(
                assetPath = "buttons/home.png",
                contentDescription = "Home",
                onClick = onHomeClick,
                size = 56.dp
            )

            AssetIconButton(
                assetPath = "buttons/settings.png",
                contentDescription = "Settings",
                onClick = onSettingsClick,
                size = 56.dp
            )
        }
    }
}

@Composable
private fun RoadmapSection(
    backgroundAsset: String,
    levels: List<Int>,
    progress: GameProgress,
    roadmapColor: PinColor,
    onLevelClick: (Int) -> Unit
) {
    if (levels.isEmpty()) return

    // Calculate height based on content: each level takes 140dp + 60dp top + 30dp bottom padding
    val sectionHeight = remember(levels.size) {
        (levels.size * 140).dp + 90.dp
    }

    Box(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth()
            .height(sectionHeight)
    ) {
        BackgroundImage(
            assetPath = backgroundAsset,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .padding(top = 60.dp, bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            levels.sortedDescending().forEach { level ->
                val isUnlocked = progress.isLevelUnlocked(level)
                val isCompleted = progress.isLevelCompleted(level)
                val stars = progress.getStarsForLevel(level)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        horizontalArrangement = if (level % 2 == 0) Arrangement.Start else Arrangement.End
                    ) {
                        LevelPin(
                            levelNumber = level,
                            isUnlocked = isUnlocked,
                            isCompleted = isCompleted,
                            pinColor = roadmapColor,
                            stars = stars,
                            onClick = { onLevelClick(level) },
                            modifier = Modifier.padding(
                                start = if (level % 2 == 0) 32.dp else 0.dp,
                                end = if (level % 2 == 1) 32.dp else 0.dp
                            )
                        )
                    }
                }
            }
        }
    }
}
