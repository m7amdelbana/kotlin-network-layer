package com.m7amdelbana.myapplication.network.endpoint.auth

import com.m7amdelbana.myapplication.network.api.APIOperationListener
import com.m7amdelbana.myapplication.network.model.SignForm

object AuthRepository {

    var authExecutor: AuthExecutor? = null

    fun register(requestId: Int, signForm: SignForm, listener: APIOperationListener) {
        authExecutor = AuthExecutor()
        authExecutor!!.register(requestId, signForm, listener)
    }
}