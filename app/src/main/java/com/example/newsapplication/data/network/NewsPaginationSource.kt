package com.example.newsapplication.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.model.Article

class NewsPaginationSource(
   private val newsApi: NewsApi, private val sources: String
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPage ->
            val page = state.closestPageToPosition(anchorPage)
            page?.nextKey?.minus(1) ?: page?.prevKey?.plus(1)
        }
    }

    private var totalFetchedArticles = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val currentPage = params.key ?: 1
            val newsResponse = newsApi.getNews(sources, currentPage)
            val articles = newsResponse.articles.distinctBy { it.title }
            totalFetchedArticles += articles.size
            LoadResult.Page(
                articles,
                null,
                if (totalFetchedArticles < newsResponse.totalResults) currentPage.plus(1) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }
}