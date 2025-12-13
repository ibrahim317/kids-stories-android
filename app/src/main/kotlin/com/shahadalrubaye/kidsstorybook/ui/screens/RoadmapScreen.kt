package com.shahadalrubaye.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.shahadalrubaye.kidsstorybook.data.StoryRepository
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.models.GameProgress
import com.shahadalrubaye.kidsstorybook.ui.components.AssetIconButton
import com.shahadalrubaye.kidsstorybook.ui.components.BackgroundImage
import com.shahadalrubaye.kidsstorybook.ui.components.LevelPin
import com.shahadalrubaye.kidsstorybook.ui.components.PinColor

@Composable
fun RoadmapScreen(
    settings: AppSettings,
    progress: GameProgress,
    adUnlockedLevels: Set<Int>,
    adLockedLevels: Set<Int>,
    onLevelClick: (Int) -> Unit,
    onLockedLevelClick: (Int) -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val totalLevels = StoryRepository.getTotalLevels()
    val levelsPerSection = 5
    
    // Map roadmaps to their specific pin colors
    val roadmapConfigs = listOf(
        Triple("backgrounds/roadmap1.webp", PinColor.BLUE, 1),
        Triple("backgrounds/roadmap2.webp", PinColor.PINK, 2),
        Triple("backgrounds/roadmap3.webp", PinColor.VIOLET, 3)
    )
    
    val sectionsAscending = remember(totalLevels) {
        roadmapConfigs.mapIndexed { index, (asset, color, _) ->
            val startLevel = index * levelsPerSection + 1
            val endLevel = minOf(totalLevels, startLevel + levelsPerSection - 1)
            Triple(asset, (startLevel..endLevel).toList(), color)
        }.filter { it.second.isNotEmpty() }
    }
    val sectionsForDisplay = remember(sectionsAscending) { sectionsAscending.reversed() }

    val watchAdLabel = remember(settings.language) {
        when (settings.language) {
            "ar" -> "شاهد إعلان"
            "tr" -> "Reklam İzle"
            else -> "Watch Ad"
        }
    }
    
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
                    adUnlockedLevels = adUnlockedLevels,
                    adLockedLevels = adLockedLevels,
                    lockedCtaLabel = watchAdLabel,
                    roadmapColor = roadmapColor,
                    onLevelClick = onLevelClick,
                    onLockedLevelClick = onLockedLevelClick
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AssetIconButton(
                assetPath = "buttons/home.webp",
                contentDescription = "Home",
                onClick = onHomeClick,
                size = 40.dp
            )

            AssetIconButton(
                assetPath = "buttons/settings.webp",
                contentDescription = "Settings",
                onClick = onSettingsClick,
                size = 40.dp
            )
        }
    }
}

@Composable
private fun RoadmapSection(
    backgroundAsset: String,
    levels: List<Int>,
    progress: GameProgress,
    adUnlockedLevels: Set<Int>,
    adLockedLevels: Set<Int>,
    lockedCtaLabel: String,
    roadmapColor: PinColor,
    onLevelClick: (Int) -> Unit,
    onLockedLevelClick: (Int) -> Unit
) {
    if (levels.isEmpty()) return

    // Calculate height based on content: each level takes 140dp + 60dp top + 30dp bottom padding
    val sectionHeight = remember(levels.size) {
        (levels.size * 140).dp + 90.dp
    }

    Box(
        modifier = Modifier
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
                val baseUnlocked = progress.isLevelUnlocked(level)
                val requiresAdUnlock = adLockedLevels.contains(level)
                val hasAdUnlock = adUnlockedLevels.contains(level)
                val isUnlocked = baseUnlocked && (!requiresAdUnlock || hasAdUnlock)
                val shouldPromptForAd = baseUnlocked && requiresAdUnlock && !hasAdUnlock
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
                            onLockedClick = if (shouldPromptForAd) {
                                { onLockedLevelClick(level) }
                            } else {
                                null
                            },
                            lockedCtaLabel = if (shouldPromptForAd) lockedCtaLabel else null,
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
