package com.example.mvvmdemo.data.local.prefs

public interface PreferencesHelper {

    fun getAccessToken():String

    fun setAccessToken(accessToken:String)

}