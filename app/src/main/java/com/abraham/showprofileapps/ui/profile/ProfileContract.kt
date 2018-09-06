package com.abraham.showprofileapps.ui.profile

import android.content.Context
import com.abraham.showprofileapps.db.User

/**
 * Created by Abraham on 06/09/2018.
 */
class ProfileContract{
    interface ProfileView{
        fun onProfileLoaded(user: User)
    }

    interface ProfileAction{
        fun loadProfile(context: Context?, username: String, password: String)
    }
}