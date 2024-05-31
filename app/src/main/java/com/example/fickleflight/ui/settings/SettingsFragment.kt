package com.example.fickleflight.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Referencias a los elementos del layout
        val switchDarkMode = view.findViewById<Switch>(R.id.switchDarkMode)

        // Configurar listener para el switch
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Modo Oscuro Activado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Modo Oscuro Desactivado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}