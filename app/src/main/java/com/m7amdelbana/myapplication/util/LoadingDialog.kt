package com.m7amdelbana.myapplication.util

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.Log

import com.m7amdelbana.myapplication.R

import java.util.Objects

class LoadingDialog(context: Context) {

    private val dialog: Dialog?
    private val TAG = this.javaClass.name

    val isShowing: Boolean get() = dialog!!.isShowing

    init {
        dialog = Dialog(context)
    }

    fun show() {
        try {
            dialog!!.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            dialog.setContentView(R.layout.dialog_loading)
            dialog.setCancelable(true)
            if (!dialog.isShowing) dialog.show()
        } catch (e: Exception) {
            Log.v(TAG, Objects.requireNonNull(e.message))
        }
    }

    fun hide() {
        if (dialog != null) {
            try {
                dialog.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
                dialog.setCancelable(true)
            }
        }
    }

    fun setCanceledOnOutside(cancel: Boolean) {
        dialog!!.setCanceledOnTouchOutside(cancel)
    }
}