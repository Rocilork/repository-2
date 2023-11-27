package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Avtorizashin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avtorizashin)


    }

    fun onRegist(view: View){
        val intent = Intent(this, Rigistraishan::class.java)
        startActivity(intent)
    }
}