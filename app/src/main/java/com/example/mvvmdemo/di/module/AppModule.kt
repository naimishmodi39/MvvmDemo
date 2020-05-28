package com.example.mvvmdemo.di.module

import android.app.Application
import android.content.Context
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.mvvmdemo.data.local.AppDataManager
import com.example.mvvmdemo.data.local.DataManager
import com.example.mvvmdemo.data.local.prefs.AppPreferencesHelper
import com.example.mvvmdemo.data.local.prefs.PreferencesHelper
import com.example.mvvmdemo.data.local.remote.ApiEndPoint
import com.example.mvvmdemo.data.local.remote.ApiHelper
import com.example.mvvmdemo.di.PreferenceInfo
import com.example.mvvmdemo.utils.AppContants
import com.example.mvvmdemo.utils.rx.AppSchedulerProvider
import com.example.mvvmdemo.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
open class AppModule {


    @Provides
    @Singleton
    fun provideApiHelper(retrofit: Retrofit):ApiHelper{
        return retrofit.create(ApiHelper::class.java)
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val intersapter = HttpLoggingInterceptor()
        intersapter.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(intersapter).cache(cache).build()
        client.newBuilder()
            .writeTimeout(180, TimeUnit.SECONDS)
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .addInterceptor { chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url
                    val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("user_lang", Locale.getDefault().language)
                        .addQueryParameter("app_version", "v3/")
                        .addQueryParameter("user_role", "")
                        .addQueryParameter("device_type", "1")
                        .build()
                    val requestBuilder = original.newBuilder().url(url)
                        .addHeader("session_id", "")
                    val request = requestBuilder.build()
                    chain.proceed(request)
            }
        return client
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiEndPoint.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun cache(context: Context): Cache {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir!!, cacheSize)
        return myCache
    }

    @Provides
    @PreferenceInfo
    open fun providePreferenceName(): String {
        return AppContants.PREF_NAME
    }


    @Provides
    @Singleton
    fun providerPreferenceHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun providerDataManager(mAppDataManager: AppDataManager): DataManager{
        return mAppDataManager
    }
}