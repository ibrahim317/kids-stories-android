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
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.models.Story
import com.shahadalrubaye.kidsstorybook.ui.components.AssetIconButton
import com.shahadalrubaye.kidsstorybook.ui.components.BackgroundImage
import com.shahadalrubaye.kidsstorybook.ui.components.BookFlipController
import com.shahadalrubaye.kidsstorybook.ui.components.BookFlipPage
import com.shahadalrubaye.kidsstorybook.ui.components.CartoonButton
import com.shahadalrubaye.kidsstorybook.ui.theme.FunGreen
import com.shahadalrubaye.kidsstorybook.ui.theme.LimeGreen
import com.shahadalrubaye.kidsstorybook.ui.theme.TextLight

@Composable
fun LevelScreen(
    story: Story,
    level: Int,
    settings: AppSettings,
    onLevelComplete: () -> Unit,
    onRoadmapClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onProgressUpdate: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imagePaths = remember(story.id, settings.language) {
        story.getImagePaths(settings.language)
    }
    val hasMultiAudio = remember(story.id, settings.language) {
        story.hasMultipleAudioFiles(settings.language)
    }
    val audioPath = remember(story.id, settings.language) {
        story.getAudioPath(settings.language)
    }
    val audioPaths = remember(story.id, settings.language) {
        story.getAudioPaths(settings.language)
    }
    var currentImageIndex by remember(story.id, settings.language) { mutableStateOf(0) }
    var isPlaying by remember(story.id, settings.language) { mutableStateOf(false) }
    var mediaPlayer by remember(story.id, settings.language) { mutableStateOf<MediaPlayer?>(null) }
    var loudnessEnhancer by remember(story.id, settings.language) { mutableStateOf<LoudnessEnhancer?>(null) }
    var maxPageViewedIndex by remember(story.id, settings.language) { mutableStateOf(-1) }
    var bookFlipController by remember { mutableStateOf<BookFlipController?>(null) }
    val totalPages = imagePaths.size
    
    // Determine background based on level (5 levels per section)
    val backgroundImage = remember(level) {
        when ((level - 1) / 5) {
            0 -> "backgrounds/main_menu.webp"  // Levels 1-5
            1 -> "backgrounds/bg-2.webp"        // Levels 6-10
            2 -> "backgrounds/bg-3.webp"        // Levels 11-15
            else -> "backgrounds/main_menu.webp" // Default
        }
    }

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
        val currentAudioPath = if (hasMultiAudio && audioPaths != null && currentImageIndex < audioPaths.size) {
            // For multi-audio stories, audio index matches image index
            audioPaths[currentImageIndex]
        } else {
            audioPath
        }
        
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
        }
    }

    // Track progress toward star thresholds
    LaunchedEffect(currentImageIndex, totalPages) {
        if (totalPages <= 0) return@LaunchedEffect

        if (currentImageIndex > maxPageViewedIndex) {
            maxPageViewedIndex = currentImageIndex
        }
    }

    LaunchedEffect(maxPageViewedIndex, totalPages) {
        if (totalPages > 0 && maxPageViewedIndex >= 0) {
            val pagesViewed = maxPageViewedIndex + 1
            val stars = calculateStarsForProgress(pagesViewed, totalPages)
            onProgressUpdate(level, stars)
        }
    }

    // Stop any playing audio when the page changes (no autoplay)
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
        // Background image based on roadmap section
        BackgroundImage(
            assetPath = backgroundImage,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        
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
                    contentDescription = "Roadmap",
                    onClick = {
                        releaseMediaPlayer()
                        onRoadmapClick()
                    },
                    size = 48.dp
                )

                Text(
                    text = when (settings.language) {
                        "ar" -> "المستوى $level"
                        "tr" -> "Seviye $level"
                        else -> "Level $level"
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
                }
            }

            // Story content with book flip animation
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

                // Navigation controls (alternative to swipe gestures)
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
            val currentAudioPath = if (imagePaths.isNotEmpty()) {
                if (hasMultiAudio && audioPaths != null && currentImageIndex < audioPaths.size) {
                    // For multi-audio stories, audio index matches image index
                    audioPaths[currentImageIndex]
                } else {
                    audioPath
                }
            } else {
                null
            }
            
            // Audio controls - always show button
            if (imagePaths.isNotEmpty()) {
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
                        enabled = currentAudioPath != null,
                        modifier = Modifier
                            .size(64.dp)
                            .background(Color.White, shape = androidx.compose.foundation.shape.CircleShape)
                    ) {
                        Icon(
                            if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (isPlaying) "Pause" else "Play",
                            tint = if (currentAudioPath != null) Color.Black else Color.Gray,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                // Finish button (only shown on last page)
                if (currentImageIndex == totalPages - 1) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CartoonButton(
                            text = when (settings.language) {
                                "ar" -> "إنهاء"
                                "tr" -> "Bitir"
                                else -> "Finish"
                            },
                            onClick = {
                                releaseMediaPlayer()
                                onLevelComplete()
                            },
                            gradientColors = listOf(LimeGreen, FunGreen),
                            modifier = Modifier.fillMaxWidth(0.7f)
                        )
                    }
                }
            }
        }
    }
}

private fun calculateStarsForProgress(pagesViewed: Int, totalPages: Int): Int {
    if (totalPages <= 0 || pagesViewed <= 0) return 0
    val ratio = pagesViewed.coerceAtMost(totalPages).toFloat() / totalPages.toFloat()

    return when {
        ratio >= 1f -> 3
        ratio >= 0.7f -> 2
        ratio >= 0.3f -> 1
        else -> 0
    }
}

