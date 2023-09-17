package com.cmdv.btcar.di

import com.cmdv.btcar.domain.repositories.BluetoothRepository
import com.cmdv.btcar.domain.usecases.GetBluetoothStatusUseCase
import com.cmdv.btcar.domain.usecases.GetBluetoothAdapterInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class DomainModule {

    @Provides
    fun provideGetBluetoothAdapterInfoUseCase(repository: BluetoothRepository) =
        GetBluetoothAdapterInfoUseCase(repository)

    @Provides
    fun provideConnectCellphoneToCarUseCase(repository: BluetoothRepository) =
        GetBluetoothStatusUseCase(repository)

}