package com.example.cleanarchitecture.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.domain.model.UiState
import com.example.common.use_case.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _topNews = MutableLiveData<List<String>>(emptyList())
    val topNews: LiveData<List<String>> = _topNews

    private val _loadingProgressIndicator = MutableStateFlow(true)
    val loadingProgressIndicator: StateFlow<Boolean> = _loadingProgressIndicator

    fun getTopNews() = viewModelScope.launch {
        _loadingProgressIndicator.value = true

        when (val response = newsUseCase.getTopNews()) {
            is UiState.Success -> {
                val data = response.data
                _topNews.postValue(data)
                _loadingProgressIndicator.value = false
            }
            is UiState.Loading -> {
                _loadingProgressIndicator.value = true
            }
        }
    }
}
