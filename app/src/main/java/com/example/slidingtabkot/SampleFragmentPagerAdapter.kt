package com.example.slidingtabkot

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SampleFragmentPagerAdapter(fm: FragmentManager?, private val context: Context) :
    FragmentPagerAdapter(fm!!) {
    val PAGE_COUNT = 8
    private val tabTitles =
        arrayOf("ImUT", "Elearning", "Latihan Mandiri",  "LMS", "Praktik","SIA", "Perpustakaan","Youtube")
    private val urls = arrayOf(
        "https://utserang.ut.ac.id/utsapa",
        "https://elearning.ut.ac.id",
        "https://lm.ut.ac.id",
        "https://lms.ut.ac.id",
        "https://praktik.ut.ac.id",
        "https://sia.ut.ac.id",
        "https://pustaka.ut.ac.id/lib/ruangbaca/",
        "https://www.youtube.com"

    )

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position + 1, urls[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Generate title based on item position
        return tabTitles[position]
    }
}