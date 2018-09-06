package com.abraham.showprofileapps.ui.profile


import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.abraham.showprofileapps.R
import com.abraham.showprofileapps.db.User
import com.abraham.showprofileapps.ui.BaseActivity
import com.abraham.showprofileapps.ui.Const
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.*




/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ProfileFragment : Fragment(),ProfileContract.ProfileView {

    private lateinit var presenter: ProfilePresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter=ProfilePresenter(this)
        getProfile()
    }

    private fun getProfile() {
        val parentActivity=activity as BaseActivity
        val username=parentActivity.editor.getString(Const.PARAM_USERNAME)
        val password=parentActivity.editor.getString(Const.PARAM_PASSWORD)
        presenter.loadProfile(context,username,password)
    }


    override fun onProfileLoaded(user: User) {
        val uri=Uri.parse(user.picture)
        Glide.with(this).load(uri).into(iv_profile)

        tv_name.text=user.userName
        tv_gender.text=user.gender
        tv_phone.text=user.phone
    }

}
