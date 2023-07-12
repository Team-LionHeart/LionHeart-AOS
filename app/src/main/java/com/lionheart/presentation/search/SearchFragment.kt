package com.lionheart.presentation.search

import android.content.Intent
import androidx.fragment.app.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentSearchBinding
import com.lionheart.domain.entity.SearchCategory
import com.lionheart.presentation.search.category.SearchDetailActivity

class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val viewModel by viewModels<SearchViewModel>()
    private var searchCategoryAdapter: SearchCategoryAdapter? = null

    override fun constructLayout() {
        initAdapter()
    }

    private fun initAdapter() {
        searchCategoryAdapter =
            SearchCategoryAdapter { searchCategory -> intentToSearchDetail(searchCategory) }

        searchCategoryAdapter?.submitList(viewModel.categoryList)

        binding.rvSearchCategory.adapter = searchCategoryAdapter
    }

    private fun intentToSearchDetail(searchCategory: SearchCategory) {
        val intent = Intent(activity, SearchDetailActivity::class.java)
        intent.putExtra(SEARCH_CATEGORY, searchCategory)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        searchCategoryAdapter = null
    }

    companion object {
        const val SEARCH_CATEGORY = "searchCategory"
    }
}
