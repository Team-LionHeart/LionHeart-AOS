package com.lionheart.presentation.article

import com.lionheart.databinding.ItemArticleEditorNoteBinding
import com.lionheart.domain.entity.ArticleComponent

class EditorNoteViewHolder(private val componentBinding: ItemArticleEditorNoteBinding) :
    ArticleViewHolder(componentBinding.root) {
    override fun onBind(articleComponent: ArticleComponent) {
        with(componentBinding) {
            component = articleComponent
        }
    }
}