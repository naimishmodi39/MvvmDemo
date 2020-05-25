package com.example.mvvmdemo.di.builder

import com.example.mvvmdemo.di.module.LoginModule
import com.example.mvvmdemo.ui.googlePlaces.PlacesActivity
import com.example.mvvmdemo.ui.googlePlaces.PlacesActivityModul
import com.example.mvvmdemo.ui.mainActivity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun ContributesMainActivity(): MainActivity


    @ContributesAndroidInjector(modules = [PlacesActivityModul::class])
    abstract fun bindPlacesActivity(): PlacesActivity


}