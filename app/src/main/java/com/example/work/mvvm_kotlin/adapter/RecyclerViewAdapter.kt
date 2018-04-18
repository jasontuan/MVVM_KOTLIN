package com.example.work.mvvm_kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.work.mvvm_kotlin.R
import com.example.work.mvvm_kotlin.model.User
import kotlinx.android.synthetic.main.item_user.view.*

data class RecyclerViewAdapter(private val context: Context, private val userList: List<User>?) : RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList?.get(position)
        holder.setTextName(user?.name)
        holder.setTextId(user?.id)
    }

    class UserViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun setTextName(name: String?) {
            itemView.tv_name.setText(name)
        }

        fun setTextId(id: Int?) {
            itemView.tv_id.setText(id.toString())
        }
    }
}