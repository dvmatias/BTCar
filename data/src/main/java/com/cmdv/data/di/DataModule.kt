package com.cmdv.data.di

import android.content.Context
import com.cmdv.data.BlueToothDataManager
import com.cmdv.data.repositories.BluetoothRepositoryImpl
import com.cmdv.domain.repositories.BluetoothRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideBlueToothDataManager(@ApplicationContext appContext: Context): BlueToothDataManager {
        return BlueToothDataManager(appContext)
    }

    @Singleton
    @Provides
    fun provideBluetoothRepository(blueToothDataManager: BlueToothDataManager): BluetoothRepository {
        return BluetoothRepositoryImpl(blueToothDataManager)
    }
}