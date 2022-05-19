package org.egorkazantsev.cleanarchitecture.data.repository

import org.egorkazantsev.cleanarchitecture.data.model.UserD
import org.egorkazantsev.cleanarchitecture.data.storage.UserStorage
import org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs.DEFAULT_LAST_NAME
import org.egorkazantsev.cleanarchitecture.domain.model.User
import org.egorkazantsev.cleanarchitecture.domain.model.UserParam
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun getUser(): User {
        val userD = userStorage.getUser()
        return toUser(userD)
    }

    override fun saveUser(userParam: UserParam): Boolean {
        return userStorage.saveUser(toUserD(userParam))
    }

    private fun toUser(userD: UserD): User {
        return User(userD.firstName, userD.lastName)
    }

    private fun toUserD(userParam: UserParam): UserD {
        return UserD(userParam.name, DEFAULT_LAST_NAME)
    }
}