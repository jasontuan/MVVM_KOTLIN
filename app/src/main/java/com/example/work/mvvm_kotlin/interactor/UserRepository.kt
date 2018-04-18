package com.example.work.mvvm_kotlin.interactor

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.work.mvvm_kotlin.model.User
import com.google.firebase.database.*

class UserRepository {

    val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference()
    val userLiveData: MutableLiveData<List<User>?> = MutableLiveData()

//    fun getDataUser(): MutableLiveData<List<User>?> {
//        databaseReference.child("Users").addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(p0: DatabaseError?) {
//            }
//
//            override fun onDataChange(p0: DataSnapshot?) {
//                val mutableList: MutableList<User> = mutableListOf()
//                if (p0 != null) {
//                    for (item: DataSnapshot in p0.children) {
//                        mutableList.add(item.getValue(User::class.java)!!)
//                    }
//                    userLiveData.value = mutableList
//                }
//            }
//        })
//        return userLiveData
//    }

    fun getDataUserSearch(text: String): MutableLiveData<List<User>?> {
        val mutableList: MutableList<User> = mutableListOf()
        mutableList.add(User(10, "New"))
        userLiveData.value = mutableList
        return userLiveData
    }
}