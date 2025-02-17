package com.example.newsapplication.presentation.onborarding.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapplication.ui.theme.Dimen
import com.example.newsapplication.ui.theme.Dimen.Space_10
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun PagerIndicator(size: Int, currentPage: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(Space_10)
    ) {
        repeat(size) { pageIndex ->
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        if (pageIndex == currentPage) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.secondary
                        }
                    )
                    .size(Dimen.Space_16)
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun PagerIndicatorPreviewDarkMode() {
    NewsApplicationTheme {
        PagerIndicator(size = 3, currentPage = 1)
    }
}
