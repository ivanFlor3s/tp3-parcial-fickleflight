package com.example.fickleflight.ui.settings

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import com.example.fickleflight.R

class SettingsFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences //almacena el estado del modo oscuro.
    private val PREF_NAME = "settings"
    private val DARK_MODE = "dark_mode"

    //onCreateView: infla(convierte) el archivo xml y lo convierte en un vista.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, 0) //obtiene la activdad del fragment.
        val switchDarkMode = view.findViewById<Switch>(R.id.switchDarkMode) //encuentra la vista del switch.


        val isDarkMode = sharedPreferences.getBoolean(DARK_MODE, false)
        switchDarkMode.isChecked = isDarkMode

        switchDarkMode.setOnCheckedChangeListener { _, isChecked -> //se configura el listener de la app para que cambie.
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                saveDarkModeState(true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                saveDarkModeState(false)
            }
        }
    }

    private fun saveDarkModeState(isEnabled: Boolean) { //se guarda el estado del modo oscuro.
        val editor = sharedPreferences.edit()
        editor.putBoolean(DARK_MODE, isEnabled)
        editor.apply()
    }
}