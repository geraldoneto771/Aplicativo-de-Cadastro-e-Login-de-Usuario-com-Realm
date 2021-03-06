package com.example.aplicativocadastrologinrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //vinculando o navigation com a main_activity
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}