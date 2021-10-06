package com.example.aplicativocadastrologinrealm.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.kotlin.where
import org.bson.types.ObjectId

open class UserModel(): RealmObject() {

    @PrimaryKey @SerializedName ("pk")
    var id: String = ObjectId().toString()
    @SerializedName("name")
    var name: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("senha")
    var senha: String = ""
}

