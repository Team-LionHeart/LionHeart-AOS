package com.lionheart.presentation.bookmark

import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemBookmarkArticleBinding
import com.lionheart.domain.entity.BookmarkArticle
import timber.log.Timber

class BookmarkArticleAdapter(
    private val onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
    private val onClickArticle: (articleId: Int, isMarked: Boolean) -> Unit,
) : ListAdapter<BookmarkArticle.ArticleSummary, BookmarkArticleViewHolder>(
    itemBookmarkArticleDiffUtil,
) {
    private val bookmarkStatus = SparseBooleanArray()

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
        val article = getItem(position)
        holder.itemView.setOnClickListener {
            onClickArticle(article.articleId.toInt(), article.isMarked)
        }
        holder.onBind(article, onClickBookmark, bookmarkStatus)
    }

    companion object {
        private val itemBookmarkArticleDiffUtil = ItemDiffCallback<BookmarkArticle.ArticleSummary>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new },
        )
    }
}

class BookmarkArticleViewHolder(private val binding: ItemBookmarkArticleBinding) :
    ViewHolder(binding.root) {
    fun onBind(
        article: BookmarkArticle.ArticleSummary,
        onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
        bookmarkStatus: SparseBooleanArray,
    ) {
        bookmarkStatus.put(layoutPosition, article.isMarked)
        with(binding) {
            data = article
            Log.d("뭐가 문제냐ㅁㄴ옿ㅁ;ㅓㄴㅇ롬ㄴ올", article.isMarked.toString())
            ivBookmarkBookmarkButton.isSelected = article.isMarked
            initBookmark(article, onClickBookmark, bookmarkStatus)
        }
    }

    private fun initBookmark(
        data: BookmarkArticle.ArticleSummary,
        onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
        bookmarkStatus: SparseBooleanArray,
    ) {
        with(binding) {
            ivBookmarkBookmarkButton.setOnClickListener {
                bookmarkStatus.put(position, ivBookmarkBookmarkButton.isSelected)
                ivBookmarkBookmarkButton.isSelected = ivBookmarkBookmarkButton.isSelected.not()
                onClickBookmark(data.articleId, ivBookmarkBookmarkButton.isSelected)
                data.isMarked = ivBookmarkBookmarkButton.isSelected
            }
        }
    }
}
