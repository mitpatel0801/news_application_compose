package com.example.newsapplication.presentation.onborarding

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapplication.presentation.common.PrimaryButton
import com.example.newsapplication.presentation.common.TextButton
import com.example.newsapplication.presentation.onborarding.components.PagerImageWithDescription
import com.example.newsapplication.presentation.onborarding.components.PagerIndicator
import com.example.newsapplication.ui.theme.Dimen
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onboardingViewModel: OnboardingViewModel = hiltViewModel(),
    navigateToHomePage: () -> Unit = {}
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
            val pagerState = rememberPagerState { pages.size }
            val buttonState by remember {
                derivedStateOf {
                    when (pagerState.currentPage) {
                        0 -> ButtonState.FirstPage
                        pagerState.pageCount - 1 -> ButtonState.LastPage
                        else -> ButtonState.MiddlePages
                    }
                }
            }
            HorizontalPager(
                pagerState, modifier = Modifier.weight(1f)
            ) { pageIndex ->
                PagerImageWithDescription(
                    page = pages[pageIndex]
                )
            }
            val coroutineScope = rememberCoroutineScope()
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(Dimen.Space_16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PagerIndicator(
                    pagerState.pageCount,
                    pagerState.currentPage,
                )
                ShowButtons(buttonState, {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }, {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }, {
                    onboardingViewModel.setSaveAppEntry()
                    navigateToHomePage()
                })
            }

        }
    }
}

@Composable
fun ShowButtons(
    buttonState: ButtonState,
    nextButtonOnClick: () -> Unit,
    backButtonOnClick: () -> Unit,
    startButtonOnClick: () -> Unit,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(Dimen.Space_8)) {

        if (buttonState != ButtonState.FirstPage) {
            TextButton("Back", backButtonOnClick)
        }

        if (buttonState != ButtonState.LastPage) {
            PrimaryButton("Next", nextButtonOnClick)
        } else {
            PrimaryButton("Start", startButtonOnClick)
        }
    }
}

enum class ButtonState {
    FirstPage, MiddlePages, LastPage
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}

