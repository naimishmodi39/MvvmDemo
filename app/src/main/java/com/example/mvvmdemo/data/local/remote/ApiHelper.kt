package com.example.mvvmdemo.data.local.remote

import com.example.mvvmdemo.data.model.userResponse.UserResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiHelper {

    @GET(ApiEndPoint.USERS)
    fun GET_USERDATA(@Query("page") Page: Int): Observable<UserResponse>

}