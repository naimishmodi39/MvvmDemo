package com.example.mvvmdemo.data.local

import com.benchmate.sports.data.responsebean.LoginResponse.LoginResponse
import com.benchmate.sports.data.responsebean.PlacesResponse.PlacesResponse
import com.example.mvvmdemo.data.local.prefs.PreferencesHelper
import com.example.mvvmdemo.data.local.remote.ApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(
    var mPreferencesHelper: PreferencesHelper,
    var mApiHelper: ApiHelper
) : DataManager {


    override fun getAccessToken(): String {
        return mPreferencesHelper.getAccessToken()
    }

    override fun setAccessToken(accessToken: String) {
        return mPreferencesHelper.setAccessToken("")
    }

    override fun doLogin(
        cms_id: String,
        password: String,
        do_logout: String,
        push_id: String
    ): Observable<LoginResponse> {
        return mApiHelper.doLogin(cms_id, password, do_logout, push_id)
    }

    override fun GET_ADDRESS(s: String?): Observable<PlacesResponse> {
        return mApiHelper.GET_ADDRESS(s)
    }
}