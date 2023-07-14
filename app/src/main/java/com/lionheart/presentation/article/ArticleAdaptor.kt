package com.lionheart.presentation.article

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lionheart.LionUnKnownException
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemArticleBodyBinding
import com.lionheart.databinding.ItemArticleChaptorTitleBinding
import com.lionheart.databinding.ItemArticleEditorNoteBinding
import com.lionheart.databinding.ItemArticleGeneralTitleBinding
import com.lionheart.databinding.ItemArticleImageBinding
import com.lionheart.domain.entity.ArticleComponent
import com.lionheart.domain.entity.ArticleComponentType

class ArticleAdaptor : ListAdapter<ArticleComponent, ArticleViewHolder>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old == new },
    onContentsTheSame = { old, new -> old == new }
)) {
    private lateinit var components: MutableList<ArticleComponent>
    private lateinit var inflater: LayoutInflater

    override fun getItemViewType(position: Int): Int = components[position].type

    override fun submitList(list: MutableList<ArticleComponent>?) {
        super.submitList(list)
        this.components = list ?: mutableListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        inflater = parent.context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater

        when (viewType) {
            ArticleComponentType.EDITOR_NOTE.id -> {
                return EditorNoteViewHolder(
                    ItemArticleEditorNoteBinding.inflate(
                        layoutInflaterFromParent(parent.context),
                        parent,
                        false
                    )
                )
            }

            ArticleComponentType.CHAPTER_TITLE.id -> {
                return ChapterTitleViewHolder(
                    ItemArticleChaptorTitleBinding.inflate(
                        layoutInflaterFromParent(parent.context),
                        parent,
                        false
                    )
                )
            }

            ArticleComponentType.BODY.id -> {
                return BodyViewHolder(
                    ItemArticleBodyBinding.inflate(
                        layoutInflaterFromParent(parent.context),
                        parent,
                        false
                    )
                )
            }

            ArticleComponentType.GENERAL_TITLE.id -> {
                return GeneralTitleViewHolder(
                    ItemArticleGeneralTitleBinding.inflate(
                        layoutInflaterFromParent(parent.context),
                        parent,
                        false
                    )
                )
            }

            ArticleComponentType.IMAGE.id -> {
                return ImageViewHolder(
                    ItemArticleImageBinding.inflate(
                        layoutInflaterFromParent(
                            parent.context
                        ), parent, false
                    )
                )
            }

            else -> throw LionUnKnownException("알 수 없는 오류가 발생헀습니다.")
        }
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.onBind(components[position])
    }

    private fun layoutInflaterFromParent(context: Context) = LayoutInflater.from(context)
}