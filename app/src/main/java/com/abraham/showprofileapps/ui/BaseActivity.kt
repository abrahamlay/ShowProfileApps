package com.abraham.showprofileapps.ui

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.abraham.showprofileapps.util.MyApp
import com.abraham.showprofileapps.util.UtilSharedPreference


/**
 * Created by Abraham on 05/09/2018.
 */
open class BaseActivity:AppCompatActivity(){
    var editor: UtilSharedPreference=MyApp.getInstance().editor

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction{replace(frameId, fragment)}
    }

}