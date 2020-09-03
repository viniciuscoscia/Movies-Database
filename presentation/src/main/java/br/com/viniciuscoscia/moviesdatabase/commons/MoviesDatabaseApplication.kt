package br.com.viniciuscoscia.moviesdatabase.commons

import android.app.Application
import br.com.viniciuscoscia.domain.moviesdatabase.di.domainModule
import br.com.viniciuscoscia.moviesdatabase.data.di.dataModules
import br.com.viniciuscoscia.moviesdatabase.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesDatabaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MoviesDatabaseApplication)
            modules(applicationModule + dataModules + domainModule)
        }
    }
}