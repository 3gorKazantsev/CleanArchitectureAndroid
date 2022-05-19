package org.egorkazantsev.cleanarchitecture.app

import android.app.Application
import org.egorkazantsev.cleanarchitecture.di.AppComponent
import org.egorkazantsev.cleanarchitecture.di.DaggerAppComponent
import org.egorkazantsev.cleanarchitecture.di.module.AppModule

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}