package com.example.projetokotlin

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.projetokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        Log.v("MainActivity", "onCreate: Activity foi criada")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: Activity está visível para o usuário")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume: Activity está interativa com o usuário")
    }

    override fun onPause() {
        super.onPause()
        Log.w("MainActivity", "onPause: Activity está sendo pausada")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop: Activity não está mais visível")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("MainActivity", "onDestroy: Activity está sendo destruída")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart: Activity está sendo reiniciada")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
