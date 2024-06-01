package com.example.fickleflight

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
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
        R.id.navigation_profile,
        R.id.navigation_calendar,
        R.id.navigation_preference,
        R.id.navigation_get_help,
        R.id.navigation_notification,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

        navController = findNavController(R.id.fragment)

        setSupportActionBar(binding.customToolbar)

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = fragmentsNavigation,
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )


        binding.customToolbar.setupWithNavController(navController,appBarConfiguration)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setupWithNavController(navController)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}