package com.example.kvizprogramiranje1.screens

import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainQuizBinding
import com.example.kvizprogramiranje1.logic.showToast
import com.example.kvizprogramiranje1.screens.game.GameViewModel
import com.example.kvizprogramiranje1.singleton.userSingletonData
import kotlinx.android.synthetic.main.drawer_header.view.*

class MainQuizActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainQuizBinding>(
            this,
            R.layout.activity_main_quiz
        )

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
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }

}
