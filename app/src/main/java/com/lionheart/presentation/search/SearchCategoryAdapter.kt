package com.lionheart.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemSearchCategoryBinding
import com.lionheart.domain.entity.SearchCategory

class SearchCategoryAdapter(
    private val onClickCategory: () -> Unit,
) : ListAdapter<SearchCategory, SearchCategoryAdapter.SearchCategoryViewHolder>(
    diffUtil,
) {
    class SearchCategoryViewHolder(private val binding: ItemSearchCategoryBinding) :
        ViewHolder(binding.root) {
        fun onBind(category: SearchCategory) {
            binding.ivSearchCategory.setImageResource(category.img)
            binding.tvSearchCategoryName.text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCategoryViewHolder {
        return SearchCategoryViewHolder(
            ItemSearchCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: SearchCategoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClickCategory()
        }
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<SearchCategory>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new },
        )
    }
}
