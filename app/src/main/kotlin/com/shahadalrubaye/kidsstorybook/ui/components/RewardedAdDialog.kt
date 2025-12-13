package com.shahadalrubaye.kidsstorybook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.shahadalrubaye.kidsstorybook.ui.theme.FunGreen
import com.shahadalrubaye.kidsstorybook.ui.theme.LimeGreen

@Composable
fun RewardedAdDialog(
    title: String,
    message: String,
    watchLabel: String,
    cancelLabel: String,
    loadingLabel: String,
    isLoading: Boolean,
    errorMessage: String?,
    onDismiss: () -> Unit,
    onWatchClick: () -> Unit
) {
    Dialog(
        onDismissRequest = {
            if (!isLoading) {
                onDismiss()
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = !isLoading,
            dismissOnClickOutside = !isLoading
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(28.dp))
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF222222)
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color(0xFF444444)
            )

            if (isLoading) {
                Spacer(modifier = Modifier.size(20.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp),
                    color = FunGreen,
                    strokeWidth = 4.dp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = loadingLabel,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF666666)
                )
            }

            if (!errorMessage.isNullOrBlank()) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.size(24.dp))
            CartoonButton(
                text = watchLabel,
                onClick = onWatchClick,
                enabled = !isLoading,
                gradientColors = listOf(LimeGreen, FunGreen),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(12.dp))
            TextButton(
                enabled = !isLoading,
                onClick = onDismiss
            ) {
                Text(text = cancelLabel, color = Color(0xFF666666))
            }
        }
    }
}

