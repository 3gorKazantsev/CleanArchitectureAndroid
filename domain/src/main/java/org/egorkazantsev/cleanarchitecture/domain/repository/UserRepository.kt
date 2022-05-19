package org.egorkazantsev.cleanarchitecture.domain.repository

import org.egorkazantsev.cleanarchitecture.domain.model.User
import org.egorkazantsev.cleanarchitecture.domain.model.UserParam

interface UserRepository {

    fun getUser(): User

    fun saveUser(userParam: UserParam): Boolean
}