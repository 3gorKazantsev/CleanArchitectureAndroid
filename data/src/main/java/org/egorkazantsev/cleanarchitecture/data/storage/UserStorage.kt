package org.egorkazantsev.cleanarchitecture.data.storage

import org.egorkazantsev.cleanarchitecture.data.model.UserD

interface UserStorage {

    fun saveUser(user: UserD): Boolean

    fun getUser(): UserD
}