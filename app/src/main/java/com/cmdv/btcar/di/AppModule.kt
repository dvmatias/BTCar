package com.cmdv.btcar.di

import com.cmdv.btcar.navigation.NavigatorImpl
import com.cmdv.common.navigator.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = NavigatorImpl()
}