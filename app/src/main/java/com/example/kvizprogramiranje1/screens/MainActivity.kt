package com.example.kvizprogramiranje1.screens

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.dao.User_dao
import com.example.kvizprogramiranje1.database.AppDB
import com.example.kvizprogramiranje1.databinding.ActivityMainBinding
import com.example.kvizprogramiranje1.entity.User
import com.example.kvizprogramiranje1.logic.checkUsername
import com.example.kvizprogramiranje1.logic.hideKeyboard
import com.example.kvizprogramiranje1.logic.showToast
import com.example.kvizprogramiranje1.screens.main.RulesFragment
import com.example.kvizprogramiranje1.singleton.userSingletonData
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rulesFragment: RulesFragment
    private var player: MediaPlayer? = null
    private lateinit var db: User_dao
    private lateinit var job: Job
    private lateinit var uiScope: CoroutineScope
    private lateinit var users :LiveData<List<User>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,
            R.layout.activity_main
        )

        db = AppDB.getInstance(application).userDatabaseDao;
        job = Job()
        uiScope = CoroutineScope(Dispatchers.Main + job)
        users = db.getUsers()

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.classy_8_bit)
            player?.isLooping = true
            player?.setVolume(100f, 100f)
        }
        player?.start()

        supportActionBar?.title = "ITQuiz Mini Game"
        supportActionBar?.subtitle = getString(R.string.by_us)
        hideKeyboard()
        rulesFragment = RulesFragment()
        binding.usernameBtn.setOnClickListener{ startQuiz() }
    }


    private fun startQuiz() {
        Log.i("MainActivity", users.value.toString())
        val username: String = binding.usernamePt.text.toString()
        val password: String = binding.passwordPt.text.toString()
        if (userSingletonData.findUser(username) != null) {
                    showToast(applicationContext, getString(R.string.user_exists))
                } else {

                    if (checkUsername(username)) {
                        onAddUser(username, password)
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

    fun onAddUser(username:String, password:String) {
        uiScope.launch {
            val user = User()
            user.user_name = username
            user.user_score = 0
            user.user_password = password
            insert(user) 
            Log.i("Main Activity", users.value?.get(0)?.user_name.toString())
        }
    }

    private suspend fun insert(user: User) {
        withContext(Dispatchers.IO) {
            db.saveUser(user)
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
