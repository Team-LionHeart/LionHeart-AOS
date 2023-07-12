package com.lionheart.presentation.search.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.databinding.ItemSearchDetailTitleBinding
import com.lionheart.domain.entity.SearchCategory

class SearchDetailTitleAdapter(
    private val searchCategory: SearchCategory,
) : Adapter<SearchDetailTitleAdapter.SearchDetailTitleViewHolder>() {
    class SearchDetailTitleViewHolder(private val binding: ItemSearchDetailTitleBinding) :
        ViewHolder(binding.root) {
        fun onBind(searchCategory: SearchCategory) {
            with(binding) {
                tvSearchDetailCategory.text = searchCategory.name
                tvSearchDetailTitle.text = searchCategory.mainTitle
                tvSearchDetailSubtitle.text = searchCategory.subTitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDetailTitleViewHolder {
        return SearchDetailTitleViewHolder(
            ItemSearchDetailTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: SearchDetailTitleViewHolder, position: Int) {
        holder.onBind(searchCategory)
    }
}
