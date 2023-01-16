package com.example.ams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unsplash_screen)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,StartScreen::class.java)
            startActivity(intent)
            finish()
        },5000)

    }
}