package com.cua.katsuhub.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.cua.katsuhub.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val sleep = Handler()
        sleep.postDelayed({
            startActivity(Intent(this@SplashScreen, MainMenu::class.java))
            this@SplashScreen.finish()
        }, 2000)
    }
}
