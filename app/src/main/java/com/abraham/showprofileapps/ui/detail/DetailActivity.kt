package com.abraham.showprofileapps.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.abraham.showprofileapps.R
import com.abraham.showprofileapps.util.SliderIndicator
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.ArrayList

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupSlider()
    }

    private lateinit var mAdapter: SliderPagerAdapter

    private lateinit var mIndicator: SliderIndicator

    private fun setupSlider() {
        slider_view.setDurationScroll(800)
        val fragments = ArrayList<Fragment>()
        fragments.add(SliderFragment.newInstance("android.resource://com.abraham.showprofileapps/"+ R.drawable.img_arsenal.toString()))
        fragments.add(SliderFragment.newInstance("android.resource://com.abraham.showprofileapps/"+R.drawable.img_acm.toString()))
        fragments.add(SliderFragment.newInstance("android.resource://com.abraham.showprofileapps/"+R.drawable.img_bayern.toString()))
        fragments.add(SliderFragment.newInstance("android.resource://com.abraham.showprofileapps/"+R.drawable.img_chelsea.toString()))

        mAdapter = SliderPagerAdapter(supportFragmentManager, fragments)
        slider_view.adapter=mAdapter
        mIndicator = SliderIndicator(this, pages_container, slider_view, R.drawable.indicator_circle)
        mIndicator.setPageCount(fragments.size)
        mIndicator.show()
    }
}
