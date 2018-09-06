package com.abraham.showprofileapps.ui.home

/**
 * Created by Abraham on 05/09/2018.
 */
class HomeContract{
    interface HomeView{
        fun onListLoaded(list: List<Int>)
    }

    interface HomeAction{
        fun loadList()
    }
}