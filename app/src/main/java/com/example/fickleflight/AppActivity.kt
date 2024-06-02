package com.example.fickleflight

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.fickleflight.databinding.ActivityAppBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding : ActivityAppBinding

    private val fragmentsNavigation = setOf(
        R.id.exploreFragment,
        R.id.detailFragment,
        R.id.offersFragment,
        R.id.profileFragment,
        R.id.searchFragment,
        R.id.settingsFragment,
        R.id.resulstsFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

        navController = findNavController(R.id.fragment)

        //binding.contentMainInclude.toolbar.setupWithNavController(navController, AppBarConfiguration(fragmentsNavigation))

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Configuro Comportamiento segun Fragmento
        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->

            //Esto es para configurar el Icono Fijo
            //supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_bar_chart_black_24dp)

            when (destination.id) {
                R.id.exploreFragment
                -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.toolbarTitle.visibility = View.GONE
                    binding.contentMainInclude.appIcon.visibility = View.VISIBLE
                    binding.contentMainInclude.appIcon.setImageResource(R.drawable.logo)
                    binding.contentMainInclude.leftIcon.setImageResource(R.drawable.baseline_menu_24)
                    binding.contentMainInclude.rightIcon.setImageResource(R.drawable.profile_notification)
                }

                R.id.searchFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.toolbarTitle.visibility = View.VISIBLE
                    binding.contentMainInclude.appIcon.visibility = View.GONE
                    binding.contentMainInclude.toolbarTitle.text = getNameByDestination(destination)
                    binding.contentMainInclude.leftIcon.setImageResource(R.drawable.outline_keyboard_backspace_24)
                    binding.contentMainInclude.rightIcon.setImageResource(R.drawable.outline_more_vert_24)
                }

                R.id.offersFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.toolbarTitle.visibility = View.VISIBLE
                    binding.contentMainInclude.appIcon.visibility = View.GONE
                    binding.contentMainInclude.toolbarTitle.text = getNameByDestination(destination)
                    binding.contentMainInclude.leftIcon.setImageResource(R.drawable.outline_keyboard_backspace_24)
                    binding.contentMainInclude.rightIcon.visibility = View.GONE
                }
                R.id.profileFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.GONE
                }
                R.id.settingsFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.toolbarTitle.visibility = View.GONE
                    binding.contentMainInclude.appIcon.visibility = View.VISIBLE
                    binding.contentMainInclude.appIcon.setImageResource(R.drawable.logo)
                    binding.contentMainInclude.toolbarTitle.text = "FlickleFlight"
                    binding.contentMainInclude.leftIcon.setImageResource(R.drawable.outline_keyboard_backspace_24)
                    binding.contentMainInclude.rightIcon.visibility = View.GONE
                }
                R.id.resulstsFragment -> {
                    binding.contentMainInclude.toolbarTitle.visibility = View.VISIBLE
                    binding.contentMainInclude.appIcon.visibility = View.GONE
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.toolbarTitle.text = "EZE -> LAX"
                    binding.contentMainInclude.leftIcon.setImageResource(R.drawable.outline_keyboard_backspace_24)
                    binding.contentMainInclude.rightIcon.visibility = View.GONE
                }
                R.id.detailFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.GONE
                }
            }
        }



    }

    private fun getNameByDestination( destination: NavDestination): String {
        return when (destination.id) {
            R.id.exploreFragment -> "Explore"
            R.id.detailFragment -> "Detail"
            R.id.offersFragment -> "Offers"
            R.id.profileFragment -> "Profile"
            R.id.searchFragment -> "Search Flight"
            R.id.settingsFragment -> "Settings"
            R.id.resulstsFragment -> "Results"
            else -> "Unknown"
        }
    }
}