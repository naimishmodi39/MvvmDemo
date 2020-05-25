package com.example.mvvmdemo.ui.googlePlaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.R
import com.example.mvvmdemo.ViewModelProviderFactory
import com.example.mvvmdemo.ui.base.BaseActivity
import com.example.mvvmdemo.databinding.ActivityPlacesBinding
import com.example.mvvmdemo.ui.googlePlaces.placesAdapter.PlacesAdapter
import com.example.mvvmdemo.utils.AppContants
import kotlinx.android.synthetic.main.activity_places.*
import javax.inject.Inject


class PlacesActivity : BaseActivity<ActivityPlacesBinding, PlacesActivityViewModel>(),
    PlacesNavigater, PlacesAdapter.BlogAdapterListener {

    lateinit var foctory: ViewModelProviderFactory
        @Inject set

    lateinit var mAdapter: PlacesAdapter
        @Inject set
    lateinit var mLayoutManager: LinearLayoutManager
        @Inject set

    lateinit var mPlacesActivityViewModel: PlacesActivityViewModel
    lateinit var mActivityPlacesBinding: ActivityPlacesBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mActivityPlacesBinding = getViewDataBinding()
        mActivityPlacesBinding.lifecycleOwner = this
        mPlacesActivityViewModel.setNavigator(this)
        rvPlaces.layoutManager = mLayoutManager
        rvPlaces.adapter = mAdapter
        mAdapter.setListner(this)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_places
    }

    override fun getViewModel(): PlacesActivityViewModel {
        mPlacesActivityViewModel =
            ViewModelProvider(this, foctory).get(PlacesActivityViewModel::class.java)
        return mPlacesActivityViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun placesApiCall() {
        var url = AppContants.API_PLACE_ADDRESS
        mPlacesActivityViewModel.ApiCallPlaces(url)
    }

    override fun onRetryClick() {
        var url = AppContants.API_PLACE_ADDRESS
        mPlacesActivityViewModel.ApiCallPlaces(url)
    }


}
