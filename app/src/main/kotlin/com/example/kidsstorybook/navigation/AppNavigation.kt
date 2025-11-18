package com.example.kidsstorybook.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
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
    object Animals : Screen("animals")
    object DayNightSelection : Screen("day_night_selection")
    object Comparisons : Screen("comparisons")
    object Routine : Screen("routine/{routineType}") {
        fun createRoute(routineType: String) = "routine/$routineType"
    }
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

    val layoutDirection = LayoutDirection.Ltr

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

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
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
                onAnimalsClick = {
                    navController.navigate(Screen.Animals.route)
                },
                onMorningEveningClick = {
                    navController.navigate(Screen.DayNightSelection.route)
                },
                onComparisonsClick = {
                    navController.navigate(Screen.Comparisons.route)
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

        // Animals Screen
        composable(Screen.Animals.route) {
            AnimalsScreen(
                settings = settings,
                onHomeClick = {
                    navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                },
                onSettingsClick = {
                    showSettings = true
                }
            )
        }

        // Day Night Selection Screen
        composable(Screen.DayNightSelection.route) {
            DayNightSelectionScreen(
                settings = settings,
                onMorningClick = {
                    navController.navigate(Screen.Routine.createRoute("morning"))
                },
                onEveningClick = {
                    navController.navigate(Screen.Routine.createRoute("evening"))
                },
                onHomeClick = {
                    navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                },
                onSettingsClick = {
                    showSettings = true
                }
            )
        }

        // Comparisons Screen
        composable(Screen.Comparisons.route) {
            ComparisonsScreen(
                settings = settings,
                onBackClick = {
                    navController.popBackStack()
                },
                onHomeClick = {
                    navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                },
                onSettingsClick = {
                    showSettings = true
                }
            )
        }

        // Routine Screen
        composable(
            route = Screen.Routine.route,
            arguments = listOf(
                navArgument("routineType") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val routineType = backStackEntry.arguments?.getString("routineType") ?: "morning"
            
            RoutineScreen(
                routineType = routineType,
                settings = settings,
                onBackClick = {
                    navController.popBackStack()
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
}



