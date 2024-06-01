package com.example.fickleflight

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        // Otra forma de hacer splashscreen con un theme y sleep
        // https://youtu.be/ksaaMt8Lo6U?t=540

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, AppActivity::class.java)
            startActivity(intent)
        }, 3000)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.app.AppCompatDelegate

//class MainActivity : AppCompatActivity() {

    //private val PREF_NAME = "settings"
    //private val DARK_MODE = "dark_mode"

    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)

        //val sharedPreferences = getSharedPreferences(PREF_NAME, 0)
        //if (sharedPreferences.getBoolean(DARK_MODE, false)) {
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) //cambia el modo de la app.
        //} else {
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //}

        //setContentView(R.layout.activity_main)

        //if (savedInstanceState == null) {
            //supportFragmentManager.beginTransaction()
                //.replace(R.id.fragment_container, SettingsFragment())
                //.commit()
        //}
    //}
//}