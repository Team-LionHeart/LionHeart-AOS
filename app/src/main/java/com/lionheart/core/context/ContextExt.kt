package com.lionheart.core.context

import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.stringOf(@StringRes resId: Int) = getString(resId)
fun Context.colorOf(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)
fun Context.drawableOf(@DrawableRes resId: Int) = ContextCompat.getDrawable(this, resId)

