package com.m7amdelbana.myapplication.network.endpoint.auth

import com.m7amdelbana.myapplication.network.api.APIObserver
import com.m7amdelbana.myapplication.network.api.ApiClient
import com.m7amdelbana.myapplication.network.api.APIOperationListener
import com.m7amdelbana.myapplication.network.model.SignForm
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthExecutor {

    fun register(requestId: Int, signForm: SignForm, listener: APIOperationListener) {
        val authService = ApiClient.client!!.create(
            AuthService::class.java
        )
        val observable = authService.register(signForm)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(APIObserver.getObserver(requestId, listener))
    }
}
