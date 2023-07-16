package com.lionheart.presentation.challenge

import com.lionheart.databinding.ItemChallengeAttendanceBinding
import com.lionheart.domain.entity.AttendancesType

class AttendanceViewHolder(private val binding: ItemChallengeAttendanceBinding) :
    ChallengeViewHolder(binding.root) {
    override fun onBind(data: AttendancesType) {
        binding.data = data
    }
}
