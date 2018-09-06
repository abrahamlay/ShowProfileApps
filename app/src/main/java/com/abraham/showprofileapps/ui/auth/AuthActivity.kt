package com.abraham.showprofileapps.ui.auth

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.view.View
import com.abraham.showprofileapps.R
import com.abraham.showprofileapps.db.User
import com.abraham.showprofileapps.db.database
import com.abraham.showprofileapps.ui.BaseActivity
import com.abraham.showprofileapps.ui.Const
import com.abraham.showprofileapps.ui.main.MainActivity
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_auth.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.startActivity


class AuthActivity : BaseActivity(), AuthContract.AuthView {
    override fun onAccountExist(user: User) {
        editor.putBoolean(Const.PARAM_IS_LOGIN,true)
        editor.putString(Const.PARAM_USERNAME,user.userName.toString())
        editor.putString(Const.PARAM_PASSWORD,user.password.toString())
        startActivity<MainActivity>()
    }

    override fun onAccountNotExist() {
        toast("Login Failed")
    }

    private lateinit var presenter: AuthPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        presenter= AuthPresenter(this)
        val isLogin=editor.getBoolean(Const.PARAM_IS_LOGIN)

        addToDB()

        if(isLogin){
            startActivity<MainActivity>()
            finish()
            return
        }

        btn_login.setOnClickListener {
            val username=et_username.text.toString()
            val password=et_password.text.toString()

            loginAttempt(username,password)
        }
    }

    private fun loginAttempt(username: String, password: String) {
        if(username!="" && password!=""){
            presenter.checkingAccount(username,password,applicationContext)
        }else{
            toast("Field Empty")
        }
    }

    private fun addToDB(){
        val view=findViewById<View>(android.R.id.content)
        try {
            this.database.use {
                insert(User.TABLE_USER,
                        User.ID_USER to 0,
                        User.USER_USERNAME to "abrahamlay",
                        User.USER_PASSWORD to "bram123",
                        User.USER_PICTURE to "android.resource://com.abraham.showprofileapps/"+R.drawable.img_arsenal,
                        User.USER_GENDER to "male",
                        User.USER_PHONE to "+628123598901"
                )
            }
            snackbar(view,"Added to DB").show()
        } catch (e: SQLiteConstraintException){
            snackbar(view, e.localizedMessage).show()
        }
    }
}
