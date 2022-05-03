package com.arcadiustech.rootcheckr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.arcadiustech.rootcheckr.adapter.PagerAdapter
import com.arcadiustech.rootcheckr.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, index ->
            tab.text = resources.getStringArray(R.array.tabs)[index]
        }.attach()

        supportActionBar?.elevation = 0F
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}