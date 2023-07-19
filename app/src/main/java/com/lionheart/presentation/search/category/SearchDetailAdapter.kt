package com.lionheart.presentation.search.category

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemSearchDetailArticleBinding
import com.lionheart.domain.entity.Article

class SearchDetailAdapter(
    private val onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
) : ListAdapter<Article, SearchDetailAdapter.SearchDetailViewHolder>(diffUtil) {
    private val bookmarkStatus = SparseBooleanArray()

    class SearchDetailViewHolder(private val binding: ItemSearchDetailArticleBinding) :
        ViewHolder(binding.root) {
        fun onBind(
            data: Article,
            bookmarkStatus: SparseBooleanArray,
            onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
        ) {
            binding.data = data
            binding.ivSearchDetailThumbnail.load(data.mainImageUrl)
            bookmarkStatus.put(position, data.isMarked)
            initBookmark(data, bookmarkStatus, onClickBookmark)
        }

        private fun initBookmark(
            data: Article,
            bookmarkStatus: SparseBooleanArray,
            onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
        ) {
            with(binding) {
                ivSearchDetailBookmark.isSelected = data.isMarked
                ivSearchDetailBookmark.setOnClickListener {
                    bookmarkStatus.put(position, ivSearchDetailBookmark.isSelected)
                    ivSearchDetailBookmark.isSelected = ivSearchDetailBookmark.isSelected.not()
                    onClickBookmark(data.articleId, ivSearchDetailBookmark.isSelected)
                    // 북마크 저장 작업
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDetailViewHolder {
        return SearchDetailViewHolder(
            ItemSearchDetailArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: SearchDetailViewHolder, position: Int) {
        holder.onBind(getItem(position), bookmarkStatus, onClickBookmark)
    }

    companion object {
        private val diffUtil = ItemDiffCallback<Article>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
