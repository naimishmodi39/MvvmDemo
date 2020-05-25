package com.example.mvvmdemo.data.local.remote

import com.benchmate.sports.data.responsebean.LoginResponse.LoginResponse
import com.benchmate.sports.data.responsebean.PlacesResponse.PlacesResponse
import com.example.mvvmdemo.utils.AppContants
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface ApiHelper {

    @FormUrlEncoded
    @POST(AppContants.SIGNIN)
    fun doLogin(
        @Field("username")username: String,
        @Field("password") password: String,
        @Field("do_logout") do_logout: String,
        @Field("push_id") push_id: String
    ): Observable<LoginResponse>


    @GET
    fun GET_ADDRESS(@Url s: String?): Observable<PlacesResponse>

}