package com.example.kvizprogramiranje1.Screens.MainQuiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        binding.usernameBtn.setOnClickListener{ startQuiz() }
    }

    private fun startQuiz() {
        //TODO Ubaciti igraca
        val intent = Intent(this, MainQuizActivity::class.java)
        startActivity(intent)
    }
}
