package com.lionheart.presentation.search

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentSearchBinding

class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val viewModel by viewModels<SearchViewModel>()
    private var searchCategoryTitleAdapter: SearchCategoryTitleAdapter? = null
    private var searchCategoryAdapter: SearchCategoryAdapter? = null

    override fun constructLayout() {
        initAdapter()
    }

    private fun initAdapter() {
        searchCategoryTitleAdapter = SearchCategoryTitleAdapter()
        searchCategoryAdapter = SearchCategoryAdapter()

        searchCategoryAdapter?.submitList(viewModel.categoryList)

        val gridLayoutManager = GridLayoutManager(context, 2)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 2 else 1
            }
        }

        binding.rvSearchCategory.layoutManager = gridLayoutManager

        binding.rvSearchCategory.adapter =
            ConcatAdapter(searchCategoryTitleAdapter, searchCategoryAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        searchCategoryAdapter = null
        searchCategoryTitleAdapter
    }
}
