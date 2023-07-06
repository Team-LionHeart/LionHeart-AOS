package com.lionheart.core.fragment

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

// 화면 전체
fun Fragment.showSnackbar(view: View, message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(view, message, duration).show()
}
// 해당 뷰 위로 올릴 때 (바텀내비 등...)
fun Fragment.showSnackbar(view: View, message: String, anchor: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(view, message, duration).setAnchorView(anchor).show()
}

fun Fragment.stringOf(@StringRes resId: Int) = getString(resId)
fun Fragment.colorOf(@ColorRes resId: Int) = ContextCompat.getColor(requireContext(), resId)
fun Fragment.drawableOf(@DrawableRes resId: Int) = ContextCompat.getDrawable(requireContext(), resId)