package com.capstone.signargi.ui.welcome

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.capstone.signargi.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Welcome1Activity : AppCompatActivity(), WelcomeFragmentListener { // ✅ IMPLEMENT INTERFACE
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome1)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        viewPager.adapter = WelcomeAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            Log.d("TabMediator", "Tab $position linked")
        }.attach()
    }

    override fun nextPage() { // ✅ DIPANGGIL DARI FRAGMENT
        val nextItem = viewPager.currentItem + 1
        if (nextItem < (viewPager.adapter?.itemCount ?: 0)) {
            viewPager.currentItem = nextItem
        }
    }
}

//    private fun setupAction() {
//        binding.loginButton.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
//
//        binding.signupButton.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//        }
//    }
interface WelcomeFragmentListener {
    fun nextPage()
}