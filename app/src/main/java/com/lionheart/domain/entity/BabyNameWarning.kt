package com.lionheart.domain.entity

import com.lionheart.R

enum class BabyNameWarning(val id: Int, val message: String, val color: Int) {
    GUIDE(id = 0, message = "최대 10자 입력", color = R.color.gray_500),
    OVER_TEN(id = 1, message = "10자 이내로 입력해주세요", color = R.color.component_lion_red),
    NO_INPUT(id = 2, message = "입력된 내용이 없습니다", color = R.color.component_lion_red)
}