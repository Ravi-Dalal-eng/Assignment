package com.messaging.urvarassignment

import android.R
import android.os.Binder
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.messaging.urvarassignment.adapters.TabLayoutAdapter
import com.messaging.urvarassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tablayout.addTab(binding.tablayout.newTab().setText("charcha"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("bazaar"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("profile"))
        binding.tablayout.setTabGravity(TabLayout.GRAVITY_FILL)

        val adapter = TabLayoutAdapter(this, supportFragmentManager, binding.tablayout.getTabCount())
        binding.viewPager.setAdapter(adapter)
        binding.viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tablayout))

        binding.tablayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.setCurrentItem(tab.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}