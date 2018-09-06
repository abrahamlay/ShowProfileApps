package com.abraham.showprofileapps.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abraham.showprofileapps.R
import com.bumptech.glide.Glide



/**
 * Created by Abraham on 05/09/2018.
 */
class HomeAdapter(private val context: Context?,
                  private val list:List<Int>,
                  private val listener: ItemClickListener) : RecyclerView.Adapter<HomeAdapter.PlayersViewHolder>() {
    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        holder.bindData(list.get(position), position)
    }

    override fun getItemCount(): Int = list.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder =
            PlayersViewHolder(LayoutInflater.from(context).inflate(
                    R.layout.item_img,
                    parent,
                    false), listener)

    class PlayersViewHolder(val view: View, val listener: ItemClickListener) : RecyclerView.ViewHolder(view) {
        fun bindData(img_path: Int, position: Int) {
            Glide.with(view).load(img_path).into(itemView.findViewById(R.id.iv_team))

            itemView.setOnClickListener {listener.onItemClicked(img_path as Any ,position)}
        }

    }
}

interface ItemClickListener {
    fun onItemClicked(obj:Any ,position: Int)
}
