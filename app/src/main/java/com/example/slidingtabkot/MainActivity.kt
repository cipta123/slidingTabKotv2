package com.example.slidingtabkot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        (supportActionBar).hide()
        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        viewPager.setAdapter(
            SampleFragmentPagerAdapter(
                supportFragmentManager,
                this@MainActivity
            )
        )

        // Give the TabLayout the ViewPager
        val tabLayout = findViewById<TabLayout>(R.id.sliding_tabs)
        tabLayout.setupWithViewPager(viewPager)
    }
}