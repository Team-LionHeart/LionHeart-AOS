package com.lionheart.presentation.challenge

import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentChallengeBinding
import com.lionheart.domain.entity.AttendancesType
import com.lionheart.domain.entity.Challenge
import com.lionheart.domain.entity.ChallengeAttendancesType
import java.lang.RuntimeException

class ChallengeFragment : BindingFragment<FragmentChallengeBinding>(R.layout.fragment_challenge) {
    private var challengeAdapter: ChallengeAdapter? = null

    private var challenge = Challenge(
        mutableListOf(
            AttendancesType("07/14", ChallengeAttendancesType.ATTEANDANCES),
            AttendancesType("07/15", ChallengeAttendancesType.ATTEANDANCES),
            AttendancesType("07/17", ChallengeAttendancesType.ATTEANDANCES),
        ),
        "사랑이",
        3,
        "LEVEL_THREE",
    )

    override fun constructLayout() {
        binding.data = challenge

        initLevel()
        initAdapter()
    }

    private fun initAdapter() {
        challengeAdapter = ChallengeAdapter()

        challengeAdapter?.submitList(challenge.asFullList())

        binding.rvChallengeDate.adapter = challengeAdapter
    }

    private fun initLevel() {
        with(binding) {
            when (challenge.level) {
                "LEVEL_ONE" -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_1)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_1)
                    tvChallengeLevel.text = "Lv.1"
                }
                "LEVEL_TWO" -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_2)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_2)
                    tvChallengeLevel.text = "Lv.2"
                }
                "LEVEL_THREE" -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_3)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_3)
                    tvChallengeLevel.text = "Lv.3"
                }
                "LEVEL_FOUR" -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_4)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_4)
                    tvChallengeLevel.text = "Lv.4"
                }
                "LEVEL_FIVE" -> {
                    lottieChallengeProgressbar.setAnimation(R.raw.challenge_level_5)
                    ivChallengeBadge.setImageResource(R.drawable.ic_challenge_level_5)
                    tvChallengeLevel.text = "Lv.5"
                }
                else -> throw RuntimeException("알 수 없는 에러 발생")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        challengeAdapter = null
    }
}
