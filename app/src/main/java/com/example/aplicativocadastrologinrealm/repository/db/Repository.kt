package com.example.aplicativocadastrologinrealm.repository.db

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.aplicativocadastrologinrealm.model.UserModel
import io.realm.Realm
import io.realm.kotlin.where
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Repository {

    private val realm = Realm.getDefaultInstance()

    // Criar o usuario
    fun create(usuario: UserModel) {

        realm.executeTransaction {
            it.insert(usuario)
        }
    }

    // Pegar o usuario
    fun get(idUsuario: String) : UserModel {

        val project = realm.where<UserModel>()
            .equalTo("pk", idUsuario).findFirst()

        project?.let { aux ->
            return aux
        } ?: run {
            return UserModel()
        }
    }

    // Pegar todas as informações

    fun getAll(_usuario: MutableLiveData<ArrayList<UserModel>>) {

        val usuario = realm.where<UserModel>().findAll()

        var list = ArrayList<UserModel>()
        list.addAll(usuario)

        _usuario.value = list
    }

    fun login (email: String): UserModel{
        val project = realm.where<UserModel>()
            .equalTo("email", email).findFirst()
        project?.let { aux ->
            return  aux
        }?: run{
            return UserModel()
        }
    }
}