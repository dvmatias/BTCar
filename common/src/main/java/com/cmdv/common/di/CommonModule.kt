package com.cmdv.common.di

import android.content.Context
import com.cmdv.common.EventHandler
import com.cmdv.common.EventHandlerImpl
import com.cmdv.common.navigator.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Singleton
    @Provides
    fun provideEventHandler(navigator: Navigator): EventHandler {
        return EventHandlerImpl(navigator)
    }

    /*
    @Binds
    abstract fun bind(usecase: GetUseCase): BaseUseCase<,> (your generic type)

    companion object {

        @Provides
        fun providesUseCase(): GetUseCase {
            return GetUseCase(// required dependency)
        }
    }
     */
}