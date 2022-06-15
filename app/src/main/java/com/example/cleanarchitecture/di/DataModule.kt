package com.example.cleanarchitecture.di

import com.example.common.data.repository.MainRepositoryImpl
import com.example.common.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository = mainRepositoryImpl
}
