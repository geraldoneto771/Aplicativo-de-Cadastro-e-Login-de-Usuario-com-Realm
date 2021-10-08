package com.example.aplicativocadastrologinrealm.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplicativocadastrologinrealm.R
import com.example.aplicativocadastrologinrealm.databinding.FragmentTelaFeedBinding


class TelaFeed : Fragment() {
    private lateinit var mBinding: FragmentTelaFeedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTelaFeedBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return mBinding.root
    }

}