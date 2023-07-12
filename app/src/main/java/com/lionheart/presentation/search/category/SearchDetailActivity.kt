package com.lionheart.presentation.search.category

import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.intent.getParcelable
import com.lionheart.databinding.ActivitySearchDetailBinding
import com.lionheart.domain.entity.SearchCategory
import com.lionheart.presentation.search.SearchFragment.Companion.SEARCH_CATEGORY

class SearchDetailActivity :
    BindingActivity<ActivitySearchDetailBinding>(R.layout.activity_search_detail) {
    private val viewModel by viewModels<SearchDetailViewModel>()
    private var searchDetailAdapter: SearchDetailAdapter? = null
    private var searchDetailTitleAdapter: SearchDetailTitleAdapter? = null

    override fun constructLayout() {
        super.constructLayout()

        initAdapter()
    }

    private fun initAdapter() {
        val searchCategory = intent.getParcelable(SEARCH_CATEGORY, SearchCategory::class.java)
        searchDetailAdapter = SearchDetailAdapter()
        searchCategory?.let {
            searchDetailTitleAdapter = SearchDetailTitleAdapter(it)
        }
        getSearchDetail()

        binding.rvSearchDetailArticle.adapter =
            ConcatAdapter(searchDetailTitleAdapter, searchDetailAdapter)
    }

    private fun getSearchDetail() {
        searchDetailAdapter?.submitList(viewModel.mockArticleList)
    }
}
