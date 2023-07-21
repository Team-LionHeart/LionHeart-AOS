package com.lionheart.presentation.today

import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.FragmentTodayBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class TodayFragment : BindingFragment<FragmentTodayBinding>(R.layout.fragment_today) {
    private val viewModel by viewModels<TodayViewModel>()
    override fun addListeners() {
        getTodayArticleState()
    }

    override fun addObservers() {
    }

    private fun getTodayArticleState() {
        viewModel.getTodayArticleState.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getTodayArticleState").d(event.code.toString())
                }

                is Success -> {
                    binding.data = event.data
                }
            }
        }.launchIn(lifecycleScope)
    }
}
