package com.lionheart.presentation

import android.content.Intent
import androidx.fragment.app.Fragment
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityMainBinding
import com.lionheart.presentation.bookmark.BookMarkActivity
import com.lionheart.presentation.challenge.ChallengeFragment
import com.lionheart.presentation.course.CourseFragment
import com.lionheart.presentation.search.SearchFragment
import com.lionheart.presentation.today.TodayFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun constructLayout() {
        initBottomNavigation()
    }

    override fun addListeners() {
        intentToBookmark()
    }

    private fun initBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.today_fragment -> this.changeFragment(TodayFragment())
                R.id.search_fragment -> this.changeFragment(SearchFragment())
                R.id.course_fragment -> this.changeFragment(CourseFragment())
                else -> this.changeFragment(ChallengeFragment())
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fcv_main, fragment).commit()
    }

    private fun intentToBookmark() {
        val intent = Intent(this, BookMarkActivity::class.java)
        binding.ivMainBookmark.setOnClickListener {
            startActivity(intent)
        }
    }
}
