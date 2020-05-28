package com.example.mvvmdemo.ui.users

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.R
import com.example.mvvmdemo.ViewModelProviderFactory

import com.example.mvvmdemo.databinding.ActivityUsersListBinding
import com.example.mvvmdemo.ui.base.BaseActivity
import com.example.mvvmdemo.ui.users.usersListAdapter.UsersListAdapter
import kotlinx.android.synthetic.main.activity_users_list.*
import javax.inject.Inject


class UsersListActivity : BaseActivity<ActivityUsersListBinding, UsersListActivityViewModel>(),
    UsersListNavigater, UsersListAdapter.BlogAdapterListener {

    lateinit var foctory: ViewModelProviderFactory
        @Inject set

    lateinit var mAdapter: UsersListAdapter
        @Inject set
    lateinit var mLayoutManager: LinearLayoutManager
        @Inject set

    lateinit var mUsersListActivityViewModel: UsersListActivityViewModel
    lateinit var mActivityUsersListBinding: ActivityUsersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mUsersListActivityViewModel.setNavigator(this)
        mActivityUsersListBinding = getViewDataBinding()
        mActivityUsersListBinding.lifecycleOwner = this
        rvPlaces.layoutManager = mLayoutManager
        rvPlaces.adapter = mAdapter
        mAdapter.setListner(this)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_users_list
    }

    override fun getViewModel(): UsersListActivityViewModel {
        mUsersListActivityViewModel =
            ViewModelProvider(this, foctory).get(UsersListActivityViewModel::class.java)
        return mUsersListActivityViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun placesApiCall() {
        mUsersListActivityViewModel.ApiCallPlaces()
    }

    override fun onRetryClick() {

        mUsersListActivityViewModel.ApiCallPlaces()
    }


}
