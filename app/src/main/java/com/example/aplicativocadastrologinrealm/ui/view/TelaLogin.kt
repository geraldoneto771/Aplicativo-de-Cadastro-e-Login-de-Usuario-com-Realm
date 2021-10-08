package com.example.aplicativocadastrologinrealm.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aplicativocadastrologinrealm.R
import com.example.aplicativocadastrologinrealm.databinding.FragmentTelaLoginBinding
import com.example.aplicativocadastrologinrealm.model.UserModel
import com.example.aplicativocadastrologinrealm.ui.viewmodel.UserLoginViewModel
import com.example.aplicativocadastrologinrealm.ui.viewmodel.UserViewModel
import com.google.android.material.snackbar.Snackbar


class TelaLogin : Fragment() {

    private lateinit var mBinding: FragmentTelaLoginBinding
    private lateinit var mViewmodel: UserLoginViewModel
    private lateinit var mViewModelUser: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentTelaLoginBinding.inflate(inflater)
        mViewmodel = ViewModelProvider(requireActivity()).get(UserLoginViewModel::class.java)
        mViewModelUser = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)


        mBinding.buttonLogIn.setOnClickListener {
            login()
        }
        mBinding.buttonSignUp.setOnClickListener {
            findNavController().navigate(TelaLoginDirections.actionTelaLoginToTelaCriarConta())
        }
        return mBinding.root
    }

    private fun login() {

        val usuario = UserModel()
        val email = mBinding.editTextEmail.text.toString()

        usuario.email = email
        //val senha = mBinding.editTextPassword.text.toString()

        mViewModelUser.login(usuario.toString())

        if (email == "geraldo@gmail.com") {
            findNavController().navigate(TelaLoginDirections.actionTelaLoginToTelaFeed())

            Snackbar.make(mBinding.root,"Logado com sucesso!", Snackbar.LENGTH_LONG).show()
        }

    }

}