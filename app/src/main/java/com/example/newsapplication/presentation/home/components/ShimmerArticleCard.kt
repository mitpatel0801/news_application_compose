package com.example.newsapplication.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapplication.presentation.common.shimmerEffect
import com.example.newsapplication.ui.theme.Dimen.Space_16
import com.example.newsapplication.ui.theme.Dimen.Space_32
import com.example.newsapplication.ui.theme.Dimen.Space_4
import com.example.newsapplication.ui.theme.Dimen.Space_96

@Composable
fun ShimmerArticleCard(
    modifier: Modifier = Modifier,
) {

    Row {
        Box(
            modifier = Modifier
                .size(Space_96)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(Space_4)
                .height(Space_96)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(Space_32)
                    .fillMaxWidth()
                    .shimmerEffect()
            )

            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Box(
                    modifier = modifier
                        .height(Space_16)
                        .fillMaxWidth(0.3f)
                        .shimmerEffect()
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(horizontal = Space_16)) {
        repeat(10) {
            ShimmerArticleCard(modifier = Modifier.padding(horizontal = 4.dp))
        }
    }
}