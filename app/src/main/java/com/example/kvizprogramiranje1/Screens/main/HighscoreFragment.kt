package com.example.kvizprogramiranje1.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentHighscoreBinding
import com.example.kvizprogramiranje1.screens.MainQuizActivity
import com.example.kvizprogramiranje1.singleton.userSingletonData

class HighscoreFragment : Fragment() {

    private lateinit var binding: FragmentHighscoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_highscore, container, false)

        (activity as MainQuizActivity).supportActionBar?.title =
            getString(R.string.highscores_for_list)

        val arrayAdapter: ArrayAdapter<*>
        val users = userSingletonData.showHighscore()

        val highscoreList = binding.highscoreList
        //ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, ArrayList(users))
        arrayAdapter = userListAdapter(requireContext(), R.layout.list_item, ArrayList(users))
        highscoreList.adapter = arrayAdapter

        return binding.root
    }

}
