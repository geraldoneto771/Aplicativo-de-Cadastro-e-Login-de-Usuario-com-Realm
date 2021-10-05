package com.example.aplicativocadastrologinrealm.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

class UserModel: RealmObject() {

    @PrimaryKey @SerializedName ("pk")
    val id: String = ObjectId().toString()
    @SerializedName("name")
    val name: String = ""
    @SerializedName("email")
    val email: String = ""
    @SerializedName("senha")
    val senha: String = ""
}