package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AkranVxoda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akran_vxoda)

    }

    fun onVayte (view: View){
        val intent = Intent(this, Avtorizashin::class.java)
        startActivity(intent)
    }
}