package com.lionheart.presentation.search.category

import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivitySearchDetailBinding

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
        searchDetailAdapter = SearchDetailAdapter()
        searchDetailTitleAdapter = SearchDetailTitleAdapter()
        getSearchDetail()

        binding.rvSearchDetailArticle.adapter = ConcatAdapter(searchDetailTitleAdapter, searchDetailAdapter)
    }

    private fun getSearchDetail() {
        searchDetailAdapter?.submitList(viewModel.mockArticleList)
    }
}
