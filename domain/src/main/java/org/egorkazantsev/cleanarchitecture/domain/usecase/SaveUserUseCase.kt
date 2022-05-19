package org.egorkazantsev.cleanarchitecture.domain.usecase

import org.egorkazantsev.cleanarchitecture.domain.model.UserParam
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository) {

    fun execute(param: UserParam) : Boolean {
        return userRepository.saveUser(param)
    }
}