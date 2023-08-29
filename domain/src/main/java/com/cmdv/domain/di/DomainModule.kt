package com.cmdv.domain.di

import com.cmdv.domain.repositories.BluetoothRepository
import com.cmdv.domain.usecases.GetBluetoothAdapterInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetBluetoothAdapterInfoUseCase(repository: BluetoothRepository) =
        GetBluetoothAdapterInfoUseCase(repository)

}