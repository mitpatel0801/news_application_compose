package com.example.newsapplication.presentation.common

import com.example.newsapplication.ui.theme.Dimen.Space_8
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight


@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(size = Space_8)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
) {
    TextButton(onClick = onClick,  shape = RoundedCornerShape(size = Space_8)) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}







