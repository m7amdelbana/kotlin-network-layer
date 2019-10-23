package com.m7amdelbana.myapplication.network.api

import com.m7amdelbana.myapplication.app.App
import com.m7amdelbana.myapplication.network.api.API.BASE_URL
import okhttp3.*
import java.util.concurrent.TimeUnit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null
    private const val CACHE_SIZE = (20 * 1024 * 1024).toLong()
    private const val REQUEST_TIME_OUT: Long = 80
    private var clientBuilder: OkHttpClient.Builder? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(clientBuilder!!.build())
                    .build()
            }
            return retrofit
        }

    init {
        clientBuilder = OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            .cache(Cache(App.context!!.cacheDir, CACHE_SIZE))
            .addInterceptor(HeaderInterceptor())
    }
}
