package com.lionheart.presentation.article

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lionheart.domain.entity.ArticleComponent

abstract class ArticleViewHolder(componentView: View) :
    RecyclerView.ViewHolder(componentView) {
    abstract fun onBind(articleComponent: ArticleComponent)
}