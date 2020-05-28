package com.example.mvvmdemo.di.builder

import com.example.mvvmdemo.ui.users.UsersListActivity
import com.example.mvvmdemo.ui.users.UsersListActivityModul
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [UsersListActivityModul::class])
    abstract fun bindPlacesActivity(): UsersListActivity


}