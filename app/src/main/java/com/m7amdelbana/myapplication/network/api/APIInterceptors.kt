package com.m7amdelbana.myapplication.network.api

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .removeHeader("User-Agent")
                .addHeader("time-zone", TimeZone.getDefault().id)
                .build()
        )
    }
}