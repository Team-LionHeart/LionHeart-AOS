package com.lionheart.presentation.search

import androidx.lifecycle.ViewModel
import com.lionheart.R
import com.lionheart.domain.entity.SearchCategory

class SearchViewModel : ViewModel() {
    val categoryList = listOf<SearchCategory>(
        SearchCategory(
            R.drawable.ic_search_budget,
            "예산",
        ),
        SearchCategory(
            R.drawable.ic_search_physical_change,
            "신체 변화",
        ),
        SearchCategory(
            R.drawable.ic_search_marital_relationship,
            "부부 관계",
        ),
        SearchCategory(
            R.drawable.ic_search_hospital_information,
            "병원 정보",
        ),
        SearchCategory(
            R.drawable.ic_search_support_system,
            "지원 제도",
        ),
        SearchCategory(
            R.drawable.ic_search_prenatal_education,
            "태교",
        ),
        SearchCategory(
            R.drawable.ic_search_layette,
            "아기 용품",
        ),
        SearchCategory(
            R.drawable.ic_search_father_tip,
            "아빠들의 팁",
        ),
    )
}
