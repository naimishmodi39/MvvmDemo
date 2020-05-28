package com.example.mvvmdemo.ui.users

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.ui.users.usersListAdapter.UsersListAdapter
import dagger.Module
import dagger.Provides

@Module
class UsersListActivityModul {

    @Provides
    fun providePlacesAdapter(): UsersListAdapter {
        return UsersListAdapter()
    }

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }
}