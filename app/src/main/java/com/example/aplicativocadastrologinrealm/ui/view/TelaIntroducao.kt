package com.example.aplicativocadastrologinrealm.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.aplicativocadastrologinrealm.databinding.FragmentTelaIntroducaoBinding


class TelaIntroducao : Fragment() {

    private lateinit var mBinding: FragmentTelaIntroducaoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mBinding = FragmentTelaIntroducaoBinding.inflate(inflater)

        mBinding.buttonLogIn.setOnClickListener {
            findNavController().navigate(TelaIntroducaoDirections.actionTelaIntroducaoToTelaLogin())
        }

        mBinding.buttonSignUp.setOnClickListener {
            findNavController().navigate(TelaIntroducaoDirections.actionTelaIntroducaoToTelaCriarConta())
        }

        return mBinding.root
    }

}