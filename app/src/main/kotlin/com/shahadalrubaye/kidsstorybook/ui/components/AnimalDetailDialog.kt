package com.shahadalrubaye.kidsstorybook.ui.components

import android.media.MediaPlayer
import android.media.audiofx.LoudnessEnhancer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahadalrubaye.kidsstorybook.models.Animal
import com.shahadalrubaye.kidsstorybook.ui.theme.TextDark
import com.shahadalrubaye.kidsstorybook.ui.theme.TextLight

@Composable
fun AnimalDetailDialog(
    animal: Animal,
    language: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var loudnessEnhancer by remember { mutableStateOf<LoudnessEnhancer?>(null) }
    
    val audioPath = animal.getAudioPath(language)
    
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
    
    fun playAudio() {
        releaseMediaPlayer()
        mediaPlayer = MediaPlayer().apply {
            try {
                val afd = context.assets.openFd(audioPath)
                setDataSource(
                    afd.fileDescriptor,
                    afd.startOffset,
                    afd.length
                )
                setVolume(1.0f, 1.0f) // Set maximum volume
                prepareAsync()
                setOnPreparedListener { mp ->
                    // Apply loudness enhancement (boost by 1000 millibels = 10dB)
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
    
    DisposableEffect(Unit) {
        onDispose {
            releaseMediaPlayer()
        }
    }

    LaunchedEffect(audioPath) {
        playAudio()
    }
    
    Dialog(
        onDismissRequest = {
            releaseMediaPlayer()
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false
        )
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(24.dp))
                .shadow(elevation = 16.dp, shape = RoundedCornerShape(24.dp))
                .background(Color.White)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Close button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = {
                            releaseMediaPlayer()
                            onDismiss()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = TextDark
                        )
                    }
                }
                
                // Animal Image
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data("file:///android_asset/${animal.imagePath}")
                        .crossfade(true)
                        .build(),
                    contentDescription = animal.getDisplayName(language),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Fit
                )
                
                // Animal Name
                Text(
                    text = animal.getDisplayName(language),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark,
                    textAlign = TextAlign.Center
                )
                
                // Play/Pause Button
                IconButton(
                    onClick = {
                        if (isPlaying) {
                            mediaPlayer?.pause()
                            isPlaying = false
                        } else {
                            if (mediaPlayer == null) {
                                playAudio()
                            } else {
                                mediaPlayer?.start()
                                isPlaying = true
                            }
                        }
                    },
                    modifier = Modifier
                        .size(80.dp)
                        .background(
                            Color(0xFF4CAF50),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Pause" else "Play",
                        tint = TextLight,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

