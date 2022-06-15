package com.example.common.data.repository

import com.example.common.data.remote.NewsApi
import com.example.common.di.IoDispatcher
import com.example.common.domain.repository.MainRepository
import com.example.common.domain.model.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    @IoDispatcher private val iODispatcher: CoroutineDispatcher,
    private val newsApi: NewsApi
) : MainRepository {

    override suspend fun getTopNews(): UiState<List<String>> = withContext(iODispatcher) {
        delay(2000L)
        return@withContext newsApi.getNews()
    }
}
