package com.cmdv.btcar.di

import android.content.Context
import com.cmdv.btcar.data.BlueToothDataManager
import com.cmdv.btcar.data.repositories.BluetoothRepositoryImpl
import com.cmdv.btcar.domain.repositories.BluetoothRepository
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