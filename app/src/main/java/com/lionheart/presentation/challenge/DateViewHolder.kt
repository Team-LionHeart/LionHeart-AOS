package com.lionheart.presentation.challenge

import com.lionheart.databinding.ItemChallengeDateBinding
import com.lionheart.domain.entity.AttendancesType

class DateViewHolder(val binding: ItemChallengeDateBinding) : ChallengeViewHolder(binding.root) {
    override fun onBind(data: AttendancesType) {
        binding.data = data
    }
}
