package com.abraham.showprofileapps.ui.home

import com.abraham.showprofileapps.R

/**
 * Created by Abraham on 05/09/2018.
 */
class HomePresenter(val view:HomeContract.HomeView):HomeContract.HomeAction{

    override fun loadList() {
        val list= ArrayList<Int>()
        list.add(R.drawable.img_arsenal)
        list.add(R.drawable.img_acm)
        list.add(R.drawable.img_barca)
        list.add(R.drawable.img_bayern)
        list.add(R.drawable.img_chelsea)
        list.add(R.drawable.img_city)
        list.add(R.drawable.img_madrid)
        list.add(R.drawable.img_mu)
        view.onListLoaded(list)
    }

}