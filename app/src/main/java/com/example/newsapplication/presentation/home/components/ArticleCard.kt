package com.example.newsapplication.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapplication.R
import com.example.newsapplication.ui.theme.Dimen.Space_16
import com.example.newsapplication.ui.theme.Dimen.Space_4
import com.example.newsapplication.ui.theme.Dimen.Space_96
import com.example.newsapplication.ui.theme.NewsApplicationTheme
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source

@Composable
fun ArticleCard(
    modifier: Modifier,
    article: Article,
    onClick: () -> Unit
) {

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(Space_96)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(Space_4)
                .height(Space_96)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.DarkGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(Space_4))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(Space_16),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(Space_4))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ArticleCardPreview() {
    NewsApplicationTheme {
        ArticleCard(modifier = Modifier, article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "2 hours",
            source = Source(id = "", name = "BBC"),
            title = "Her train broke down. Her phone died. And then she met her Saver in a",
            url = "",
            urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
        ), onClick = {})
    }
}