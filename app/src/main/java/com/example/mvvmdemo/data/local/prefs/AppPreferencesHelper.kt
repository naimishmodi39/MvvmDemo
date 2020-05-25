package com.example.mvvmdemo.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.Nullable
import com.example.mvvmdemo.di.PreferenceInfo
import javax.inject.Inject

open class AppPreferencesHelper @Inject constructor(
    @Nullable context: Context,
    @PreferenceInfo prefFileName: String?
) : PreferencesHelper {



    var mPrefs: SharedPreferences? = null

    private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

    private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"

    private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"

    private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"

    private val PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL"

    


    override fun getAccessToken(): String {
        return mPrefs!!.getString(PREF_KEY_ACCESS_TOKEN, "").toString()
    }

    override fun setAccessToken(accessToken: String) {
        mPrefs!!.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
    }


    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }


}