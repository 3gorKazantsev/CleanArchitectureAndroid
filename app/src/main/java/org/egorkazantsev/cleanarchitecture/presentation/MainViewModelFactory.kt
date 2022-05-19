package org.egorkazantsev.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase
import javax.inject.Inject

class MainViewModelFactory (
    val getUserUseCase: GetUserUseCase,
    val saveUserUseCase: SaveUserUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase
        ) as T
    }
}