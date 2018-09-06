package com.abraham.showprofileapps.ui.profile

import android.content.Context
import com.abraham.showprofileapps.db.User
import com.abraham.showprofileapps.db.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

/**
 * Created by Abraham on 06/09/2018.
 */
class ProfilePresenter(val view: ProfileContract.ProfileView) : ProfileContract.ProfileAction{
    override fun loadProfile(context:Context?,username:String,password:String) {
        context?.database?.use {
            val result = select(User.TABLE_USER)
                    .whereArgs("(USERNAME = {username}) and (PASSWORD = {password})",
                            "username" to username,"password" to password)

            val profile = result.parseOpt(classParser<User>())
            if(profile!=null){
                view.onProfileLoaded(profile)
            }
        }
    }
}