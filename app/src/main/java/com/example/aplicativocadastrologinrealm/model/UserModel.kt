package com.example.aplicativocadastrologinrealm.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
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