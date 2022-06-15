package com.example.common.domain.repository

import com.example.common.domain.model.UiState

interface MainRepository {

    suspend fun getTopNews(): UiState<List<String>>

}
