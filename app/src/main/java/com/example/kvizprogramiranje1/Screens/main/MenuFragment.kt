package com.example.kvizprogramiranje1.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)

        binding.easyBtn.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment2)}
        binding.normalBtn.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment2)}
        binding.hardBtn.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment2)}


        return binding.root
    }



}
