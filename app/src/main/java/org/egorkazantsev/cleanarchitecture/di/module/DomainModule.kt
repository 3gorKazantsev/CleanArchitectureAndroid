package org.egorkazantsev.cleanarchitecture.di.module

import dagger.Module
import dagger.Provides
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

    @Provides
    fun provideSaveUserUseCase(userRepository: UserRepository): SaveUserUseCase {
        return SaveUserUseCase(userRepository)
    }
}