package com.hanhag.dodotimr.di.components

import com.hanhag.dodotimr.di.modules.ContextModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface AppComponent {

}