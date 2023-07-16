package com.lionheart.presentation.challenge

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lionheart.domain.entity.AttendancesType

abstract class ChallengeViewHolder(view: View) : ViewHolder(view) {
    abstract fun onBind(data: AttendancesType)
}
