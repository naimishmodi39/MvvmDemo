package com.example.mvvmdemo.data.local

import com.example.mvvmdemo.data.local.prefs.PreferencesHelper
import com.example.mvvmdemo.data.local.remote.ApiHelper
import com.example.mvvmdemo.data.model.userResponse.UserResponse
import io.reactivex.Observable
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

//    override fun doLogin(
//        cms_id: String,
//        password: String,
//        do_logout: String,
//        push_id: String
//    ): Observable<LoginResponse> {
//        return mApiHelper.doLogin(cms_id, password, do_logout, push_id)
//    }

    override fun GET_USERDATA(Page: Int): Observable<UserResponse> {
        return mApiHelper.GET_USERDATA(Page)
    }
}