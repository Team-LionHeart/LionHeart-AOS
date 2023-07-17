package com.lionheart.domain.entity

import android.os.Parcelable
import com.lionheart.presentation.search.category.ArticleCategory
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchCategory(
    val img: Int,
    val name: String,
    val serverName: ArticleCategory,
    val mainTitle: String,
    val subTitle: String,
) : Parcelable
