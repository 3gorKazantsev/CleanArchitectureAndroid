package org.egorkazantsev.cleanarchitecture.di

import org.egorkazantsev.cleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>{
        MainViewModel(
            getUserUseCase = get(),
            saveUserUseCase = get()
        )
    }
}