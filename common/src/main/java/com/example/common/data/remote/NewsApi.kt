package com.example.common.data.remote

import com.example.common.domain.model.UiState
import javax.inject.Inject

class NewsApi @Inject constructor() {

    fun getNews() = UiState.Success(
        mutableListOf<String>().apply {
            for (i in 1..100) {
                add("#$i NEWS")
            }
        }
    )
}
