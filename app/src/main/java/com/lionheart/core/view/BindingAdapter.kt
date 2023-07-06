package com.lionheart.core.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imgUrl: String?) {
        view.load(imgUrl)
    }
}