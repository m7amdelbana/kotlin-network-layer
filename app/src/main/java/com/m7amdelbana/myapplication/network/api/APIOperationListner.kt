package com.m7amdelbana.myapplication.network.api

interface APIOperationListener {

    fun onSuccess(requestId: Int, response: Any)
    fun onError(requestId: Int, error: APIError)
}

