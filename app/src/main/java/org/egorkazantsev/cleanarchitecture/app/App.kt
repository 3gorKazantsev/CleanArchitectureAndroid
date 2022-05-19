package org.egorkazantsev.cleanarchitecture.app

import android.app.Application
import org.egorkazantsev.cleanarchitecture.di.appModule
import org.egorkazantsev.cleanarchitecture.di.dataModule
import org.egorkazantsev.cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                appModule,
                dataModule,
                domainModule
            ))
        }
    }
}