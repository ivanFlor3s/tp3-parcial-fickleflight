package com.example.fickleflight

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.fickleflight.databinding.ActivityAppBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class AppActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding : ActivityAppBinding

    //navigation drawer
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    private val PREF_NAME = "settings"
    private val DARK_MODE = "dark_mode"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        navController = findNavController(R.id.fragment)

        drawerLayout  = findViewById(R.id.main)
        val navView : NavigationView = findViewById(R.id.navigation_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.settingsFragment -> {
                    navController.navigate(R.id.settingsFragment)
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
            true
        }

        val sharedPreferences = getSharedPreferences(PREF_NAME, 0)
         if (sharedPreferences.getBoolean(DARK_MODE, false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) //cambia el modo de la app.
         } else {
             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
         }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        configFragmentsOnNavigate()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun configFragmentsOnNavigate() {
        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            when (destination.id) {
                R.id.exploreFragment
                -> {
                    binding.contentMainInclude.toolbar.visibility = View.VISIBLE
                    showAppIcon()
                    showBurguerMenu()
                    showProfileNotification()
                }

                R.id.settingsFragment
                -> {
                    binding.contentMainInclude.toolbar.visibility = View.VISIBLE
                    showAppIcon()
                    showBurguerMenu()
                    showProfileNotification()
                }

                R.id.searchFragment -> {
                    binding.contentMainInclude.toolbar.visibility = View.VISIBLE
                    showTitle(getNameByDestination(destination))
                    showBackButton()
                    showMoreOptions()
                    binding.bottomNavigationView.visibility = BottomNavigationView.VISIBLE
                }

                R.id.offersFragment -> {
                    binding.contentMainInclude.toolbar.visibility = View.VISIBLE
                    showTitle(getNameByDestination(destination))
                    showBackButton()
                }

                R.id.profileFragment -> {
                    binding.contentMainInclude.toolbar.visibility = View.VISIBLE
                    showTitle(getNameByDestination(destination))
                    showBackButton()
                }

                R.id.settingsFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.rightIcon.visibility = View.GONE
                    showAppIcon()
                    showBackButton()
                }

                R.id.resulstsFragment -> {
                    binding.contentMainInclude.toolbar.visibility = MaterialToolbar.VISIBLE
                    binding.contentMainInclude.toolbarTitle.visibility = View.VISIBLE
                    showBackButton()
                    showMoreOptions()
                    binding.contentMainInclude.toolbarTitle.text = "EZE - LAX"
                    binding.bottomNavigationView.visibility = BottomNavigationView.GONE

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
    private fun showBurguerMenu() {
        binding.contentMainInclude.leftIcon.visibility = View.VISIBLE
        binding.contentMainInclude.leftIcon.setImageResource(R.drawable.baseline_menu_24)
        binding.contentMainInclude.leftIcon.setOnClickListener(View.OnClickListener {
            drawerLayout.open()
        })
    }
    private fun showBackButton() {
        binding.contentMainInclude.leftIcon.setImageResource(R.drawable.outline_keyboard_backspace_24)
        binding.contentMainInclude.leftIcon.setOnClickListener(View.OnClickListener {
            navController.popBackStack()
        })
    }
    private fun showMoreOptions() {
        binding.contentMainInclude.leftIcon.visibility = View.VISIBLE
        binding.contentMainInclude.rightIcon.setImageResource(R.drawable.outline_more_vert_24)
    }
    private fun showProfileNotification() {
        binding.contentMainInclude.rightIcon.setImageResource(R.drawable.profile_notification)
    }
    private fun showTitle(title: String) {
        binding.contentMainInclude.toolbarTitle.text = title
        binding.contentMainInclude.toolbarTitle.visibility = View.VISIBLE
        binding.contentMainInclude.appIcon.visibility = View.GONE
    }
    private fun showAppIcon() {
        binding.contentMainInclude.appIcon.visibility = View.VISIBLE
        binding.contentMainInclude.toolbarTitle.visibility = View.GONE
    }

}