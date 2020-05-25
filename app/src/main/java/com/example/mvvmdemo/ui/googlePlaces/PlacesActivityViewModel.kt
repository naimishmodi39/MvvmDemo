package com.example.mvvmdemo.ui.googlePlaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benchmate.sports.data.responsebean.PlacesResponse.PlacesResponse
import com.benchmate.sports.data.responsebean.PlacesResponse.ResultsItem
import com.example.mvvmdemo.data.local.DataManager
import com.example.mvvmdemo.ui.base.BaseViewModel
import com.example.mvvmdemo.utils.rx.SchedulerProvider
import retrofit2.Retrofit

class PlacesActivityViewModel(
    schedulerProvider: SchedulerProvider,
    retrofit: Retrofit,
    mDataManager: DataManager
) : BaseViewModel<PlacesNavigater>(schedulerProvider, retrofit, mDataManager) {

    var data: MutableLiveData<List<ResultsItem>> = MutableLiveData()

    fun ApiCallPlaces(s: String) {
        setIsLoading(true)
        getCompositeDisposable()?.add(
            getDataManager()?.GET_ADDRESS(s)
                ?.subscribeOn(getSchedularProvider()?.io())
                ?.observeOn(getSchedularProvider()?.ui())
                ?.subscribe({
                    setIsLoading(false)
                    data.value = it.results
                }, {
                    setIsLoading(false)
                })!!
        )

    }


    fun Places() {
        getNavigator().placesApiCall()
    }

    fun response(): LiveData<List<ResultsItem>> {
        return data
    }
}