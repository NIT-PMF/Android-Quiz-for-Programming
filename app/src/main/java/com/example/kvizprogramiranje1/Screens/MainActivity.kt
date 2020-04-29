package com.example.kvizprogramiranje1.screens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainBinding
import com.example.kvizprogramiranje1.logic.checkUsername
import com.example.kvizprogramiranje1.logic.showToast
import com.example.kvizprogramiranje1.singleton.UserSingleton
import com.example.kvizprogramiranje1.singleton.userSingletonData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.usernameBtn.setOnClickListener{ startQuiz() }
    }

    private fun startQuiz() {
        val username: String = binding.usernamePt.text.toString()

        if (userSingletonData.findUser(username) != null) {
            showToast(applicationContext, "User Already Exists. Choose another")
        } else {
            if (checkUsername(username)) {
                Log.i("MainActivity", userSingletonData.getUserData().toString())
                val intent = Intent(this, MainQuizActivity::class.java)
                startActivity(intent)
            } else
                showToast(applicationContext, getString(R.string.toast_username))
        }
    }
}
