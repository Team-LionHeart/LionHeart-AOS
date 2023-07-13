package com.lionheart.presentation.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemCourseMonthBinding
import com.lionheart.databinding.ItemCourseWeekBinding
import com.lionheart.domain.entity.CourseWeekly
import com.lionheart.domain.entity.CourseWeeklyData

class CourseAdapter(private val list: List<CourseWeekly>) :
    ListAdapter<CourseWeeklyData, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_MONTH -> {
                val binding = ItemCourseMonthBinding.inflate(inflater, parent, false)
                CourseMonthViewHolder(binding)
            }
            TYPE_WEEK -> {
                val binding = ItemCourseWeekBinding.inflate(inflater, parent, false)
                CourseWeekViewHolder(binding)
            }
            else -> throw IllegalArgumentException("view type not found")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (getItemViewType(position)) {
            TYPE_MONTH -> {
                (holder as CourseMonthViewHolder).onBind(list[position].data)
            }
            TYPE_WEEK -> {
                (holder as CourseWeekViewHolder).onBind(list[position].data)
            }
            else -> throw IllegalArgumentException("view type not found")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            0 -> TYPE_MONTH
            else -> TYPE_WEEK
        }
    }

    override fun getItemCount() : Int = list.size

    companion object {
        const val TYPE_MONTH = 0
        const val TYPE_WEEK = 1

        private val diffUtil = ItemDiffCallback<CourseWeeklyData>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new },
        )
    }
}

class CourseMonthViewHolder(private val binding: ItemCourseMonthBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CourseWeeklyData) {
        binding.data = data
    }
}

class CourseWeekViewHolder(private val binding: ItemCourseWeekBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CourseWeeklyData) {
        binding.data = data
    }
}