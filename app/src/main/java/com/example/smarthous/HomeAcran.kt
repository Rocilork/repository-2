package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class HomeAcran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_acran)

        val textView: TextView = findViewById(R.id.textAdres)

        lifecycleScope.launch {
            val session_user = SB.getClient().gotrue.retrieveUserForCurrentSession(updateSession = true)
            val users = SB.getClient().postgrest["Пользователи"].select()
            {
                eq("id", session_user.id)
            }.decodeSingle<Users>()

            textView.setText(users.Адрес)
        }
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