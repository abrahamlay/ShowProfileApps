package com.abraham.showprofileapps.db

import java.io.Serializable

/**
 * Created by Abraham on 04/09/2018.
 */

data class User(val id: Long?,
                val userName: String?,
                val password: String?,
                val picture: String?,
                val gender:String?,
                val phone:String?
                ): Serializable {

    companion object {
        const val TABLE_USER: String = "TABLE_USER"
        const val ID_USER: String = "ID_USER"
        const val USER_USERNAME: String = "USERNAME"
        const val USER_PASSWORD: String = "PASSWORD"
        const val USER_PICTURE: String = "IMG_PICTURE"
        const val USER_GENDER: String = "GENDER"
        const val USER_PHONE: String = "PHONE"

    }
}