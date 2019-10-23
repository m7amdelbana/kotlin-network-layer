package com.m7amdelbana.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.m7amdelbana.myapplication.network.api.APIError
import com.m7amdelbana.myapplication.network.api.APIOperationListener
import com.m7amdelbana.myapplication.network.endpoint.auth.AuthRepository
import com.m7amdelbana.myapplication.network.model.SignForm
import com.m7amdelbana.myapplication.network.model.Token
import com.m7amdelbana.myapplication.util.ErrorDialog
import com.m7amdelbana.myapplication.util.LoadingDialog

class MainActivity : AppCompatActivity(), APIOperationListener {

    private var loadingDialog: LoadingDialog? = null

    private val REQUEST_REGSITER: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingDialog = LoadingDialog(this)

        createFakeRequest()
    }

    private fun createFakeRequest() {
        loadingDialog!!.show()
        AuthRepository.register(
            REQUEST_REGSITER,
            SignForm(
                firstName = "Mohamed",
                lastName = "Elbana",
                email = "user@gmail.com",
                phone = "01234445566",
                password = "123456"
            ), this
        )
    }

    override fun onSuccess(requestId: Int, response: Any) {
        loadingDialog!!.hide()
        when (requestId) {
            REQUEST_REGSITER -> {
                val token: Token = response as Token
                Toast.makeText(
                    this,
                    token.accessToken,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onError(requestId: Int, error: APIError) {
        loadingDialog!!.hide()
        when (requestId) {
            REQUEST_REGSITER -> ErrorDialog.show(error.mesage, this)
        }
    }
}
