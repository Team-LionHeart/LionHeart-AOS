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

class SearchDetailAdapter :
    ListAdapter<Article, SearchDetailAdapter.SearchDetailViewHolder>(diffUtil) {
    private val bookmarkStatus = SparseBooleanArray()

    class SearchDetailViewHolder(private val binding: ItemSearchDetailArticleBinding) :
        ViewHolder(binding.root) {
        fun onBind(data: Article, bookmarkStatus: SparseBooleanArray) {
            binding.data = data
            ivSearchDetailThumbnail.load(data.mainImageUrl)
            bookmarkStatus.put(position, data.isMarked)
            initBookmark(data, bookmarkStatus)
        }

        private fun initBookmark(data: Article, bookmarkStatus: SparseBooleanArray) {
            with(binding) {
                ivSearchDetailBookmark.isSelected = data.isMarked
                ivSearchDetailBookmark.setOnClickListener {
                    bookmarkStatus.put(position, ivSearchDetailBookmark.isSelected)
                    ivSearchDetailBookmark.isSelected = ivSearchDetailBookmark.isSelected.not()
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
        holder.onBind(getItem(position), bookmarkStatus)
    }

    companion object {
        private val diffUtil = ItemDiffCallback<Article>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
