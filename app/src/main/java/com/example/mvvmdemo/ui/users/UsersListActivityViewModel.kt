package com.example.mvvmdemo.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.data.local.DataManager
import com.example.mvvmdemo.data.model.userResponse.Data
import com.example.mvvmdemo.ui.base.BaseViewModel
import com.example.mvvmdemo.utils.rx.SchedulerProvider
import retrofit2.Retrofit

class UsersListActivityViewModel(
    schedulerProvider: SchedulerProvider,
    retrofit: Retrofit,
    mDataManager: DataManager
) : BaseViewModel<UsersListNavigater>(
    schedulerProvider, retrofit, mDataManager
) {

    var data: MutableLiveData<List<Data>> = MutableLiveData()

    fun ApiCallPlaces() {
        setIsLoading(true)
        getCompositeDisposable()?.add(
            getDataManager()?.GET_USERDATA(1)
                ?.subscribeOn(getSchedularProvider()?.io())
                ?.observeOn(getSchedularProvider()?.ui())
                ?.subscribe({
                    setIsLoading(false)
                    data.value = it.data
                }, {
                    setIsLoading(false)
                })!!
        )
    }

    fun response(): LiveData<List<Data>> {
        return data
    }

    init {
        ApiCallPlaces()
    }
}