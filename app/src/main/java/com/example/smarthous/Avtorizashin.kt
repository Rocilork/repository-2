package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.launch
import org.json.JSONException
import java.lang.Exception

class Avtorizashin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avtorizashin)




        val emailText: EditText = findViewById(R.id.AvtorizashinEmailAddress)
        val passwordText: EditText = findViewById(R.id.AvtorizashinPassword)
        val buttonAvt: Button = findViewById(R.id.buttonLog)

        buttonAvt.setOnClickListener {
            val emailA = emailText.text.toString()
            val passwordA = passwordText.text.toString()
            val intent = Intent(this, CreatPinkod::class.java)

            try {
                if (emailA == "" || passwordA == "") {
                    Toast.makeText(applicationContext, "Поля не все заполнены!", Toast.LENGTH_LONG).show()
                } else {
                    lifecycleScope.launch {
                        SB.getClient().gotrue.loginWith(Email) {
                            email = emailA
                            password = passwordA
                        }

                        Toast.makeText(applicationContext, "Пользователь авторизован!", Toast.LENGTH_LONG).show()

                        startActivity(intent)
                    }
                }
            } catch (e: Exception){
                Log.e("!!!", e.message.toString())
            }
        }
    }

    fun onRegist(view: View){
        val intent = Intent(this, Rigistraishan::class.java)
        startActivity(intent)
    }
}