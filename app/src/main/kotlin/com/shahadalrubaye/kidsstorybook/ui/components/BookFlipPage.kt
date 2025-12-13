package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import eu.wewox.pagecurl.ExperimentalPageCurlApi
import eu.wewox.pagecurl.page.PageCurl
import eu.wewox.pagecurl.page.PageCurlState
import eu.wewox.pagecurl.page.rememberPageCurlState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Controller for BookFlipPage to trigger page animations from outside
 */
@OptIn(ExperimentalPageCurlApi::class)
class BookFlipController(
    private val state: PageCurlState,
    private val scope: CoroutineScope
) {
    /**
     * Flip to the next page with animation
     */
    fun flipNext() {
        scope.launch {
            state.next()
        }
    }
    
    /**
     * Flip to the previous page with animation
     */
    fun flipPrev() {
        scope.launch {
            state.prev()
        }
    }
}

/**
 * BookFlipPage component that uses a real PageCurl library for realistic book page turning.
 * 
 * @param imagePaths List of image paths for all pages
 * @param currentPageIndex Current page index being displayed
 * @param onPageChange Callback when page changes
 * @param onControllerReady Callback when controller is ready to use
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalPageCurlApi::class)
@Composable
fun BookFlipPage(
    imagePaths: List<String>,
    currentPageIndex: Int,
    onPageChange: (Int) -> Unit,
    onControllerReady: (BookFlipController) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    // Create state for page curl with the number of pages
    val pageCurlState = rememberPageCurlState(
        max = imagePaths.size,
        initialCurrent = currentPageIndex
    )
    
    // Create and provide controller
    val controller = remember(pageCurlState, coroutineScope) {
        BookFlipController(pageCurlState, coroutineScope)
    }
    
    LaunchedEffect(controller) {
        onControllerReady(controller)
    }
    
    // Monitor page changes and notify parent
    LaunchedEffect(pageCurlState.current) {
        if (pageCurlState.current != currentPageIndex) {
            onPageChange(pageCurlState.current)
        }
    }
    
    Box(modifier = modifier.fillMaxSize()) {
        PageCurl(
            state = pageCurlState,
            modifier = Modifier.fillMaxSize()
        ) { index ->
            // Render each page
            PageContent(
                imagePath = imagePaths[index],
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Content for each page
 */
@Composable
private fun PageContent(
    imagePath: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    Box(
        modifier = modifier
            .padding(2.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("file:///android_asset/$imagePath")
                .crossfade(true)
                .build(),
            contentDescription = "Story page",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}
