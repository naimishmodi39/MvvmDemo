package com.example.mvvmdemo.ui.mainActivity

import android.util.Log
import com.example.mvvmdemo.data.local.DataManager
import com.example.mvvmdemo.ui.base.BaseViewModel
import com.example.mvvmdemo.utils.rx.SchedulerProvider
import retrofit2.Retrofit

class MainActivityViewModel(
    schedulerProvider: SchedulerProvider,
    retrofit: Retrofit,
    mDataManager: DataManager
) : BaseViewModel<MainNavigater>(schedulerProvider, retrofit, mDataManager) {



    fun Login(email: String, password: String) {
        setIsLoading(true)
        getCompositeDisposable()?.add(
            getDataManager()?.doLogin(email, password, "1", "")
                ?.subscribeOn(getSchedularProvider()?.io())
                ?.observeOn(getSchedularProvider()?.ui())
                ?.subscribe({ v ->
                    setIsLoading(false)
                    Log.e("MainActivity", "" + v.message)


                }, { e ->
                    setIsLoading(false)
                    Log.e("MainActivity", "$e")
                })!!
        )
    }

    fun loginApiCall() {
        getNavigator().Login()
    }

}