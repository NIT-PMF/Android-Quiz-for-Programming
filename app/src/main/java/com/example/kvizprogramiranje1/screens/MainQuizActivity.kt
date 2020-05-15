package com.example.kvizprogramiranje1.screens

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainQuizBinding
import com.example.kvizprogramiranje1.logic.applyLanguage
import com.example.kvizprogramiranje1.screens.game.GameViewModel
import com.example.kvizprogramiranje1.singleton.userSingletonData
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.drawer_header.view.*
import java.util.*


class MainQuizActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityMainQuizBinding
    private var player: MediaPlayer? = null
    private var playerPosition: Int? = null
    private lateinit var locale : Locale
    private var language = "english"
    private lateinit var viewModel: GameViewModel


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

        loadLocale()

        drawerLayout = binding.drawerLayoutMain
        val navController = this.findNavController(R.id.quizFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(binding.quizNavView, navController)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val username = bundle.getString("username")
            binding.quizNavView.getHeaderView(0).username_menu_tv.text = username

            val score = bundle.getString("score")
            binding.quizNavView.getHeaderView(0).highscore_number_tv.text = score


        }
        binding.quizNavView.setNavigationItemSelectedListener(this)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.quizFragment)
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()

    }

    override fun onStop() {
        super.onStop()
        if (player !== null) {
            player!!.release()
            player = null
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.learnProgramming -> {
                val uriUrl: Uri =
                    Uri.parse("https://www.tutorialspoint.com/computer_programming/computer_programming_basics.htm")
                val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                startActivity(launchBrowser)
            }
            R.id.learnPython -> {
                val uriUrl: Uri = Uri.parse("https://www.learnpython.org/")
                val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                startActivity(launchBrowser)
            }
            R.id.aboutUs -> {
                val uriUrl: Uri = Uri.parse("https://github.com/NIT-PMF/")
                val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
                startActivity(launchBrowser)
            }
            R.id.music_stop -> {
                if (player?.isPlaying ?: false) {
                    player?.pause();
                    playerPosition = player?.getCurrentPosition();
                } else {
                    player?.start()
                }
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.change_language_main -> {
                language = when (ConfigurationCompat.getLocales(resources.configuration).get(0)
                    .toString()) {
                    "english" -> "bs"
                    else -> "english"
                }
                changeLang(language)
                loadLocale()
                finish();
                startActivity(getIntent());
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //JEZIK PROMJENA FUNKCIJE ZA CUVANJE VRIJEDNOSTI i OCUVANJE NAKON ROTACIJE
    fun loadLocale() {
        val langPref = "Language"
        val prefs: SharedPreferences = getSharedPreferences(
            "CommonPrefs",
            Activity.MODE_PRIVATE
        )
        val language = prefs.getString(langPref, "english")
        changeLang(language)
    }

    fun changeLang(lang: String?) {
        if (lang.equals("", ignoreCase = true)) return
        locale = Locale(lang)
        saveLocale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        getBaseContext().getResources()
            .updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics())
    }

    fun saveLocale(lang: String?) {
        val langPref = "Language"
        val prefs: SharedPreferences = getSharedPreferences(
            "CommonPrefs",
            Activity.MODE_PRIVATE
        )
        val editor = prefs.edit()
        editor.putString(langPref, lang)
        editor.commit()
    }
}