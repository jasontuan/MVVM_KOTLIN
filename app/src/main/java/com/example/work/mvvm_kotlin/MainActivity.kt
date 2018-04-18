package com.example.work.mvvm_kotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import com.example.work.mvvm_kotlin.adapter.RecyclerViewAdapter
import com.example.work.mvvm_kotlin.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher {

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        userViewModel.setDataUserChange(s?.toString()?.trim() ?: "")
    }

    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pb_wait.visibility = View.VISIBLE
        rcv_user.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.userLiveDataListener.observe(this, Observer {
            pb_wait.visibility = View.GONE
            recyclerViewAdapter = RecyclerViewAdapter(this, it)
            rcv_user.adapter = recyclerViewAdapter
            recyclerViewAdapter.notifyDataSetChanged()
        })
        userViewModel.setDataUserChange()
        tv_text.addTextChangedListener(this)
    }
}