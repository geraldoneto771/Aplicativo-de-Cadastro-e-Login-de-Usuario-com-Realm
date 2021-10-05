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


    class Repository() {

        private val realm = Realm.getDefaultInstance()
        fun get(): UserModel? {
            val userAux = realm.where(UserModel::class.java).findFirst()
            var user: UserModel? = UserModel()
            userAux?.let {
                user?.id = userAux.id
                user?.name = userAux.name
                user?.email = userAux.email
                user?.senha = userAux.senha
                user?.email = userAux.email
            }?: run{
                user = null
            }

            return user
        }
    }

    fun get(userAux: UserModel): UserModel {
        var user: UserModel = UserModel()
        userAux.let {
            user.id = userAux.id
            user.name = userAux.name
            user.email = userAux.email
            user.senha = userAux.senha
        }
        return user
    }

    fun getLiveData(): MutableLiveData<UserModel> {
        val user = MutableLiveData<UserModel>()
        val userAux = realm.where<UserModel>().findFirst()
        user.value = (userAux)

        return user
    }
    fun set(user: UserModel){
        realm.executeTransaction{
            it.copyToRealmOrUpdate(user)
        }
    }
}

