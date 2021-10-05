package com.example.aplicativocadastrologinrealm.repository.db

import androidx.lifecycle.MutableLiveData
import com.example.aplicativocadastrologinrealm.model.UserModel
import io.realm.Realm
import io.realm.kotlin.where

class Repository {

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
}