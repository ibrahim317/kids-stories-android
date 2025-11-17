package com.example.kidsstorybook.ui.screens

import android.media.MediaPlayer
import android.media.audiofx.LoudnessEnhancer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kidsstorybook.data.ComparisonRepository
import com.example.kidsstorybook.models.AppSettings
import com.example.kidsstorybook.models.ComparisonItem
import com.example.kidsstorybook.ui.components.AssetIconButton
import com.example.kidsstorybook.ui.components.BackgroundImage
import com.example.kidsstorybook.ui.components.SmallCartoonButton
import com.example.kidsstorybook.ui.theme.TextLight

@Composable
fun ComparisonsScreen(
    settings: AppSettings,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val comparisonItems = remember(settings.language) {
        ComparisonRepository.getComparisonItems(context, settings.language)
    }
    var selectedItem by remember { mutableStateOf<ComparisonItem?>(null) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        BackgroundImage(
            assetPath = "backgrounds/bg-2.png",
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(
                language = settings.language,
                onBackClick = onBackClick,
                onHomeClick = onHomeClick,
                onSettingsClick = onSettingsClick
            )

            if (comparisonItems.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = when (settings.language) {
                            "ar" -> "لا توجد عناصر للمقارنة."
                            "tr" -> "Gösterilecek karşılaştırma yok."
                            else -> "No comparisons available."
                        },
                        color = TextLight,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(comparisonItems) { item ->
                        ComparisonListItem(
                            item = item,
                            language = settings.language,
                            onClick = { selectedItem = item }
                        )
                    }
                }
            }
        }

        selectedItem?.let { item ->
            ComparisonDetailDialog(
                item = item,
                language = settings.language,
                onDismiss = { selectedItem = null }
            )
        }
    }
}

@Composable
private fun TopBar(
    language: String,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AssetIconButton(
            assetPath = "buttons/menu.png",
            contentDescription = "Back",
            onClick = onBackClick,
            size = 48.dp
        )

        Text(
            text = when (language) {
                "ar" -> "افعل ولا تفعل"
                "tr" -> "Yap & Yapma"
                else -> "Do & Don't"
            },
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = TextLight,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AssetIconButton(
                assetPath = "buttons/home.png",
                contentDescription = "Home",
                onClick = onHomeClick,
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
}

@Composable
private fun ComparisonListItem(
    item: ComparisonItem,
    language: String,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(24.dp),
        color = Color.White.copy(alpha = 0.9f),
        tonalElevation = 4.dp,
        shadowElevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Image thumbnail
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/${item.imagePath}")
                    .crossfade(true)
                    .build(),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFF5F0EA), RoundedCornerShape(16.dp))
            )
            
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4A3F35)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Do section
                Text(
                    text = getDoLabel(language),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B806A),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.doText,
                    color = Color(0xFF333333),
                    fontSize = 13.sp,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Don't section
                Text(
                    text = getDontLabel(language),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB3261E),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.dontText,
                    color = Color(0xFF333333),
                    fontSize = 13.sp,
                    maxLines = 2
                )
            }
        }
    }
}

@Composable
private fun ComparisonDetailDialog(
    item: ComparisonItem,
    language: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var loudnessEnhancer by remember { mutableStateOf<LoudnessEnhancer?>(null) }
    var isPlaying by remember { mutableStateOf(false) }

    fun releaseMediaPlayer() {
        mediaPlayer?.let { player ->
            runCatching {
                if (player.isPlaying) {
                    player.stop()
                }
            }
            player.release()
        }
        loudnessEnhancer?.release()
        mediaPlayer = null
        loudnessEnhancer = null
        isPlaying = false
    }

    fun playAudio() {
        if (item.audioPath == null) return
        releaseMediaPlayer()

        try {
            mediaPlayer = MediaPlayer().apply {
                val afd = context.assets.openFd(item.audioPath)
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                setVolume(1.0f, 1.0f) // Set maximum volume
                setOnPreparedListener { player ->
                    // Apply loudness enhancement (boost by 15dB)
                    try {
                        loudnessEnhancer = LoudnessEnhancer(player.audioSessionId).apply {
                            setTargetGain(1500) // Boost by 15dB (1500 millibels)
                            enabled = true
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    player.start()
                    isPlaying = true
                }
                setOnCompletionListener {
                    releaseMediaPlayer()
                }
                setOnErrorListener { _, _, _ ->
                    releaseMediaPlayer()
                    true
                }
                prepareAsync()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            releaseMediaPlayer()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            releaseMediaPlayer()
        }
    }

    val playLabel = when (language) {
        "ar" -> "تشغيل الصوت"
        "tr" -> "Sesi oynat"
        else -> "Play sound"
    }

    val stopLabel = when (language) {
        "ar" -> "إيقاف الصوت"
        "tr" -> "Sesi durdur"
        else -> "Stop sound"
    }

    val closeLabel = when (language) {
        "ar" -> "إغلاق"
        "tr" -> "Kapat"
        else -> "Close"
    }

    val audioMissingLabel = when (language) {
        "ar" -> "لا يتوفر تسجيل صوتي لهذا العنصر."
        "tr" -> "Bu öğe için ses bulunmuyor."
        else -> "Audio is not available for this item."
    }

    Dialog(
        onDismissRequest = {
            releaseMediaPlayer()
            onDismiss()
        }
    ) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = item.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4A3F35)
                )

                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data("file:///android_asset/${item.imagePath}")
                        .crossfade(true)
                        .build(),
                    contentDescription = item.title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 250.dp, max = 350.dp)
                        .background(Color(0xFFF5F0EA), RoundedCornerShape(20.dp))
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = getDoLabel(language),
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B806A)
                    )
                    Text(
                        text = item.doText,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = getDontLabel(language),
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFB3261E),
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    Text(
                        text = item.dontText,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFF333333)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SmallCartoonButton(
                        text = if (isPlaying) stopLabel else playLabel,
                        onClick = {
                            if (isPlaying) {
                                releaseMediaPlayer()
                            } else {
                                playAudio()
                            }
                        },
                        modifier = Modifier.weight(1f),
                        enabled = item.audioPath != null
                    )

                    SmallCartoonButton(
                        text = closeLabel,
                        onClick = {
                            releaseMediaPlayer()
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f),
                        gradientColors = listOf(Color(0xFF8E50D7), Color(0xFF6E39B1))
                    )
                }

                if (item.audioPath == null) {
                    Text(
                        text = audioMissingLabel,
                        color = Color.Gray,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

private fun getDoLabel(language: String): String {
    return when (language) {
        "ar" -> "افعل"
        "tr" -> "Yap"
        else -> "Do"
    }
}

private fun getDontLabel(language: String): String {
    return when (language) {
        "ar" -> "لا تفعل"
        "tr" -> "Yapma"
        else -> "Don't"
    }
}

