package org.egorkazantsev.cleanarchitecture.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.egorkazantsev.cleanarchitecture.data.repository.UserRepositoryImpl
import org.egorkazantsev.cleanarchitecture.data.storage.UserStorage
import org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs.UserSharedPrefs
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return UserSharedPrefs(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}
