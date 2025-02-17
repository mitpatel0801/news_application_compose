package com.example.newsapplication.presentation.onborarding.components

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapplication.presentation.onborarding.Page
import com.example.newsapplication.presentation.onborarding.pages
import com.example.newsapplication.ui.theme.Dimen.Space_16
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun PagerImageWithDescription(
    modifier: Modifier = Modifier, page: Page
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = Space_16)
        )
        Text(
            text = page.description,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = Space_16),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PagerImageWithDescriptionPreview() {
    NewsApplicationTheme {
        PagerImageWithDescription(page = pages[0])
    }
}