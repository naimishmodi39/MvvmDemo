package com.example.mvvmdemo.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.data.local.DataManager
import com.example.mvvmdemo.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import java.lang.ref.WeakReference

open class BaseViewModel<N>(
    schedulerProvider: SchedulerProvider,
    retrofit: Retrofit,
    mDataManager: DataManager
) : ViewModel() {


    private var mIsLoading: ObservableBoolean = ObservableBoolean()

    private var mSchedulerProvider: SchedulerProvider? = null

    private var mCompositeDisposable: CompositeDisposable? = null
//    private  var mSchedulerProvider:SchedulerProvider? = null

    lateinit var mNavigator: WeakReference<N>
    private var mRetrofit: Retrofit? = null
    private var mDataManager: DataManager? = null


    init {
        mSchedulerProvider = schedulerProvider
        mCompositeDisposable = CompositeDisposable()
        mRetrofit = retrofit
        this.mDataManager = mDataManager
    }


    override fun onCleared() {
        mCompositeDisposable?.clear()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }


    fun getNavigator(): N {
        return mNavigator.get()!!
    }

    fun getDataManager(): DataManager? {
        return mDataManager
    }

    fun getCompositeDisposable(): CompositeDisposable? {
        return mCompositeDisposable
    }

    fun getSchedularProvider(): SchedulerProvider? {
        return mSchedulerProvider
    }

}