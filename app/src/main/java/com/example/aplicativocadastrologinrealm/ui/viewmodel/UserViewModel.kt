package com.example.aplicativocadastrologinrealm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplicativocadastrologinrealm.model.UserModel
import  com.example.aplicativocadastrologinrealm.repository.db.Repository as UserDB

class UserViewModel: ViewModel() {

    private val _user = MutableLiveData<ArrayList<UserModel>>().apply { value = ArrayList() }
    val user: LiveData<ArrayList<UserModel>> = _user

    fun createUser( user: UserModel) { UserDB().create(user)}

    fun getAllUser() {UserDB().getAll(_user)}
}