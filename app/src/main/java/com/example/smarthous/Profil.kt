package com.example.smarthous

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.launch

class Profil : AppCompatActivity() {
    val viewItems = ArrayList<Users>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)



        val imageView: ImageView = findViewById(R.id.imageView)
        val nameUser: EditText = findViewById(R.id.NameUser)
        val emailAdres: EditText = findViewById(R.id.EmailAddress)
        val adres: EditText = findViewById(R.id.TextAddress)

        lifecycleScope.launch {
            val session_user = SB.getClient().gotrue.retrieveUserForCurrentSession(updateSession = true)
            val users = SB.getClient().postgrest["Пользователи"].select()
            {
                eq("id", session_user.id)
            }.decodeSingle<Users>()

            nameUser.setText(users.Логин)
            adres.setText(users.Адрес)
            emailAdres.setText(session_user.email)

            val bucket = SB.getClient().storage["Bucets"]
            val bytes = bucket.downloadPublic(users.Изображение)
            val image: Drawable = BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.size))
            imageView.setImageDrawable(image)
        }

    }

    fun onBack(view: View){
        val intent = Intent(this, HomeAcran::class.java)
        startActivity(intent)
    }

    fun onVati(view: View){
        val intent = Intent(this, Avtorizashin::class.java)
        startActivity(intent)
    }
}