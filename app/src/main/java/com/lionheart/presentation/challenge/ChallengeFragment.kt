package com.lionheart.presentation.challenge

import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.FragmentChallengeBinding
import com.lionheart.domain.entity.Level
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import java.lang.RuntimeException

@AndroidEntryPoint
class ChallengeFragment : BindingFragment<FragmentChallengeBinding>(R.layout.fragment_challenge) {
    private var challengeAdapter: ChallengeAdapter? = null
    private val viewModel by viewModels<ChallengeViewModel>()

    override fun constructLayout() {
        viewModel.getChallengeProgress()
        initAdapter()
        getChallenge()
    }

    private fun getChallenge() {
        viewModel.getProgress.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getChallenge error").d(event.code.toString())
                }

                is Success -> {
                    binding.data = event.data
                    challengeAdapter?.submitList(event.data.asFullList())
                    initLevel(event.data.level)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun initAdapter() {
        challengeAdapter = ChallengeAdapter()

        binding.rvChallengeDate.adapter = challengeAdapter
    }

    private fun initLevel(level: Level) {
        with(binding) {
            when (level) {
                Level.LEVEL_ONE -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_1)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_1)
                    tvChallengeLevel.text = "Lv.1"
                }

                Level.LEVEL_TWO -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_2)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_2)
                    tvChallengeLevel.text = "Lv.2"
                }

                Level.LEVEL_THREE -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_3)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_3)
                    tvChallengeLevel.text = "Lv.3"
                }

                Level.LEVEL_FOUR -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_4)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_4)
                    tvChallengeLevel.text = "Lv.4"
                }

                Level.LEVEL_FIVE -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_5)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_5)
                    tvChallengeLevel.text = "Lv.5"
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        challengeAdapter = null
    }
}
