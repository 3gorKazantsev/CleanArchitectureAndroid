package org.egorkazantsev.cleanarchitecture.di

import dagger.Component
import org.egorkazantsev.cleanarchitecture.di.module.AppModule
import org.egorkazantsev.cleanarchitecture.di.module.DataModule
import org.egorkazantsev.cleanarchitecture.di.module.DomainModule
import org.egorkazantsev.cleanarchitecture.presentation.MainActivity

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}