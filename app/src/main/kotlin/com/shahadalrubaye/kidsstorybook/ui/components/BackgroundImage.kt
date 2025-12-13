package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun BackgroundImage(
    assetPath: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    val context = LocalContext.current
    
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data("file:///android_asset/$assetPath")
            .crossfade(true)
            .build(),
        contentDescription = "Background",
        modifier = modifier,
        contentScale = contentScale
    )
}

