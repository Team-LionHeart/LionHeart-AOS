package com.lionheart.presentation.search

import androidx.lifecycle.ViewModel
import com.lionheart.R
import com.lionheart.domain.entity.SearchCategory
import com.lionheart.presentation.search.category.ArticleCategory

class SearchViewModel : ViewModel() {
    val categoryList = listOf<SearchCategory>(
        SearchCategory(
            R.drawable.ic_search_budget,
            "예산",
            ArticleCategory.BUDGET,
            "출산 준비,\n불필요한 지출은 그만",
            "라이온하트가 전하는 예산 절약 노하우 대공개",
        ),
        SearchCategory(
            R.drawable.ic_search_physical_change,
            "신체 변화",
            ArticleCategory.PHYSICAL_CHANGE,
            "와이프 신체 변화 미리 알고\n든든한 남편 되기",
            "라이온하트가 전하는 아내의 신체변화에 대한 모든 것",
        ),
        SearchCategory(
            R.drawable.ic_search_marital_relationship,
            "부부 관계",
            ArticleCategory.MARITAL_RELATIONSHIP,
            "똑똑한 아이를 원한다면\n사랑하세요",
            "라이온하트가 전하는 좋은 남편이 되는 방법 대공개",
        ),
        SearchCategory(
            R.drawable.ic_search_hospital_information,
            "병원 정보",
            ArticleCategory.HOSPITAL_INFORMATION,
            "산부인과는 조금 낯선\n예비 아빠들에게",
            "라이온하트가 전하는 병원 진료에 대한 모든 것",
        ),
        SearchCategory(
            R.drawable.ic_search_support_system,
            "지원 제도",
            ArticleCategory.SUPPORT_SYSTEM,
            "모르면 손해,\n임신부 혜택 똑똑하게 챙기기",
            "라이온하트가 전하는 지원 제도에 대한 모든 것",
        ),
        SearchCategory(
            R.drawable.ic_search_prenatal_education,
            "태교",
            ArticleCategory.PRENATAL_EDUCATION,
            "부담없이 편안하게\n태교하는 법",
            "라이온하트가 전하는 아이를 위하는 태교 노하우",
        ),
        SearchCategory(
            R.drawable.ic_search_layette,
            "아기 용품",
            ArticleCategory.BABY_GOODS,
            "미리미리 아기용품 준비해서\n좋은 아빠 되기",
            "라이온하트가 전하는 아기 용품에 대한 모든 것",
        ),
        SearchCategory(
            R.drawable.ic_search_father_tip,
            "아빠들의 팁",
            ArticleCategory.DAD_TIPS,
            "선배 아빠들의\n진심어린 이야기",
            "라이온하트가 예비아빠들에게 전하는 마음",
        ),
    )
}
