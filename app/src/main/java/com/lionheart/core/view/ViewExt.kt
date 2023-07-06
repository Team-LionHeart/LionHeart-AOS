package com.lionheart.core.view

import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.DiffUtil
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

// 화면 전체
fun View.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}
// 해당 뷰 위로 올릴 때 (바텀내비 등...)
fun View.showSnackbar(message: String, anchor: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).setAnchorView(anchor).show()
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.hideKeyboard() {
    try {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    } catch (e: Exception) {
        Timber.e(e.message.toString())
    }
}