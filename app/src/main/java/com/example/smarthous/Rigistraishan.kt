package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Rigistraishan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rigistraishan)

    }

    fun onVoiti(view: View){
        val intent = Intent(this, Avtorizashin::class.java)
        startActivity(intent)
    }
}