package com.example.kvizprogramiranje1.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentAboutBinding
import com.example.kvizprogramiranje1.screens.MainQuizActivity

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        (activity as MainQuizActivity).supportActionBar?.title = getString(R.string.about_title)

        return binding.root
    }

}
