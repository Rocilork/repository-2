package com.example.smarthous

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AkranVxoda : AppCompatActivity() {

    var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akran_vxoda)

    }

    fun onPinCod(v: View) {
        when (v.id) {
            R.id.button -> value = value + 1
            R.id.button2 -> value = value + 2
            R.id.button3 -> value = value + 3
            R.id.button4 -> value = value + 4
            R.id.button5 -> value = value + 5
            R.id.button6 -> value = value + 6
            R.id.button7 -> value = value + 7
            R.id.button8 -> value = value + 8
            R.id.button9 -> value = value + 9
        }
        Change_Color()
        Change_Next()
    }

    fun Change_Color() {
        val butT: Button = findViewById(R.id.but)
        val butT2: Button = findViewById(R.id.but2)
        val butT3: Button = findViewById(R.id.but3)
        val butT4: Button = findViewById(R.id.but4)


        if (value.length == 1) {
            butT?.setBackgroundColor(Color.parseColor("#1A6FEE"))
        }
        if (value.length == 2) {
            butT2?.setBackgroundColor(Color.parseColor("#1A6FEE"))
        }
        if (value.length == 3) {
            butT3?.setBackgroundColor(Color.parseColor("#1A6FEE"))
        }
        if (value.length == 4) {
            butT4?.setBackgroundColor(Color.parseColor("#1A6FEE"))
        }
    }

    fun Change_Next() {
        if (value.length == 4) {
            val intent = Intent(this, AddAddress::class.java)
            startActivity(intent)
        }
    }
    fun onVayte (view: View){
        val intent = Intent(this, Avtorizashin::class.java)
        startActivity(intent)
    }
}