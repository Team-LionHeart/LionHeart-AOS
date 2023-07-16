package com.lionheart.presentation.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lionheart.databinding.ItemCourseDetailHeaderBinding
import com.lionheart.domain.entity.CourseWeek

class CourseDetailTitleAdapter(
    private val week: CourseWeek
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCourseDetailHeaderBinding.inflate(inflater, parent, false)
        return CourseDetailTitleViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CourseDetailTitleViewHolder).onBind(week)
    }

}

class CourseDetailTitleViewHolder(private val binding: ItemCourseDetailHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CourseWeek) {
        binding.data = data
    }
}