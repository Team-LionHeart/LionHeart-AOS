package com.lionheart.presentation.search

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentSearchBinding

class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val viewModel by viewModels<SearchViewModel>()
    private var searchCategoryAdapter: SearchCategoryAdapter? = null

    override fun constructLayout() {
        initAdapter()
    }

    private fun initAdapter() {
        searchCategoryAdapter = SearchCategoryAdapter()

        searchCategoryAdapter?.submitList(viewModel.categoryList)

        binding.rvSearchCategory.adapter = searchCategoryAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        searchCategoryAdapter = null
    }
}
