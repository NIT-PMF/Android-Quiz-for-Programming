package com.example.kvizprogramiranje1.screens.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.*

import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainBinding.inflate
import com.example.kvizprogramiranje1.databinding.ScoreFragmentBinding

class ScoreFragment : Fragment() {


    private lateinit var binding : ScoreFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = inflate(inflater, R.layout.score_fragment, container, false)

        return binding.root
    }

}
