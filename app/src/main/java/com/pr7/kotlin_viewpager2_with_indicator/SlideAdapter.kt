package com.pr7.kotlin_viewpager2_with_indicator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SlideAdapter constructor(
    val arraylist:ArrayList<Fragment>,
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int=arraylist.size

    override fun createFragment(position: Int): Fragment =arraylist.get(position)
}