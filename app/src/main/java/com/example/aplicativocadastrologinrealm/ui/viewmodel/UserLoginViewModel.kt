package com.example.aplicativocadastrologinrealm.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aplicativocadastrologinrealm.model.UserModel
import  com.example.aplicativocadastrologinrealm.repository.db.Repository as UserDB


class UserLoginViewModel(application: Application): AndroidViewModel (application){


    private val _user = MutableLiveData<UserModel?>().apply { value = UserModel.Repository().get() }

    val user: LiveData<UserModel?> = _user

    fun login(username: String, password: String, user: UserModel) {

    }
}