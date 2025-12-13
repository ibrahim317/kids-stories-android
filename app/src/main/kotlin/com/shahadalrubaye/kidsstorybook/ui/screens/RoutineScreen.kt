package com.shahadalrubaye.kidsstorybook.ui.screens

import android.media.MediaPlayer
import android.media.audiofx.LoudnessEnhancer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.ui.components.AssetIconButton
import com.shahadalrubaye.kidsstorybook.ui.components.BookFlipController
import com.shahadalrubaye.kidsstorybook.ui.components.BookFlipPage
import com.shahadalrubaye.kidsstorybook.ui.theme.TextLight

@Composable
fun RoutineScreen(
    routineType: String, // "morning" or "evening"
    settings: AppSettings,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    // Get language code for asset paths
    val languageCode = when (settings.language) {
        "ar" -> "AR"
        "tr" -> "TR"
        else -> "EN"
    }
    
    // Load routine images
    val imagePaths = remember(routineType, languageCode) {
        loadRoutineImages(context, routineType, languageCode)
    }
    
    // Load routine audio files
    val audioPaths = remember(routineType, languageCode) {
        loadRoutineAudioFiles(context, routineType, languageCode)
    }
    
    var currentImageIndex by remember { mutableStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var loudnessEnhancer by remember { mutableStateOf<LoudnessEnhancer?>(null) }
    var bookFlipController by remember { mutableStateOf<BookFlipController?>(null) }
    val totalPages = imagePaths.size
    
    // Background - only top part (sun part) for morning, bottom part (moon part) for evening
    val backgroundImage = "backgrounds/day_and_night2.webp"
    
    fun releaseMediaPlayer() {
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        loudnessEnhancer?.release()
        mediaPlayer = null
        loudnessEnhancer = null
        isPlaying = false
    }
    
    fun playAudioForCurrentSlide() {
        if (currentImageIndex >= audioPaths.size) {
            releaseMediaPlayer()
            return
        }
        
        val currentAudioPath = audioPaths.getOrNull(currentImageIndex)
        currentAudioPath?.let { path ->
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer().apply {
                try {
                    val afd = context.assets.openFd(path)
                    setDataSource(
                        afd.fileDescriptor,
                        afd.startOffset,
                        afd.length
                    )
                    setVolume(1.0f, 1.0f) // Set maximum volume
                    prepareAsync()
                    setOnPreparedListener { mp ->
                        // Apply loudness enhancement (boost by 15dB)
                        try {
                            loudnessEnhancer = LoudnessEnhancer(mp.audioSessionId).apply {
                                setTargetGain(1500) // Boost by 15dB (1500 millibels)
                                enabled = true
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        mp.start()
                        isPlaying = true
                    }
                    setOnCompletionListener {
                        isPlaying = false
                    }
                    setOnErrorListener { _, _, _ ->
                        releaseMediaPlayer()
                        true
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    releaseMediaPlayer()
                }
            }
        } ?: run {
            releaseMediaPlayer()
        }
    }
    
    // Stop any playing audio when the slide changes (no autoplay)
    LaunchedEffect(currentImageIndex) {
        if (mediaPlayer != null || isPlaying) {
            releaseMediaPlayer()
        }
    }
    
    DisposableEffect(Unit) {
        onDispose {
            releaseMediaPlayer()
        }
    }
    
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background image - show only top (sun) or bottom (moon) part
        // For morning: show top half, for evening: show bottom half
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Show full background image
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/$backgroundImage")
                    .crossfade(true)
                    .build(),
                contentDescription = "Background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            
            // Overlay to mask the unwanted half with matching background colors
            if (routineType == "morning") {
                // Mask bottom half for morning (show only top/sun part)
                // Use sky blue to match the day sky
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .align(Alignment.BottomCenter)
                        .background(Color(0xFF87CEEB)) // Sky blue
                )
            } else {
                // Mask top half for evening (show only bottom/moon part)
                // Use dark blue to match the night sky
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .align(Alignment.TopCenter)
                        .background(Color(0xFF191970)) // Midnight blue
                )
            }
        }
        
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AssetIconButton(
                    assetPath = "buttons/menu.webp",
                    contentDescription = "Back",
                    onClick = {
                        releaseMediaPlayer()
                        onBackClick()
                    },
                    size = 48.dp
                )
                
                Text(
                    text = when {
                        routineType == "morning" -> when (settings.language) {
                            "ar" -> "الصباح"
                            "tr" -> "Sabah"
                            else -> "Morning"
                        }
                        else -> when (settings.language) {
                            "ar" -> "المساء"
                            "tr" -> "Akşam"
                            else -> "Evening"
                        }
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextLight,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    textAlign = TextAlign.Center
                )
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AssetIconButton(
                        assetPath = "buttons/home.webp",
                        contentDescription = "Home",
                        onClick = {
                            releaseMediaPlayer()
                            onHomeClick()
                        },
                        size = 48.dp
                    )
                    
                    AssetIconButton(
                        assetPath = "buttons/settings.webp",
                        contentDescription = "Settings",
                        onClick = onSettingsClick,
                        size = 48.dp
                    )
                }
            }
            
            // Routine content with book flip animation
            if (imagePaths.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color(0xFFF5E6D3).copy(alpha = 0.9f))
                ) {
                    BookFlipPage(
                        imagePaths = imagePaths,
                        currentPageIndex = currentImageIndex,
                        onPageChange = { newIndex ->
                            currentImageIndex = newIndex
                        },
                        onControllerReady = { controller ->
                            bookFlipController = controller
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                
                // Navigation controls
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Previous button
                    AssetIconButton(
                        assetPath = "buttons/left-arrow.webp",
                        contentDescription = "Previous",
                        onClick = {
                            bookFlipController?.flipPrev()
                        },
                        enabled = currentImageIndex > 0,
                        size = 64.dp
                    )
                    
                    // Page indicator
                    Text(
                        text = "${currentImageIndex + 1}/${imagePaths.size}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextLight
                    )
                    
                    // Next button
                    AssetIconButton(
                        assetPath = "buttons/right-arrow.webp",
                        contentDescription = "Next",
                        onClick = {
                            bookFlipController?.flipNext()
                        },
                        enabled = currentImageIndex < imagePaths.size - 1,
                        size = 64.dp
                    )
                }
            }
            
            // Audio controls
            if (imagePaths.isNotEmpty() && currentImageIndex < audioPaths.size) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            if (isPlaying) {
                                mediaPlayer?.pause()
                                isPlaying = false
                            } else {
                                if (mediaPlayer == null) {
                                    playAudioForCurrentSlide()
                                } else {
                                    mediaPlayer?.start()
                                    isPlaying = true
                                }
                            }
                        },
                        enabled = currentImageIndex < audioPaths.size,
                        modifier = Modifier
                            .size(64.dp)
                            .background(Color.White, shape = androidx.compose.foundation.shape.CircleShape)
                    ) {
                        Icon(
                            if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (isPlaying) "Pause" else "Play",
                            tint = if (currentImageIndex < audioPaths.size) Color.Black else Color.Gray,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}

// Helper function to load routine images
private fun loadRoutineImages(context: android.content.Context, routineType: String, languageCode: String): List<String> {
    val imagePaths = mutableListOf<String>()
    val basePath = "routine/$routineType/$languageCode"
    
    try {
        val files = context.assets.list(basePath) ?: emptyArray()
        files
            .filter { it.endsWith(".webp") && !it.contains("sound") }
            .sortedBy { it.toIntOrNull() ?: Int.MAX_VALUE }
            .forEach { fileName ->
                imagePaths.add("$basePath/$fileName")
            }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    
    return imagePaths
}

// Helper function to load routine audio files
private fun loadRoutineAudioFiles(context: android.content.Context, routineType: String, languageCode: String): List<String> {
    val audioPaths = mutableListOf<String>()
    val basePath = "routine/$routineType/$languageCode/sound"
    
    try {
        val files = context.assets.list(basePath) ?: emptyArray()
        files
            .filter { it.endsWith(".mp3") }
            .sortedBy { it.removeSuffix(".mp3").toIntOrNull() ?: Int.MAX_VALUE }
            .forEach { fileName ->
                audioPaths.add("$basePath/$fileName")
            }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    
    return audioPaths
}

