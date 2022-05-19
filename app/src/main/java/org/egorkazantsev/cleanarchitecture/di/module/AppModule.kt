package org.egorkazantsev.cleanarchitecture.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase
import org.egorkazantsev.cleanarchitecture.presentation.MainViewModelFactory

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserUseCase: GetUserUseCase,
        saveUserUseCase: SaveUserUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase
        )
    }
}