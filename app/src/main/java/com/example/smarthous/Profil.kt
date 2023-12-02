package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.text.set
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONArray

class Profil : AppCompatActivity() {
    val viewItems = ArrayList<Users>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val supabase = createSupabaseClient(
            supabaseUrl = "https://prldqfqaxwcsbbwjycgt.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBybGRxZnFheHdjc2Jid2p5Y2d0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEwNjk5OTEsImV4cCI6MjAxNjY0NTk5MX0.-NFmn1HBbtg5IPS7d6X3j5mvph_ofAMWvgxeTUuCTak"
        ) {
            install(GoTrue)
            install(Postgrest)
            //install other modules
        }

        val imageView: ImageView = findViewById(R.id.imageView)
        val nameUser: EditText = findViewById(R.id.NameUser)
        val emailAdres: EditText = findViewById(R.id.EmailAddress)
        val adres: EditText = findViewById(R.id.TextAddress)

        lifecycleScope.launch {
            val city = supabase.postgrest["Пользователи"].select().decodeSingle<Users>()
            Log.e("!", "id: "+ city.id + "Adress:" + city.Адрес)
            nameUser.setText(city.Логин)
            adres.setText(city.Адрес)
            //imageView.setImageIcon(city.Изображение)

            val city2 = supabase.postgrest["users"].select().decodeSingle<Users>()
            Log.e("!", "id: "+ city2.id + "email" + city.email)
            emailAdres.setText(city2.email)
        }

    }

    fun onBack(view: View){
        val intent = Intent(this, HomeAcran::class.java)
        startActivity(intent)
    }

    fun onVati(view: View){
        val intent = Intent(this, HomeAcran::class.java)
        startActivity(intent)
    }
}