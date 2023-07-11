package com.lionheart.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.databinding.ItemSearchTitleBinding

class SearchCategoryTitleAdapter :
    Adapter<SearchCategoryTitleAdapter.SearchCategoryTitleViewHolder>() {
    class SearchCategoryTitleViewHolder(private val binding: ItemSearchTitleBinding) :
        ViewHolder(binding.root) {
        fun onBind() {
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchCategoryTitleViewHolder {
        return SearchCategoryTitleViewHolder(
            ItemSearchTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: SearchCategoryTitleViewHolder, position: Int) {
        holder.onBind()
    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int,
//    ): SearchCategoryTitleViewHolder {
//        return SearchCategoryTitleViewHolder(
//            ItemSearchTitleBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false,
//            ),
//        )
//    }
//
//    override fun onBindViewHolder(holder: SearchCategoryTitleViewHolder, position: Int) {
//        holder.onBind()
//    }
//
//    companion object {
//        private val diffUtil = ItemDiffCallback<Unit>(
//            onContentsTheSame = { old, new -> old == new },
//            onItemsTheSame = { old, new -> old == new },
//        )
//    }
}
