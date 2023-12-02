package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import org.json.JSONException

class AddAddress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)

        val supabase = createSupabaseClient(
            supabaseUrl = "https://prldqfqaxwcsbbwjycgt.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBybGRxZnFheHdjc2Jid2p5Y2d0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEwNjk5OTEsImV4cCI6MjAxNjY0NTk5MX0.-NFmn1HBbtg5IPS7d6X3j5mvph_ofAMWvgxeTUuCTak"
        ) {
            install(GoTrue)
            install(Postgrest)
            //install other modules
        }

        val adres: EditText = findViewById(R.id.editTextPostalAddress)
        val save: Button = findViewById(R.id.buttonSave)

        save.setOnClickListener {
            val adresD = adres.text.toString()
            val intent = Intent(this, Avtorizashin::class.java)

            try{
                if(adresD == ""){
                    Toast.makeText(applicationContext, "Укажите адрес!",Toast.LENGTH_LONG).show()
                } else {
                    lifecycleScope.launch {
                        val userId = supabase.gotrue.retrieveUserForCurrentSession(updateSession = true).id

                        val city = Users(id = userId, Адрес = adresD)
                            // supabase.postgrest["Пользователи"].insert(city) //returning defaults to Returning.REPRESENTATION

                        supabase.postgrest["Пользователи"].update(
                            {
                                set("Адрес", adresD)
                            }
                        ) {
                            eq("id", userId)
                        }

                        Toast.makeText(applicationContext, "Адрес указан!", Toast.LENGTH_LONG).show()
                        startActivity(intent)
                    }
                }
            } catch (e: JSONException){
                Log.e("!!!", e.message.toString())
            }
        }
    }
}