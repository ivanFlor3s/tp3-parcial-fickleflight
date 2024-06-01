package com.example.fickleflight

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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