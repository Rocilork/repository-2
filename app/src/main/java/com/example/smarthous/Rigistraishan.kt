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
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Returning
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.buildJsonObject
import org.json.JSONException

class Rigistraishan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rigistraishan)

        val supabase = createSupabaseClient(
            supabaseUrl = "https://prldqfqaxwcsbbwjycgt.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBybGRxZnFheHdjc2Jid2p5Y2d0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEwNjk5OTEsImV4cCI6MjAxNjY0NTk5MX0.-NFmn1HBbtg5IPS7d6X3j5mvph_ofAMWvgxeTUuCTak"
        ) {
            install(GoTrue)
            install(Postgrest)
            //install other modules
        }

        val loginText: EditText = findViewById(R.id.NameUser)
        val emailText: EditText = findViewById(R.id.RegistrashinEmailAddress)
        val passwordText: EditText = findViewById(R.id.RegistrashinPassword)
        val buttonReg: Button = findViewById(R.id.buttonReg)

        buttonReg.setOnClickListener {
            val loginR = loginText.text.toString()
            val emailR = emailText.text.toString()
            val passwordR = passwordText.text.toString()
            val intent = Intent(this, AddAddress::class.java)

            try {
                if(loginR == "" && emailR == "" && passwordR == ""){
                    Toast.makeText(applicationContext, "Поля не все заполнены!", Toast.LENGTH_LONG).show()
                } else {
                    lifecycleScope.launch {

                        supabase.gotrue.signUpWith(Email) {
                            email = emailR
                            password = passwordR
                        }

                        Toast.makeText(applicationContext, "Пользователь зарегистрирован!", Toast.LENGTH_LONG).show()
                        val userId = supabase.gotrue.retrieveUserForCurrentSession(updateSession = true).id


                        val city = Users(id = userId, Логин = loginR)
                        supabase.postgrest["Пользователи"].insert(city) //returning defaults to Returning.REPRESENTATION

                        startActivity(intent)
                    }
                }
            } catch (e: JSONException){
                Log.e("!!!", e.message.toString())
            }

        }
    }

    fun onVoiti(view: View){
        val intent = Intent(this, Avtorizashin::class.java)
        startActivity(intent)
    }
}