package com.shahadalrubaye.kidsstorybook.ui.screens

import android.media.MediaPlayer
import android.media.audiofx.LoudnessEnhancer
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shahadalrubaye.kidsstorybook.data.ComparisonRepository
import com.shahadalrubaye.kidsstorybook.models.AppSettings
import com.shahadalrubaye.kidsstorybook.models.ComparisonItem
import com.shahadalrubaye.kidsstorybook.ui.components.AssetIconButton
import com.shahadalrubaye.kidsstorybook.ui.components.BackgroundImage
import com.shahadalrubaye.kidsstorybook.ui.components.SmallCartoonButton
import com.shahadalrubaye.kidsstorybook.ui.theme.TextLight

@Composable
fun ComparisonsScreen(
    settings: AppSettings,
    lockedComparisonIds: Set<String>,
    adUnlockedComparisonIds: Set<String>,
    newlyUnlockedComparisonId: String?,
    onConsumeNewlyUnlockedComparison: () -> Unit,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLockedComparisonClick: (ComparisonItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val comparisonGroups = remember(settings.language) {
        ComparisonRepository.getComparisonGroups(context, settings.language)
    }
    val comparisonItems = remember(comparisonGroups) {
        comparisonGroups.flatMap { group -> group.children }
    }
    var selectedItem by remember { mutableStateOf<ComparisonItem?>(null) }
    val listState = rememberLazyListState()

    LaunchedEffect(newlyUnlockedComparisonId) {
        if (!newlyUnlockedComparisonId.isNullOrBlank()) {
            comparisonItems.find { it.id == newlyUnlockedComparisonId }?.let { unlocked ->
                selectedItem = unlocked
            }
            onConsumeNewlyUnlockedComparison()
        }
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        BackgroundImage(
            assetPath = "backgrounds/main_menu.webp",
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
                ComparisonZigZagList(
                    items = comparisonItems,
                    lockedComparisonIds = lockedComparisonIds,
                    adUnlockedComparisonIds = adUnlockedComparisonIds,
                    lockedCtaLabel = when (settings.language) {
                        "ar" -> "شاهد إعلان"
                        "tr" -> "Reklam İzle"
                        else -> "Watch Ad"
                    },
                    onItemClick = { selectedItem = it },
                    onLockedItemClick = onLockedComparisonClick,
                    listState = listState
                )
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
            assetPath = "buttons/home.webp",
            contentDescription = "Home",
            onClick = onHomeClick,
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

        AssetIconButton(
            assetPath = "buttons/settings.webp",
            contentDescription = "Settings",
            onClick = onSettingsClick,
            size = 48.dp
        )
    }
}

@Composable
private fun ComparisonZigZagList(
    items: List<ComparisonItem>,
    lockedComparisonIds: Set<String>,
    adUnlockedComparisonIds: Set<String>,
    lockedCtaLabel: String,
    onItemClick: (ComparisonItem) -> Unit,
    onLockedItemClick: (ComparisonItem) -> Unit,
    listState: androidx.compose.foundation.lazy.LazyListState
) {
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val currentItem = item
                val requiresUnlock = lockedComparisonIds.contains(currentItem.id)
                val hasUnlocked = adUnlockedComparisonIds.contains(currentItem.id)
                val isLocked = requiresUnlock && !hasUnlocked

                val handleClick = {
                    if (isLocked) {
                        onLockedItemClick(currentItem)
                    } else {
                        onItemClick(currentItem)
                    }
                }

                if (index % 2 == 0) {
                    ComparisonItemCard(
                        item = currentItem,
                        isLocked = isLocked,
                        lockedCtaLabel = lockedCtaLabel,
                        onClick = handleClick,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.weight(1f))
                } else {
                    Box(modifier = Modifier.weight(1f))
                    ComparisonItemCard(
                        item = currentItem,
                        isLocked = isLocked,
                        lockedCtaLabel = lockedCtaLabel,
                        onClick = handleClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ComparisonItemCard(
    item: ComparisonItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLocked: Boolean,
    lockedCtaLabel: String? = null
) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.96f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "comparison_card_scale"
    )

    val glassBackground = Color(0xFFFAFAFA).copy(alpha = 0.8f)
    val glassBorder = Color.White.copy(alpha = 0.6f)

    val saturation = if (isLocked) 0f else 1f
    val colorMatrix = remember(saturation) {
        val matrix = ColorMatrix()
        matrix.setToSaturation(saturation)
        matrix
    }

    Box(
        modifier = modifier
            .aspectRatio(0.95f)
            .scale(scale)
            .shadow(
                elevation = if (isPressed) 4.dp else 8.dp,
                shape = RoundedCornerShape(28.dp),
                clip = false
            )
            .clip(RoundedCornerShape(28.dp))
            .background(glassBackground)
            .border(
                width = 1.5.dp,
                color = glassBorder,
                shape = RoundedCornerShape(28.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = item.title,
                color = Color.Black.copy(alpha = if (isLocked) 0.4f else 1f),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            val thumbnailPath = item.thumbnailPath ?: item.imagePath

            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("file:///android_asset/$thumbnailPath")
                    .crossfade(true)
                    .build(),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .border(
                        width = 4.dp,
                        color = Color.White.copy(alpha = 0.8f),
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(colorMatrix)
            )

            if (isLocked && !lockedCtaLabel.isNullOrBlank()) {
                Text(
                    text = lockedCtaLabel,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF555555),
                    textAlign = TextAlign.Center
                )
            }
        }

        if (isLocked) {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                tint = Color(0xFF555555),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .size(28.dp)
            )
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

    LaunchedEffect(item.id) {
        playAudio()
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

                SmallCartoonButton(
                    text = closeLabel,
                    onClick = {
                        releaseMediaPlayer()
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    gradientColors = listOf(Color(0xFF8E50D7), Color(0xFF6E39B1))
                )

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

