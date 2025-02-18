package com.example.newsapplication.domain.usecases.news

import com.example.newsapplication.domain.repositories.NewsRepository
import javax.inject.Inject

class SearchNews @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(searchQuery: String, sources: List<String>) =
        newsRepository.searchNews(searchQuery, sources)
}