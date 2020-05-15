package com.example.kvizprogramiranje1.screens

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.dao.UserDatabaseDao
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
    private lateinit var db: UserDatabaseDao
    private lateinit var job: Job
    private lateinit var uiScope: CoroutineScope
    private lateinit var users :List<User>

    @OptIn(InternalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,
            R.layout.activity_main
        )

        db = AppDB.getInstance(application).userDatabaseDao
        job = Job()
        uiScope = CoroutineScope(Dispatchers.Main + job)

        //Pokretanje muzike
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.classy_8_bit)
            player?.isLooping = true
            player?.setVolume(100f, 100f)
        }
        player?.start()

        //Postavljanje naslova
        supportActionBar?.title = "ITQuiz Mini Game"
        supportActionBar?.subtitle = getString(R.string.by_us)
        hideKeyboard()
        rulesFragment = RulesFragment()
        binding.usernameBtn.setOnClickListener{
            uiScope.launch { startQuiz()  }
            }
    }


    //OnClickListener za Enter
    private suspend fun startQuiz() {
       val username: String = binding.usernamePt.text.toString()
        val password: String = binding.passwordPt.text.toString()

        getAllUsers()

        if (userExists(username)) {
            if(checkPassword(password, username)){
                Log.i("MainActivity", userSingletonData.getUserData().toString())
                val intent = Intent(this, MainQuizActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("score", getScore(username))
                startActivity(intent)
            }else {
                showToast(applicationContext, getString(R.string.user_exists))
            }
        } else {
            if (checkUsername(username)) {
                onAddUser(username, password)
                Log.i("MainActivity", userSingletonData.getUserData().toString())
                val intent = Intent(this, MainQuizActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("score", getScore(username))
                startActivity(intent)
            } else
                showToast(applicationContext, getString(R.string.toast_username))
        }
        val soundClick: MediaPlayer? = MediaPlayer.create(this, R.raw.click_sound)
        soundClick?.start()
        }

    //Funkcije koje vracaju/ubacuju iz baze
    private fun getScore(username: String): String? {
        for(user in users){
            if(user.username == username)
                return user.userScore.toString()
        }
        return null
    }

    fun userExists(username: String): Boolean {
        for(user in users){
            if(user.username == username) {
                return true
            }
        }
        return false
    }
    fun checkPassword(password: String, username: String): Boolean {
        for (user in users){
            if(user.username == username && user.userPassword == password) {
                return true
            }
        }
        return false
    }


    fun onAddUser(username:String, password:String) {
        uiScope.launch {
            val user = User()
            user.username = username
            user.userScore = 0
            user.userPassword = password
            insert(user)
            getAllUsers()
            Log.i("MainActivity", users.toString())
            delay(1000)
        }
    }

    private suspend fun getAllUsers(){
        withContext(Dispatchers.IO){
            users = db.getAllUsers()
        }
    }

    private suspend fun insert(user: User) {
        withContext(Dispatchers.IO) {
            db.insert(user)
        }
    }


    //Zaustavljanje Muzike
    override fun onStop() {
        super.onStop()
        if (player !== null) {
            player!!.release()
            player = null
        }
    }
}
