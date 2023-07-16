package com.lionheart.presentation.challenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemChallengeAttendanceBinding
import com.lionheart.databinding.ItemChallengeDateBinding
import com.lionheart.domain.entity.AttendancesType
import com.lionheart.domain.entity.ChallengeAttendancesType
import java.lang.RuntimeException

class ChallengeAdapter : ListAdapter<AttendancesType, ChallengeViewHolder>(diffUtil) {

    override fun getItemViewType(position: Int) = getItem(position).type.id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        when (viewType) {
            ChallengeAttendancesType.DAY.id -> {
                return DateViewHolder(
                    ItemChallengeDateBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    ),
                )
            }

            ChallengeAttendancesType.ATTEANDANCES.id -> {
                return AttendanceViewHolder(
                    ItemChallengeAttendanceBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    ),
                )
            }

            else -> throw RuntimeException("알 수 없는 에러 발생")
        }
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<AttendancesType>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
