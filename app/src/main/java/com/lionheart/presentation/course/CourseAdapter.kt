package com.lionheart.presentation.course

import android.graphics.Color
import android.util.SparseBooleanArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Slide
import androidx.transition.TransitionManager
import com.lionheart.R
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemCourseMonthBinding
import com.lionheart.databinding.ItemCourseWeekBinding
import com.lionheart.domain.entity.Course
import com.lionheart.domain.entity.MonthlyCourse
import com.lionheart.domain.entity.SearchCategory
import com.lionheart.domain.entity.WeeklyCourse

class CourseAdapter(private val list: List<Course>, private val onClickItem: (Long, String) -> Unit) :
    ListAdapter<WeeklyCourse, RecyclerView.ViewHolder>(diffUtil) {
    private val courseState = SparseBooleanArray()

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
                (holder as CourseMonthViewHolder).onBind(list[position].getData())
            }

            TYPE_WEEK -> {
                (holder as CourseWeekViewHolder).onBind(list[position].getData(), courseState, onClickItem)
            }

            else -> throw IllegalArgumentException("view type not found")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].getType()) {
            0 -> TYPE_MONTH
            else -> TYPE_WEEK
        }
    }

    override fun getItemCount(): Int = list.size

    companion object {
        const val TYPE_MONTH = 0
        const val TYPE_WEEK = 1

        private val diffUtil = ItemDiffCallback<WeeklyCourse>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new },
        )
    }
}

class CourseMonthViewHolder(private val binding: ItemCourseMonthBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: Course.CourseData) {
        binding.data = data as MonthlyCourse.MonthlyCourseData
    }
}

class CourseWeekViewHolder(private val binding: ItemCourseWeekBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: Course.CourseData, courseStatus: SparseBooleanArray, onClickItem: (Long, String) -> Unit) {
        binding.data = data as WeeklyCourse.WeeklyCourseData
        if (courseStatus[position]) {
            openCard()
        } else {
            closeCard()
        }
        binding.layoutCourseThumbnailFixed.setOnClickListener {
            if (binding.layoutCourseThumbnailHidden.visibility == View.VISIBLE) {
                courseStatus.put(position, false)
                closeCard()
            } else {
                courseStatus.put(position, true)
                openCard()
            }
        }
        // 커리큘럼 상세로 이동
        binding.btnToDetail.setOnClickListener {
            onClickItem(data.week, data.image)
        }
    }

    private fun openCard() {
        with(binding) {
            layoutCourseThumbnailHidden.visibility = View.VISIBLE
            tvWeek.setTextColor(Color.parseColor("#FF2D64"))
            btnDownArrow.setImageResource(R.drawable.ic_course_arrow_up)
        }
    }

    private fun closeCard() {
        binding.layoutCourseThumbnailHidden.visibility = View.GONE
        binding.tvWeek.setTextColor(Color.parseColor("#8E8E8E"))
        binding.btnDownArrow.setImageResource(R.drawable.ic_course_arrow_down)
    }
}
