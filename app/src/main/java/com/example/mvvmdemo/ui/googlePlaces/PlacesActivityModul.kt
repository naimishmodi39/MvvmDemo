package com.example.mvvmdemo.ui.googlePlaces

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.ui.googlePlaces.placesAdapter.PlacesAdapter
import dagger.Module
import dagger.Provides

@Module
class PlacesActivityModul {

    @Provides
    fun providePlacesAdapter(): PlacesAdapter {
        return PlacesAdapter()
    }

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }
}