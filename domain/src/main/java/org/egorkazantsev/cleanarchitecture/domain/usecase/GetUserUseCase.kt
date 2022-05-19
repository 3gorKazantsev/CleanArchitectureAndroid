package org.egorkazantsev.cleanarchitecture.domain.usecase

import org.egorkazantsev.cleanarchitecture.domain.model.User
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    fun execute(): User {
        return userRepository.getUser()
    }
}