package com.lionheart.presentation.search

import androidx.lifecycle.ViewModel
import com.lionheart.R

class SearchViewModel : ViewModel() {
    val categoryList = listOf<Int>(
        R.drawable.ic_search_budget,
        R.drawable.ic_search_physical_change,
        R.drawable.ic_search_marital_relationship,
        R.drawable.ic_search_hospital_treatment,
        R.drawable.ic_search_support_system,
        R.drawable.ic_search_prenatal_education,
        R.drawable.ic_search_layette,
        R.drawable.ic_search_brink_childbirth,
    )
}
