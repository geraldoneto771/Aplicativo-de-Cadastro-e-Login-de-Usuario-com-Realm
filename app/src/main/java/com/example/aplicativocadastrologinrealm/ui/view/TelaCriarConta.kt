package com.example.aplicativocadastrologinrealm.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aplicativocadastrologinrealm.R
import com.example.aplicativocadastrologinrealm.databinding.FragmentTelaCriarContaBinding
import com.example.aplicativocadastrologinrealm.model.UserModel
import com.example.aplicativocadastrologinrealm.ui.viewmodel.UserViewModel
import com.google.android.material.snackbar.Snackbar


class TelaCriarConta : Fragment() {

    private lateinit var mBinding: FragmentTelaCriarContaBinding
    private lateinit var mViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTelaCriarContaBinding.inflate(inflater)

        mViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        mBinding.buttonSignUp.setOnClickListener {
            val usuario = UserModel()

            val nome = mBinding.editTextName.text.toString()
            val email = mBinding.editTextEmail.text.toString()
            val senha = mBinding.editTextPassword.text.toString()

            usuario.name = nome
            usuario.email = email
            usuario.senha = senha

            mViewModel.createUser(usuario)

            Snackbar.make(mBinding.root,"Usuário criado com sucesso!", Snackbar.LENGTH_LONG).show()
            findNavController().popBackStack()
        }
        mBinding.buttonLogIn.setOnClickListener {
            findNavController().navigate(TelaCriarContaDirections.actionTelaCriarContaToTelaLogin2())
        }
        return mBinding.root
    }

}