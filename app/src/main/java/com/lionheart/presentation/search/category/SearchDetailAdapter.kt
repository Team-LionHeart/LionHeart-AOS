package com.lionheart.presentation.search.category

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
    class SearchDetailViewHolder(private val binding: ItemSearchDetailArticleBinding) :
        ViewHolder(binding.root) {
        fun onBind(data: Article) {
            binding.data = data
            binding.ivSearchDetailThumbnail.load(data.mainImageUrl)
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
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<Article>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
