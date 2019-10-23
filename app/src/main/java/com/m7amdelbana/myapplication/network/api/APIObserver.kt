package com.m7amdelbana.myapplication.network.api

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

object APIObserver {

    fun <T> getObserver(requestId: Int, listener: APIOperationListener)
            : SingleObserver<T> {
        return object : SingleObserver<T> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onSuccess(t: T) {
                listener.onSuccess(requestId, t as Any)
            }

            override fun onError(e: Throwable) {
                listener.onError(requestId, APIError(e))
            }
        }
    }
}