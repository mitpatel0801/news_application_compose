package com.example.newsapplication.presentation.onborarding

import androidx.annotation.DrawableRes
import com.example.newsapplication.R

data class Page(@DrawableRes val image: Int, val title: String, val description: String)

val pages = listOf(
    Page(
        R.drawable.onboarding1,
        "Title Page 1",
        "This is the description of page 1, and it can be of multiple lines."
    ),
    Page(
        R.drawable.onboarding2,
        "Title Page 2",
        "This is the description of page 2, and it can be of multiple lines."
    ),
    Page(
        R.drawable.onboarding3,
        "Title Page 3",
        "This is the description of page 3, and it can be of multiple lines."
    )
)