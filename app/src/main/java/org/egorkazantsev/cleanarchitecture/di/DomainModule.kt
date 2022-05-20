package org.egorkazantsev.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserUseCase(userRepository: UserRepository): SaveUserUseCase {
        return SaveUserUseCase(userRepository = userRepository)
    }
}