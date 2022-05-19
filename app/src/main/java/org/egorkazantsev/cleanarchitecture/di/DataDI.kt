package org.egorkazantsev.cleanarchitecture.di

import org.egorkazantsev.cleanarchitecture.data.repository.UserRepositoryImpl
import org.egorkazantsev.cleanarchitecture.data.storage.UserStorage
import org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs.UserSharedPrefs
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        UserSharedPrefs(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}
