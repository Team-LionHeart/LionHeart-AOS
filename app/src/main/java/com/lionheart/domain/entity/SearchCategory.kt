package com.lionheart.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchCategory(
    val img: Int,
    val name: String,
    val serverName: String,
    val mainTitle: String,
    val subTitle: String,
) : Parcelable
