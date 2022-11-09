package com.pr7.kotlin_viewpager2_with_indicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnScrollChangeListener
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.pr7.kotlin_viewpager2_with_indicator.fragments.BlankFragment
import com.pr7.kotlin_viewpager2_with_indicator.fragments.BlankFragment2

class MainActivity : AppCompatActivity() {
    lateinit var viewPager2: ViewPager2
    lateinit var recyclerView: RecyclerView
    lateinit var slideAdapter: SlideAdapter
    val fragmentlist=ArrayList<Fragment>()
    lateinit var intArray: IntArray
    lateinit var myAdapter: MyAdapter
    lateinit var button: Button
    var a=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2=findViewById(R.id.viewpager)
        recyclerView=findViewById(R.id.recyclerview1)
        button=findViewById(R.id.buttonnext)


        fragmentlist.add(BlankFragment())
        fragmentlist.add(BlankFragment2())
        intArray=IntArray(30,{i->i})
        slideAdapter= SlideAdapter(fragmentlist, supportFragmentManager,lifecycle)
        viewPager2.adapter=slideAdapter

        myAdapter= MyAdapter(intArray)
        val  linearlayoutManager=LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)
        recyclerView.apply {
            layoutManager=linearlayoutManager
            adapter=myAdapter
        }
//        val snapHelper=LinearSnapHelper()      //snapped to center
//        snapHelper.attachToRecyclerView(recyclerView)
        //linearlayoutManager.scrollToPosition(20)


        button.setOnClickListener {
            //snapped to start :))
            linearlayoutManager.smoothScrollToPosition(recyclerView, RecyclerView.State(), a)
            a++
        }



        viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("PR77777", "onScrollChange: $position")


            }
        })




    }
}