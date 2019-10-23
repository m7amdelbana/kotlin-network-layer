package com.m7amdelbana.myapplication.network.endpoint.auth

import com.m7amdelbana.myapplication.network.api.API.USERS_REGISTER
import com.m7amdelbana.myapplication.network.model.SignForm
import com.m7amdelbana.myapplication.network.model.Token
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST(USERS_REGISTER)
    fun register(@Body signForm: SignForm): Single<Token>
}