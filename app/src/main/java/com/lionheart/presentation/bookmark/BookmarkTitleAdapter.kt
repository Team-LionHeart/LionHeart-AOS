package com.lionheart.presentation.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemBookmarkTitleBinding

class BookmarkTitleAdapter : ListAdapter<String, BookmarkTitleViewHolder>(bookmarkDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkTitleViewHolder {
        return BookmarkTitleViewHolder(
            ItemBookmarkTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: BookmarkTitleViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val bookmarkDiffUtil = ItemDiffCallback<String>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}

class BookmarkTitleViewHolder(private val binding: ItemBookmarkTitleBinding) :
    ViewHolder(binding.root) {
    fun onBind(title: String) {
        binding.tvBookmarkTitle.text = "$title 아빠님이\n보관한 아티클이에요"
    }
}
