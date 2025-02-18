package com.example.newsapplication.domain.usecases.news

import com.example.newsapplication.domain.repositories.NewsRepository

class GetNews constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>) = newsRepository.getNews(sources)
}