package org.egorkazantsev.cleanarchitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.egorkazantsev.cleanarchitecture.data.repository.UserRepositoryImpl
import org.egorkazantsev.cleanarchitecture.data.storage.UserStorage
import org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs.UserSharedPrefs
import org.egorkazantsev.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return UserSharedPrefs(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}