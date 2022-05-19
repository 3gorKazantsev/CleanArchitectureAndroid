package org.egorkazantsev.cleanarchitecture.di

import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserUseCase> {
        GetUserUseCase(userRepository = get())
    }

    factory<SaveUserUseCase> {
        SaveUserUseCase(userRepository = get())
    }
}