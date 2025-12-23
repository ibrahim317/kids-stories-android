package com.shahadalrubaye.kidsstorybook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahadalrubaye.kidsstorybook.data.AnimalRepository
import com.shahadalrubaye.kidsstorybook.models.Animal
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.ui.components.*
import com.shahadalrubaye.kidsstorybook.ui.theme.TextLight

@Composable
fun AnimalsScreen(
    settings: AppSettings,
    lockedAnimals: Set<String>,
    adUnlockedAnimals: Set<String>,
    newlyUnlockedAnimal: String?,
    onConsumeNewlyUnlockedAnimal: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLockedAnimalClick: (Animal) -> Unit,
    modifier: Modifier = Modifier
) {
    val animals = remember { AnimalRepository.getAllAnimals() }
    var selectedAnimal by remember { mutableStateOf<Animal?>(null) }
    val gridState = rememberLazyGridState()

    LaunchedEffect(newlyUnlockedAnimal) {
        if (!newlyUnlockedAnimal.isNullOrBlank()) {
            animals.find { it.name == newlyUnlockedAnimal }?.let { unlocked ->
                selectedAnimal = unlocked
            }
            onConsumeNewlyUnlockedAnimal()
        }
    }
    
    Box(modifier = modifier.fillMaxSize()) {
        // Background
        BackgroundImage(
            assetPath = "backgrounds/main_menu.webp",
            modifier = Modifier.matchParentSize()
        )
        
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AssetIconButton(
                    assetPath = "buttons/home.webp",
                    contentDescription = "Home",
                    onClick = onHomeClick,
                    size = 48.dp
                )
                
                Text(
                    text = when (settings.language) {
                        "ar" -> "الحيوانات"
                        "tr" -> "Hayvanlar"
                        else -> "Animals"
                    },
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextLight,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                
                AssetIconButton(
                    assetPath = "buttons/settings.webp",
                    contentDescription = "Settings",
                    onClick = onSettingsClick,
                    size = 48.dp
                )
            }
            
            // Animals Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(animals) { animal ->
                    val requiresUnlock = lockedAnimals.contains(animal.name)
                    val hasUnlocked = adUnlockedAnimals.contains(animal.name)
                    val isLocked = requiresUnlock && !hasUnlocked

                    AnimalCard(
                        animal = animal,
                        language = settings.language,
                        isLocked = isLocked,
                        lockedCtaLabel = when (settings.language) {
                            "ar" -> "شاهد إعلان"
                            "tr" -> "Reklam İzle"
                            else -> "Watch Ad"
                        },
                        onClick = {
                            if (isLocked) {
                                onLockedAnimalClick(animal)
                            } else {
                                selectedAnimal = animal
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        
        // Animal Detail Dialog
        selectedAnimal?.let { animal ->
            AnimalDetailDialog(
                animal = animal,
                language = settings.language,
                onDismiss = {
                    selectedAnimal = null
                }
            )
        }
    }
}

