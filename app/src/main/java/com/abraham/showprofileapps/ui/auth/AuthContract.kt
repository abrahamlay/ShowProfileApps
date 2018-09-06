package com.abraham.showprofileapps.ui.auth

import android.content.Context
import com.abraham.showprofileapps.db.User

/**
 * Created by Abraham on 05/09/2018.
 */
class AuthContract{
    interface AuthView{
        fun onAccountExist(user: User)
        fun onAccountNotExist()
    }
    interface AuthAction{
        fun checkingAccount(username:String,password:String, context: Context)
    }
}