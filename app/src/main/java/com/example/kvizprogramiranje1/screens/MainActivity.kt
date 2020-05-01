package com.example.kvizprogramiranje1.screens

import android.content.Context
import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainBinding
import com.example.kvizprogramiranje1.logic.checkUsername
import com.example.kvizprogramiranje1.logic.hideKeyboard
import com.example.kvizprogramiranje1.logic.showToast
import com.example.kvizprogramiranje1.screens.main.RulesFragment
import com.example.kvizprogramiranje1.singleton.userSingletonData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rulesFragment: RulesFragment
    private var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.classy_8_bit)
            player?.isLooping = true
            player?.setVolume(100f, 100f)
        }
        player?.start()

        hideKeyboard()

        rulesFragment = RulesFragment()
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
                intent.putExtra("username", username)
                startActivity(intent)
            } else
                showToast(applicationContext, getString(R.string.toast_username))
        }
        val soundClick: MediaPlayer? = MediaPlayer.create(this, R.raw.click_sound)
        soundClick?.start()
    }

    override fun onStop() {
        super.onStop()
        if (player !== null) {
            player!!.release()
            player = null
        }
    }
}
