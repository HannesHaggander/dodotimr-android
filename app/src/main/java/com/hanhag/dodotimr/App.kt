package com.hanhag.dodotimr

import android.app.Application
import com.hanhag.dodotimr.di.components.AppComponent
import com.hanhag.dodotimr.di.components.DaggerAppComponent
import com.hanhag.dodotimr.di.modules.ContextModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }

    init {
        if (instance == null) instance = synchronized(this) { instance ?: this }
    }

    companion object {
        @Volatile
        private var instance: App? = null

        fun instance(): App = instance ?: throw Exception("Instance not instantiated")
    }

}