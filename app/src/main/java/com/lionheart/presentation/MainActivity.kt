package com.lionheart.presentation

import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityMainBinding
import com.lionheart.presentation.bookmark.BookMarkActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var navController: NavController

    override fun constructLayout() {
        initBottomNavigation()
    }

    override fun addListeners() {
        intentToBookmark()
    }

    private fun initBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)
    }

    private fun intentToBookmark() {
        val intent = Intent(this, BookMarkActivity::class.java)
        binding.ivMainBookmark.setOnClickListener {
            startActivity(intent)
        }
    }
}
