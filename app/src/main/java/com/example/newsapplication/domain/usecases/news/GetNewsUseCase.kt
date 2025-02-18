package com.example.newsapplication.domain.usecases.news

import com.example.newsapplication.domain.repositories.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>) = newsRepository.getNews(sources)
}