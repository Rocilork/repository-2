package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeAcran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_acran)

    }

    fun onProfil (view: View){
        val intent = Intent(this, Profil::class.java)
        startActivity(intent)
    }

    fun onAdd (view: View){
        val intent = Intent(this, AddRoom::class.java)
        startActivity(intent)
    }
}