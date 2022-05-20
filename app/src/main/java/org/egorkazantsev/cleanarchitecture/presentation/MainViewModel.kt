package org.egorkazantsev.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.egorkazantsev.cleanarchitecture.domain.model.User
import org.egorkazantsev.cleanarchitecture.domain.model.UserParam
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData

    fun save(text: String) {
        val param = UserParam(text)
        val result = saveUserUseCase.execute(param)
        resultMutableLiveData.value = "Save result = $result"
    }

    fun receive() {
        val user: User = getUserUseCase.execute()
        resultMutableLiveData.value = "${user.firstName} ${user.lastName}"
    }
}