package com.abraham.showprofileapps.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
/**
 * Created by Abraham on 05/09/2018
 */

open class BaseFragment:Fragment(){
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onActivityCreated(savedInstanceState)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            android.R.id.home -> {
                activity?.finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}