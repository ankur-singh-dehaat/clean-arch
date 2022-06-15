package com.example.common.use_case

import com.example.common.domain.repository.MainRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getTopNews() = mainRepository.getTopNews()
}
