package com.m7amdelbana.myapplication.util

import android.app.Activity
import android.app.AlertDialog
import com.m7amdelbana.myapplication.R

object ErrorDialog {

    private var alert: AlertDialog? = null

    fun show(message: String? = "Something went wrong!", activity: Activity) {
        activity.runOnUiThread {
            val dialog = AlertDialog.Builder(activity)
            dialog.setTitle(activity.getString(R.string.error))
            dialog.setMessage(message)
            dialog.setCancelable(false)
            dialog.setPositiveButton(activity.getString(R.string.ok))
            { _, _ -> alert!!.dismiss() }

            alert = dialog.create()
            alert!!.show()
        }
    }
}