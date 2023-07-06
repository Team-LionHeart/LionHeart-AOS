package com.lionheart.core.intent

import android.content.Intent
import android.os.Build
import android.os.Parcelable

fun <T : Parcelable?> Intent.getParcelable(
    key: String,
    clazz: Class<T>,
): T? =
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> this.getParcelableExtra(key, clazz)
        else -> this.getParcelableExtra(key) as? T
    }