package com.example.mvvmdemo.ui.mainActivity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.R
import com.example.mvvmdemo.ViewModelProviderFactory
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.ui.base.BaseActivity
import javax.inject.Inject

open class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),
    MainNavigater {

    lateinit var foctory: ViewModelProviderFactory
        @Inject set

    val TAG = "MainActivity"

    lateinit var mMainActivityViewModel: MainActivityViewModel
    lateinit var mActivityMainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = getViewDataBinding()
        mMainActivityViewModel.setNavigator(this)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainActivityViewModel {
        mMainActivityViewModel =
            ViewModelProvider(this, foctory).get(MainActivityViewModel::class.java)
        return mMainActivityViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun Login() {
        mMainActivityViewModel.Login("player", "12345678")
    }

}
