package com.abraham.showprofileapps.ui.auth

import android.content.Context
import com.abraham.showprofileapps.db.User
import com.abraham.showprofileapps.db.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

/**
 * Created by Abraham on 05/09/2018.
 */
class AuthPresenter(val view:AuthContract.AuthView) : AuthContract.AuthAction{


    override fun checkingAccount(username: String, password: String, context: Context) {
        context?.database?.use {
            val result = select(User.TABLE_USER)
                    .whereArgs("(USERNAME = {username}) and (PASSWORD = {password})",
                            "username" to username,"password" to password)

            val profile = result.parseOpt(classParser<User>())
            if(profile!=null){
                view.onAccountExist(profile)
            }else{
                view.onAccountNotExist()
            }
        }
    }

}