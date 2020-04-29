package com.example.kvizprogramiranje1.screens.main

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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


        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun replaceFragment() {

    }

}
