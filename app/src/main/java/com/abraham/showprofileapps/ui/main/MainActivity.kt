package com.abraham.showprofileapps.ui.main


import android.os.Bundle
import com.abraham.showprofileapps.R
import com.abraham.showprofileapps.ui.BaseActivity
import com.abraham.showprofileapps.ui.home.HomeFragment
import com.abraham.showprofileapps.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Abraham on 04/09/2018.
 */

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
    }

    private fun initNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            item -> when(item.itemId){
            R.id.action_home->{
                replaceFragment(HomeFragment(), R.id.container)
                return@setOnNavigationItemSelectedListener true
            }
            R.id.action_profile->{
                replaceFragment(ProfileFragment(), R.id.container)
                return@setOnNavigationItemSelectedListener true
            }

            else->return@setOnNavigationItemSelectedListener true
        }
        }
        bottom_navigation.selectedItemId= R.id.action_home
    }


}
