package com.lionheart.presentation.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemBookmarkArticleBinding
import com.lionheart.domain.entity.BookmarkArticle

class BookmarkArticleAdapter(
    private val onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
    private val onClickArticle: (articleId: Int) -> Unit
) : ListAdapter<BookmarkArticle.ArticleSummary, BookmarkArticleViewHolder>(
    itemBookmarkArticleDiffUtil,
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkArticleViewHolder {
        return BookmarkArticleViewHolder(
            ItemBookmarkArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: BookmarkArticleViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClickArticle(getItem(position).articleId.toInt())
        }
        holder.onBind(getItem(position), onClickBookmark)
    }

    companion object {
        private val itemBookmarkArticleDiffUtil = ItemDiffCallback<BookmarkArticle.ArticleSummary>(
            onContentsTheSame = { old, new -> old.title == new.title },
            onItemsTheSame = { old, new -> old == new },
        )
    }
}

class BookmarkArticleViewHolder(private val binding: ItemBookmarkArticleBinding) :
    ViewHolder(binding.root) {
    fun onBind(
        article: BookmarkArticle.ArticleSummary,
        onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
    ) {
        with(binding) {
            data = article
            ivBookmarkBookmarkButton.isSelected = article.isMarked
            ivBookmarkBookmarkButton.setOnClickListener {
                onClickBookmark(article.articleId, ivBookmarkBookmarkButton.isSelected.not())
                ivBookmarkBookmarkButton.isSelected = ivBookmarkBookmarkButton.isSelected.not()
            }
        }
    }
}
