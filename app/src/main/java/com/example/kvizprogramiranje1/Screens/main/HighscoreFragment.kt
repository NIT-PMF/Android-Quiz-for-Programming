package com.example.kvizprogramiranje1.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.dao.UserDatabaseDao
import com.example.kvizprogramiranje1.database.AppDB
import com.example.kvizprogramiranje1.databinding.FragmentHighscoreBinding
import com.example.kvizprogramiranje1.entity.User
import com.example.kvizprogramiranje1.screens.MainQuizActivity
import com.example.kvizprogramiranje1.screens.main.adapter.userListAdapter
import kotlinx.coroutines.*

class HighscoreFragment : Fragment() {

    private lateinit var binding: FragmentHighscoreBinding
    private lateinit var db: UserDatabaseDao
    private lateinit var job: Job
    private lateinit var uiScope: CoroutineScope
    private lateinit var users :List<User>

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_highscore, container, false)

        (activity as MainQuizActivity).supportActionBar?.title =
            getString(R.string.highscores_for_list)



        db = AppDB.getInstance(requireContext()).userDatabaseDao
        job = Job()
        uiScope = CoroutineScope(Dispatchers.Main + job)


        uiScope.launch {
            val arrayAdapter: ArrayAdapter<*>
            getAllUsers()

            val highscoreList = binding.highscoreList
            //ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, ArrayList(users))
            arrayAdapter =
                userListAdapter(
                    requireContext(),
                    R.layout.list_item,
                    ArrayList(users)
                )
            highscoreList.adapter = arrayAdapter
        }
            return binding.root

    }

    private suspend fun getAllUsers() {
        withContext(Dispatchers.IO){
            users = db.getAllUsers()
        }
    }


}
