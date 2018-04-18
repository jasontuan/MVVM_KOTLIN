package com.example.work.mvvm_kotlin.viewmodel

import android.arch.lifecycle.*
import com.example.work.mvvm_kotlin.interactor.UserRepository
import com.example.work.mvvm_kotlin.model.User

class UserViewModel : ViewModel() {

    private var userRepository = UserRepository()
    private var userLiveDataChange = MutableLiveData<String>()

    var userLiveDataListener = Transformations.switchMap(userLiveDataChange, {
        userRepository.getDataUserSearch(it)
    })

    fun setDataUserChange(str: String = "") {
        userLiveDataChange.value = str
    }

//    fun getUser(): LiveData<List<User>?> {
//        userLiveData = userRepository.getDataUser()
//        return userLiveData
//    }
//
//    fun getUserSearch(text: String): LiveData<List<User>?> {
//        userLiveData = userRepository.getDataUserSearch(text)
//        return userLiveData
//    }


}