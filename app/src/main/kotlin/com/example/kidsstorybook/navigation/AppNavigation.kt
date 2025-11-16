package com.example.kidsstorybook.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kidsstorybook.data.PreferencesManager
import com.example.kidsstorybook.data.StoryRepository
import com.example.kidsstorybook.models.GameProgress
import com.example.kidsstorybook.ui.screens.*

sealed class Screen(val route: String) {
    object MainMenu : Screen("main_menu")
    object Roadmap : Screen("roadmap")
    object Level : Screen("level/{levelNumber}") {
        fun createRoute(levelNumber: Int) = "level/$levelNumber"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val totalLevels = remember { StoryRepository.getTotalLevels() }

    // App state
    var settings by remember { mutableStateOf(preferencesManager.getSettings()) }
    var progress by remember {
        mutableStateOf(preferencesManager.getProgress().clamp(totalLevels))
    }
    var showSettings by remember { mutableStateOf(false) }

    // Settings dialog
    if (showSettings) {
        SettingsDialog(
            currentSettings = settings,
            onDismiss = { showSettings = false },
            onSettingsChange = { newSettings ->
                settings = newSettings
                preferencesManager.saveSettings(newSettings)
            }
        )
    }

    NavHost(
        navController = navController,
        startDestination = Screen.MainMenu.route
    ) {
        // Main Menu Screen
        composable(Screen.MainMenu.route) {
            MainMenuScreen(
                settings = settings,
                onPlayClick = {
                    navController.navigate(Screen.Roadmap.route)
                },
                onSettingsClick = {
                    showSettings = true
                }
            )
        }

        // Roadmap Screen
        composable(Screen.Roadmap.route) {
            RoadmapScreen(
                settings = settings,
                progress = progress,
                onLevelClick = { level ->
                    navController.navigate(Screen.Level.createRoute(level))
                },
                onHomeClick = {
                    navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                },
                onSettingsClick = {
                    showSettings = true
                }
            )
        }

        // Level Screen
        composable(
            route = Screen.Level.route,
            arguments = listOf(
                navArgument("levelNumber") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val levelNumber = backStackEntry.arguments?.getInt("levelNumber") ?: 1
            val story = StoryRepository.getStoryForLevel(levelNumber)

            if (story != null) {
                LevelScreen(
                    story = story,
                    level = levelNumber,
                    settings = settings,
                    onLevelComplete = {
                        // Update progress with full completion
                        val newProgress = progress.withLevelStars(
                            level = levelNumber,
                            starsEarned = GameProgress.MAX_STARS,
                            totalLevels = totalLevels
                        )
                        if (newProgress != progress) {
                            progress = newProgress
                            preferencesManager.saveProgress(newProgress)
                        }

                        // Navigate back to roadmap
                        navController.popBackStack()
                    },
                    onRoadmapClick = {
                        navController.popBackStack()
                    },
                    onHomeClick = {
                        navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                    },
                    onSettingsClick = {
                        showSettings = true
                    },
                    onProgressUpdate = { level, stars ->
                        val updatedProgress = progress.withLevelStars(
                            level = level,
                            starsEarned = stars,
                            totalLevels = totalLevels
                        )
                        if (updatedProgress != progress) {
                            progress = updatedProgress
                            preferencesManager.saveProgress(updatedProgress)
                        }
                    }
                )
            } else {
                // Story not found - go back to roadmap
                LaunchedEffect(Unit) {
                    navController.popBackStack()
                }
            }
        }
    }
}



