package org.egorkazantsev.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.egorkazantsev.cleanarchitecture.domain.model.User
import org.egorkazantsev.cleanarchitecture.domain.model.UserParam
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase

// желательно ViewModel не должна зависить от Android классов (например контекст)
// а только содержать чистый kotlin код
class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData
    private val userMutableLiveData = MutableLiveData<String>()
    val userLiveData: LiveData<String> = userMutableLiveData

    fun save(text: String) {
        val param = UserParam(text)
        val result = saveUserUseCase.execute(param)
        resultMutableLiveData.value = "Save result = $result"
    }

    fun receive() {
        val user: User = getUserUseCase.execute()
        userMutableLiveData.value = "${user.firstName} ${user.lastName}"
    }
}