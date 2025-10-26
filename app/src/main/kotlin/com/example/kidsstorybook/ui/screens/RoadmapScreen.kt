package com.example.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kidsstorybook.data.StoryRepository
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.GameProgress
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.components.BackgroundImage
import com.example.kidsstorybook.ui.components.LevelPin
import com.example.kidsstorybook.ui.components.PinColor

@Composable
fun RoadmapScreen(
    @Suppress("UNUSED_PARAMETER") settings: AppSettings,
    progress: GameProgress,
    onLevelClick: (Int) -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background
        BackgroundImage(assetPath = "backgrounds/roadmap.png")

        // Top bar with home and settings buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
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

        // Level pins - positioned in a path layout
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                val totalLevels = StoryRepository.getTotalLevels()
                val pinColors = listOf(PinColor.BLUE, PinColor.ORANGE, PinColor.PINK, PinColor.VIOLET)

                // Reverse order: highest level at top, level 1 at bottom
                for (level in totalLevels downTo 1) {
                    val isUnlocked = progress.isLevelUnlocked(level)
                    val isCompleted = progress.isLevelCompleted(level)
                    val pinColor = pinColors[(level - 1) % pinColors.size]

                    // Alternate left and right positioning for a path-like layout
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (level % 2 == 0) Arrangement.Start else Arrangement.End
                    ) {
                        LevelPin(
                            levelNumber = level,
                            isUnlocked = isUnlocked,
                            isCompleted = isCompleted,
                            pinColor = pinColor,
                            onClick = { 
                                if (isUnlocked) {
                                    onLevelClick(level)
                                }
                            },
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

