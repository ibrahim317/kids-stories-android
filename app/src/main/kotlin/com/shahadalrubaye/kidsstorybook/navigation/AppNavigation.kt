package com.shahadalrubaye.kidsstorybook.navigation

import android.app.Activity
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shahadalrubaye.kidsstorybook.data.AnimalRepository
import com.shahadalrubaye.kidsstorybook.data.ComparisonRepository
import com.shahadalrubaye.kidsstorybook.data.PreferencesManager
import com.shahadalrubaye.kidsstorybook.data.StoryRepository
import com.shahadalrubaye.kidsstorybook.models.Animal
import com.shahadalrubaye.kidsstorybook.models.AnimalGatekeeper
import com.shahadalrubaye.kidsstorybook.models.ComparisonGatekeeper
import com.shahadalrubaye.kidsstorybook.models.ComparisonItem
import com.shahadalrubaye.kidsstorybook.models.GameProgress
import com.shahadalrubaye.kidsstorybook.models.LevelGatekeeper
import com.shahadalrubaye.kidsstorybook.ui.screens.*
import com.shahadalrubaye.kidsstorybook.ui.components.RewardedAdDialog
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.shahadalrubaye.kidsstorybook.BuildConfig

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

private sealed interface RewardUnlockTarget {
    data class Level(val level: Int) : RewardUnlockTarget
    data class Animal(val animalName: String) : RewardUnlockTarget
    data class Comparison(val comparisonId: String) : RewardUnlockTarget
}

private data class RewardDialogStrings(
    val title: String,
    val message: String,
    val watchLabel: String,
    val cancelLabel: String,
    val loadingLabel: String
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val totalLevels = remember { StoryRepository.getTotalLevels() }
    val adLockedLevels = remember(totalLevels) {
        LevelGatekeeper.lockedLevels(totalLevels)
    }
    val lockedAnimals = remember { AnimalGatekeeper.lockedAnimalNames() }
    val lockedComparisons = remember { ComparisonGatekeeper.lockedComparisonIds() }
    val animals = remember { AnimalRepository.getAllAnimals() }
    var settings by remember { mutableStateOf(preferencesManager.getSettings()) }
    val comparisonItems = remember(settings.language) {
        ComparisonRepository.getComparisonItems(context, settings.language)
    }

    // App state - language-specific progress
    var languageProgress by remember {
        mutableStateOf(preferencesManager.getLanguageProgress().clamp(totalLevels))
    }
    
    // Get current language's progress
    val progress = remember(settings.language, languageProgress) {
        languageProgress.getProgressForLanguage(settings.language).clamp(totalLevels)
    }
    
    // Language-specific ad unlock state
    var adUnlockedLevels by remember {
        mutableStateOf(preferencesManager.getAdUnlockedLevelsForLanguage(settings.language))
    }
    var adUnlockedAnimals by remember {
        mutableStateOf(preferencesManager.getAdUnlockedAnimalsForLanguage(settings.language))
    }
    var adUnlockedComparisons by remember {
        mutableStateOf(preferencesManager.getAdUnlockedComparisonsForLanguage(settings.language))
    }
    
    // Update ad unlock state when language changes
    LaunchedEffect(settings.language) {
        adUnlockedLevels = preferencesManager.getAdUnlockedLevelsForLanguage(settings.language)
        adUnlockedAnimals = preferencesManager.getAdUnlockedAnimalsForLanguage(settings.language)
        adUnlockedComparisons = preferencesManager.getAdUnlockedComparisonsForLanguage(settings.language)
    }
    var showSettings by remember { mutableStateOf(false) }
    var adDialogTarget by remember { mutableStateOf<RewardUnlockTarget?>(null) }
    var isRewardLoading by remember { mutableStateOf(false) }
    var rewardError by remember { mutableStateOf<String?>(null) }
    var pendingLaunchLevel by remember { mutableStateOf<Int?>(null) }
    var pendingAnimalSelection by remember { mutableStateOf<String?>(null) }
    var pendingComparisonSelection by remember { mutableStateOf<String?>(null) }

    val layoutDirection = LayoutDirection.Ltr

    // Settings dialog
    if (showSettings) {
        SettingsDialog(
            currentSettings = settings,
            onDismiss = { showSettings = false },
            onSettingsChange = { newSettings ->
                val oldLanguage = settings.language
                settings = newSettings
                preferencesManager.saveSettings(newSettings)
                
                // If language changed, reload language progress
                // (ad unlock state will be updated automatically via LaunchedEffect)
                if (oldLanguage != newSettings.language) {
                    languageProgress = preferencesManager.getLanguageProgress().clamp(totalLevels)
                }
            }
        )
    }

    val activity = context as? Activity

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {

        LaunchedEffect(pendingLaunchLevel) {
            val levelToLaunch = pendingLaunchLevel ?: return@LaunchedEffect
            navController.navigate(Screen.Level.createRoute(levelToLaunch))
            pendingLaunchLevel = null
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
                adUnlockedLevels = adUnlockedLevels,
                adLockedLevels = adLockedLevels,
                onLevelClick = { level ->
                    navController.navigate(Screen.Level.createRoute(level))
                },
                onLockedLevelClick = { level ->
                    if (!isRewardLoading) {
                        rewardError = null
                        adDialogTarget = RewardUnlockTarget.Level(level)
                    }
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
                lockedAnimals = lockedAnimals,
                adUnlockedAnimals = adUnlockedAnimals,
                newlyUnlockedAnimal = pendingAnimalSelection,
                onConsumeNewlyUnlockedAnimal = { pendingAnimalSelection = null },
                onHomeClick = {
                    navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                },
                onSettingsClick = {
                    showSettings = true
                },
                onLockedAnimalClick = { animal ->
                    if (!isRewardLoading) {
                        rewardError = null
                        adDialogTarget = RewardUnlockTarget.Animal(animal.name)
                    }
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
                lockedComparisonIds = lockedComparisons,
                adUnlockedComparisonIds = adUnlockedComparisons,
                newlyUnlockedComparisonId = pendingComparisonSelection,
                onConsumeNewlyUnlockedComparison = { pendingComparisonSelection = null },
                onBackClick = {
                    navController.popBackStack()
                },
                onHomeClick = {
                    navController.popBackStack(Screen.MainMenu.route, inclusive = false)
                },
                onSettingsClick = {
                    showSettings = true
                },
                onLockedComparisonClick = { item ->
                    if (!isRewardLoading) {
                        rewardError = null
                        adDialogTarget = RewardUnlockTarget.Comparison(item.id)
                    }
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
                        // Update progress with full completion for current language
                        val currentLanguageProgress = languageProgress.getProgressForLanguage(settings.language)
                        val newProgress = currentLanguageProgress.withLevelStars(
                            level = levelNumber,
                            starsEarned = GameProgress.MAX_STARS,
                            totalLevels = totalLevels
                        )
                        if (newProgress != currentLanguageProgress) {
                            languageProgress = languageProgress.withProgressForLanguage(settings.language, newProgress)
                            preferencesManager.saveProgressForLanguage(settings.language, newProgress)
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
                        // Update progress for current language
                        val currentLanguageProgress = languageProgress.getProgressForLanguage(settings.language)
                        val updatedProgress = currentLanguageProgress.withLevelStars(
                            level = level,
                            starsEarned = stars,
                            totalLevels = totalLevels
                        )
                        if (updatedProgress != currentLanguageProgress) {
                            languageProgress = languageProgress.withProgressForLanguage(settings.language, updatedProgress)
                            preferencesManager.saveProgressForLanguage(settings.language, updatedProgress)
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

    val dialogStrings = adDialogTarget?.let { target ->
        buildDialogStrings(target, settings.language, animals, comparisonItems)
    }

    if (dialogStrings != null && adDialogTarget != null && activity != null) {
        RewardedAdDialog(
            title = dialogStrings.title,
            message = dialogStrings.message,
            watchLabel = dialogStrings.watchLabel,
            cancelLabel = dialogStrings.cancelLabel,
            loadingLabel = dialogStrings.loadingLabel,
            isLoading = isRewardLoading,
            errorMessage = rewardError,
            onDismiss = {
                if (!isRewardLoading) {
                    rewardError = null
                    adDialogTarget = null
                }
            },
            onWatchClick = {
                val target = adDialogTarget ?: return@RewardedAdDialog
                if (!isRewardLoading) {
                    rewardError = null
                    showRewardedAd(
                        activity = activity,
                        onReward = {
                            when (target) {
                                is RewardUnlockTarget.Level -> {
                                    val updated = (adUnlockedLevels + target.level).toSet()
                                    adUnlockedLevels = updated
                                    preferencesManager.saveAdUnlockedLevelsForLanguage(settings.language, updated)
                                    pendingLaunchLevel = target.level
                                }
                                is RewardUnlockTarget.Animal -> {
                                    val updated = (adUnlockedAnimals + target.animalName).toSet()
                                    adUnlockedAnimals = updated
                                    preferencesManager.saveAdUnlockedAnimalsForLanguage(settings.language, updated)
                                    pendingAnimalSelection = target.animalName
                                }
                                is RewardUnlockTarget.Comparison -> {
                                    val updated = (adUnlockedComparisons + target.comparisonId).toSet()
                                    adUnlockedComparisons = updated
                                    preferencesManager.saveAdUnlockedComparisonsForLanguage(settings.language, updated)
                                    pendingComparisonSelection = target.comparisonId
                                }
                            }
                        },
                        onDismissFinished = {
                            adDialogTarget = null
                        },
                        onError = { message ->
                            rewardError = message
                        },
                        setLoading = { loading ->
                            isRewardLoading = loading
                        }
                    )
                }
            }
        )
    }
}

private fun showRewardedAd(
    activity: Activity,
    onReward: () -> Unit,
    onDismissFinished: () -> Unit,
    onError: (String) -> Unit,
    setLoading: (Boolean) -> Unit
) {
    setLoading(true)
    val adRequest = AdRequest.Builder().build()
    RewardedAd.load(
        activity,
        BuildConfig.REWARDED_AD_UNIT_ID,
        adRequest,
        object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                setLoading(false)
                onError(loadAdError.message ?: "Ad failed to load")
            }

            override fun onAdLoaded(ad: RewardedAd) {
                ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        setLoading(false)
                        onDismissFinished()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        setLoading(false)
                        onError(adError.message ?: "Ad failed to show")
                    }
                }

                ad.show(activity) {
                    onReward()
                }
            }
        }
    )
}

private fun buildDialogStrings(
    target: RewardUnlockTarget,
    language: String,
    animals: List<Animal>,
    comparisons: List<ComparisonItem>
): RewardDialogStrings {
    return when (target) {
        is RewardUnlockTarget.Level -> buildLevelDialogStrings(target.level, language)
        is RewardUnlockTarget.Animal -> buildAnimalDialogStrings(target.animalName, language, animals)
        is RewardUnlockTarget.Comparison -> buildComparisonDialogStrings(
            target.comparisonId,
            language,
            comparisons
        )
    }
}

private fun buildLevelDialogStrings(level: Int, language: String): RewardDialogStrings {
    return when (language) {
        "ar" -> RewardDialogStrings(
            title = "افتح القصة $level",
            message = "شاهد إعلانًا قصيرًا لفتح هذه القصة نهائيًا لطفلك.",
            watchLabel = "شاهد الإعلان",
            cancelLabel = "لاحقًا",
            loadingLabel = "جارٍ تحميل الإعلان..."
        )
        "tr" -> RewardDialogStrings(
            title = "$level. hikâyeyi aç",
            message = "Bu hikâyeyi kalıcı olarak açmak için kısa bir reklam izle.",
            watchLabel = "Reklamı İzle",
            cancelLabel = "Daha sonra",
            loadingLabel = "Reklam yükleniyor..."
        )
        else -> RewardDialogStrings(
            title = "Unlock story $level",
            message = "Watch a short ad to unlock this story forever.",
            watchLabel = "Watch & Unlock",
            cancelLabel = "Maybe later",
            loadingLabel = "Loading ad..."
        )
    }
}

private fun buildAnimalDialogStrings(
    animalName: String,
    language: String,
    animals: List<Animal>
): RewardDialogStrings {
    val displayName = animals.find { it.name == animalName }?.let { animal ->
        when (language) {
            "ar" -> animal.arabicName
            "tr" -> animal.turkishName
            else -> animal.englishName
        }
    } ?: animalName

    return when (language) {
        "ar" -> RewardDialogStrings(
            title = "افتح $displayName",
            message = "شاهد إعلانًا قصيرًا لفتح هذا الحيوان لطفلك.",
            watchLabel = "شاهد الإعلان",
            cancelLabel = "لاحقًا",
            loadingLabel = "جارٍ تحميل الإعلان..."
        )
        "tr" -> RewardDialogStrings(
            title = "$displayName hayvanını aç",
            message = "Bu hayvanı kalıcı olarak açmak için kısa bir reklam izle.",
            watchLabel = "Reklamı İzle",
            cancelLabel = "Daha sonra",
            loadingLabel = "Reklam yükleniyor..."
        )
        else -> RewardDialogStrings(
            title = "Unlock $displayName",
            message = "Watch a short ad to unlock this animal forever.",
            watchLabel = "Watch & Unlock",
            cancelLabel = "Maybe later",
            loadingLabel = "Loading ad..."
        )
    }
}

private fun buildComparisonDialogStrings(
    comparisonId: String,
    language: String,
    comparisonItems: List<ComparisonItem>
): RewardDialogStrings {
    val displayName = comparisonItems.find { it.id == comparisonId }?.title ?: comparisonId

    return when (language) {
        "ar" -> RewardDialogStrings(
            title = "افتح بطاقة $displayName",
            message = "شاهد إعلانًا قصيرًا لفتح هذا المثال من افعل ولا تفعل لطفلك.",
            watchLabel = "شاهد الإعلان",
            cancelLabel = "لاحقًا",
            loadingLabel = "جارٍ تحميل الإعلان..."
        )
        "tr" -> RewardDialogStrings(
            title = "$displayName kartını aç",
            message = "Bu Yap & Yapma kartını kalıcı olarak açmak için kısa bir reklam izle.",
            watchLabel = "Reklamı İzle",
            cancelLabel = "Daha sonra",
            loadingLabel = "Reklam yükleniyor..."
        )
        else -> RewardDialogStrings(
            title = "Unlock $displayName",
            message = "Watch a short ad to unlock this Do & Don't card forever.",
            watchLabel = "Watch & Unlock",
            cancelLabel = "Maybe later",
            loadingLabel = "Loading ad..."
        )
    }
}
