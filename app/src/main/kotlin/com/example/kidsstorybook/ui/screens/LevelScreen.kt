package com.example.kidsstorybook.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.Story
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.theme.TextLight
import kotlinx.coroutines.delay

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
    var maxPageViewedIndex by remember(story.id, settings.language) { mutableStateOf(-1) }
    var completionReported by remember(story.id, settings.language) { mutableStateOf(false) }
    val totalPages = imagePaths.size

    fun releaseMediaPlayer() {
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        mediaPlayer = null
        isPlaying = false
    }

    // Track progress toward star thresholds
    LaunchedEffect(currentImageIndex, totalPages) {
        if (totalPages <= 0) return@LaunchedEffect

        if (currentImageIndex > maxPageViewedIndex) {
            maxPageViewedIndex = currentImageIndex
        }

        if (!completionReported && currentImageIndex == totalPages - 1) {
            completionReported = true
            delay(500)
            onLevelComplete()
        }
    }

    LaunchedEffect(maxPageViewedIndex, totalPages) {
        if (totalPages > 0 && maxPageViewedIndex >= 0) {
            val pagesViewed = maxPageViewedIndex + 1
            val stars = calculateStarsForProgress(pagesViewed, totalPages)
            onProgressUpdate(level, stars)
        }
    }

    // Handle page changes for multi-audio stories
    LaunchedEffect(currentImageIndex, hasMultiAudio) {
        if (hasMultiAudio && isPlaying) {
            // Release current audio and prepare new one for the current page
            releaseMediaPlayer()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            releaseMediaPlayer()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF87CEEB))
    ) {
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
                    assetPath = "buttons/menu.png",
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
                        assetPath = "buttons/home.png",
                        contentDescription = "Home",
                        onClick = {
                            releaseMediaPlayer()
                            onHomeClick()
                        },
                        size = 48.dp
                    )

                    AssetIconButton(
                        assetPath = "buttons/settings.png",
                        contentDescription = "Settings",
                        onClick = onSettingsClick,
                        size = 48.dp
                    )
                }
            }

            // Story content
            if (imagePaths.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White.copy(alpha = 0.9f))
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data("file:///android_asset/${imagePaths[currentImageIndex]}")
                            .crossfade(true)
                            .build(),
                        contentDescription = "Story image ${currentImageIndex + 1}",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
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
                        assetPath = "buttons/left-arrow.png",
                        contentDescription = "Previous",
                        onClick = {
                            if (currentImageIndex > 0) currentImageIndex--
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
                        assetPath = "buttons/right-arrow.png",
                        contentDescription = "Next",
                        onClick = {
                            if (currentImageIndex < imagePaths.size - 1) currentImageIndex++
                        },
                        enabled = currentImageIndex < imagePaths.size - 1,
                        size = 64.dp
                    )
                }

                // Audio controls
                val currentAudioPath = if (hasMultiAudio && audioPaths != null && currentImageIndex < audioPaths.size) {
                    audioPaths[currentImageIndex]
                } else {
                    audioPath
                }
                
                currentAudioPath?.let { path ->
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
                                        mediaPlayer = MediaPlayer().apply {
                                            try {
                                                val afd = context.assets.openFd(path)
                                                setDataSource(
                                                    afd.fileDescriptor,
                                                    afd.startOffset,
                                                    afd.length
                                                )
                                                prepareAsync()
                                                setOnPreparedListener { mp ->
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
                                    } else {
                                        mediaPlayer?.start()
                                        isPlaying = true
                                    }
                                }
                            },
                            modifier = Modifier
                                .size(64.dp)
                                .background(Color.White, shape = androidx.compose.foundation.shape.CircleShape)
                        ) {
                            Icon(
                                if (isPlaying) Icons.Default.Close else Icons.Default.PlayArrow,
                                contentDescription = if (isPlaying) "Pause" else "Play",
                                tint = Color.Black,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        IconButton(
                            onClick = {
                                releaseMediaPlayer()
                            },
                            enabled = mediaPlayer != null,
                            modifier = Modifier
                                .size(64.dp)
                                .background(
                                    if (mediaPlayer != null) Color.White else Color.Gray,
                                    shape = androidx.compose.foundation.shape.CircleShape
                                )
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Stop",
                                tint = if (mediaPlayer != null) Color.Black else Color.DarkGray,
                                modifier = Modifier.size(32.dp)
                            )
                        }
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

