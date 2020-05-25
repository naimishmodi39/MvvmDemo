package com.example.mvvmdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.data.local.DataManager
import com.example.mvvmdemo.ui.googlePlaces.PlacesActivity
import com.example.mvvmdemo.ui.googlePlaces.PlacesActivityViewModel
import com.example.mvvmdemo.ui.googlePlaces.placesAdapter.PlacesViewModel
import com.example.mvvmdemo.ui.mainActivity.MainActivityViewModel
import com.example.mvvmdemo.utils.rx.SchedulerProvider
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    var schedulerProvider: SchedulerProvider,
    var retrofit: Retrofit,
    var mDataManager: DataManager
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> {
                return MainActivityViewModel(
                    schedulerProvider,
                    retrofit,
                    mDataManager
                ) as T
            }
            modelClass.isAssignableFrom(PlacesActivityViewModel::class.java) -> {
                return PlacesActivityViewModel(schedulerProvider, retrofit, mDataManager) as T
            }

            else -> return throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}