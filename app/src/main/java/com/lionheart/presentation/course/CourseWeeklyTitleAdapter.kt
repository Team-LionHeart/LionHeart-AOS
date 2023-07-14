package com.lionheart.presentation.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lionheart.databinding.ItemCourseWeeklyHeaderBinding
import com.lionheart.domain.entity.CourseWeek

class CourseWeeklyTitleAdapter(
    private val week: CourseWeek
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCourseWeeklyHeaderBinding.inflate(inflater, parent, false)
        return CourseWeeklyTitleViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CourseWeeklyTitleViewHolder).onBind(week)
    }

}

class CourseWeeklyTitleViewHolder(private val binding: ItemCourseWeeklyHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CourseWeek) {
        binding.data = data
    }
}