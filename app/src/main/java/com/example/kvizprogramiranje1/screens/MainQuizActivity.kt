package com.example.kvizprogramiranje1.screens

import android.content.res.Configuration
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainQuizBinding
import com.example.kvizprogramiranje1.singleton.userSingletonData
import kotlinx.android.synthetic.main.drawer_header.view.*
import java.util.*

class MainQuizActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private var player: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainQuizBinding>(
            this,
            R.layout.activity_main_quiz
        )

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.insert_quarter)
            player?.isLooping = true
            player?.setVolume(100f, 100f)
        }
        player?.start()

        drawerLayout = binding.drawerLayoutMain
        val navController = this.findNavController(R.id.quizFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(binding.quizNavView, navController)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val username = bundle.getString("username")
            binding.quizNavView.getHeaderView(0).username_menu_tv.text = username

            val score = userSingletonData.getUserByName(username.toString())?.score
            binding.quizNavView.getHeaderView(0).highscore_number_tv.text =
                (score?.toString() ?: "0")


        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.quizFragment)
        return when(navController.currentDestination?.id) {
            R.id.changeLanguage -> {
                Log.d("LANGUAGE", "USAO")
                val config = resources.configuration
                val locale = when (Locale.getDefault().displayLanguage) {
                    "en" -> Locale("bs-rBA")
                    else -> Locale("en")
                }
                Locale.setDefault(locale)
                config.setLocale(locale)
                //resources.updateConfiguration(config, resources.displayMetrics)
                val configuration: Configuration = applicationContext.getResources().getConfiguration()
                configuration.setLocale(locale)
                configuration.setLayoutDirection(locale)
                true
            }
            else -> NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
        }
    }

    override fun onStop() {
        super.onStop()
        if (player !== null) {
            player!!.release()
            player = null
        }
    }
}
