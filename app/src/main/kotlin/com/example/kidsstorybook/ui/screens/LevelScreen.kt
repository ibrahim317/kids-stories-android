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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.Story
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.theme.TextLight

@Composable
fun LevelScreen(
    story: Story,
    level: Int,
    settings: AppSettings,
    onLevelComplete: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var currentImageIndex by remember { mutableStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    val imagePaths = story.getImagePaths(settings.language)
    val audioPath = story.getAudioPath(settings.language)

    // Check if level is completed (reached the last image)
    LaunchedEffect(currentImageIndex) {
        if (currentImageIndex == imagePaths.size - 1) {
            // Level completed - wait a bit then notify
            kotlinx.coroutines.delay(500)
            onLevelComplete()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.apply {
                if (isPlaying) {
                    stop()
                }
                release()
            }
            mediaPlayer = null
            isPlaying = false
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Level title
                Text(
                    text = when (settings.language) {
                        "ar" -> "المستوى $level"
                        "tr" -> "Seviye $level"
                        else -> "Level $level"
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextLight
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AssetIconButton(
                        assetPath = "buttons/home.png",
                        contentDescription = "Home",
                        onClick = {
                            mediaPlayer?.release()
                            mediaPlayer = null
                            isPlaying = false
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
                audioPath?.let { path ->
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
                                                    isPlaying = false
                                                    mediaPlayer?.release()
                                                    mediaPlayer = null
                                                    true
                                                }
                                            } catch (e: Exception) {
                                                e.printStackTrace()
                                                isPlaying = false
                                                mediaPlayer?.release()
                                                mediaPlayer = null
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
                                mediaPlayer?.apply {
                                    if (isPlaying) {
                                        stop()
                                    }
                                    try {
                                        prepareAsync()
                                    } catch (e: Exception) {
                                        e.printStackTrace()
                                        release()
                                        mediaPlayer = null
                                    }
                                    isPlaying = false
                                }
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

