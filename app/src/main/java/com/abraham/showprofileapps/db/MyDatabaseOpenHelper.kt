package com.abraham.showprofileapps.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import java.time.temporal.Temporal

/**
 * Created by Abraham on 04/09/2018.
 */
class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "ShowProfile.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(User.TABLE_USER, true,
                User.ID_USER to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                User.USER_USERNAME to TEXT + UNIQUE,
                User.USER_PASSWORD to TEXT,
                User.USER_PICTURE to TEXT,
                User.USER_GENDER to TEXT,
                User.USER_PHONE to TEXT
                )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(User.TABLE_USER, true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)