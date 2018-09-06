package com.abraham.showprofileapps.ui.home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.abraham.showprofileapps.ui.BaseListFragment
import com.abraham.showprofileapps.ui.detail.DetailActivity
import com.abraham.showprofileapps.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.startActivity


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : BaseListFragment(), HomeContract.HomeView, ItemClickListener {

    private lateinit var presenter: HomePresenter

    override fun loadData() {
        presenter.loadList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter= HomePresenter(this)
    }

    override fun onListLoaded(list: List<Int>) {
        rv_list?.adapter = HomeAdapter(context, list, this)
        val orientation = LinearLayoutManager.VERTICAL
        rv_list?.layoutManager = LinearLayoutManager(context, orientation, false)
    }

    override fun onItemClicked(obj: Any, position: Int) {
//        Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show()
        val intent = Intent(context, DetailActivity::class.java)
        startActivity(intent)
    }
}
