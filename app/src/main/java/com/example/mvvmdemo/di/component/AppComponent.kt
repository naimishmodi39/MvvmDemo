package com.example.mvvmdemo.di.component

import android.app.Application
import com.example.mvvmdemo.MvvmDemo
import com.example.mvvmdemo.di.builder.ActivityBuilder
import com.example.mvvmdemo.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app:MvvmDemo)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

       fun build(): AppComponent?

    }
}