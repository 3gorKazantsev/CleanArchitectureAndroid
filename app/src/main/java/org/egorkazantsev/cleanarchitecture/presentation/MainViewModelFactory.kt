package org.egorkazantsev.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.egorkazantsev.cleanarchitecture.data.repository.UserRepositoryImpl
import org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs.UserSharedPrefs
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(UserSharedPrefs(context))
    }

    private val getUserUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserUseCase(userRepository)
    }
    private val saveUserUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase
        ) as T
    }
}