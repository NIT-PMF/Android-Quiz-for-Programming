package com.example.kvizprogramiranje1.screens.main

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.os.ConfigurationCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentMenuBinding
import com.example.kvizprogramiranje1.logic.applyLanguage
import com.example.kvizprogramiranje1.screens.MainQuizActivity


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var spinner: Spinner
    var questionNumber = 4

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        spinner = binding.noQuestionSpinner

        (activity as MainQuizActivity).supportActionBar?.title = getString(R.string.game_title)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val soundClick: MediaPlayer? = MediaPlayer.create(context, R.raw.click_sound)
                soundClick?.start()
                questionNumber = binding.noQuestionSpinner.selectedItem.toString().toInt()
            }


        }

        //OnTouch Event (Ukoliko je pritisnut promjeni se izgled)
        binding.easyBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        binding.easyBtn.setBackgroundResource(R.drawable.ic_button_pressed_yellow)
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        binding.easyBtn.setBackgroundResource(R.drawable.ic_button_image_yellow)
                        binding.easyBtn.performClick()
                        return true
                    }
                }
                return false
            }

        })
        binding.normalBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        binding.normalBtn.setBackgroundResource(R.drawable.ic_button_pressed_yellow)
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        binding.normalBtn.setBackgroundResource(R.drawable.ic_button_image_yellow)
                        binding.normalBtn.performClick()
                        return true
                    }
                }
                return false
            }

        })
        binding.hardBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        binding.hardBtn.setBackgroundResource(R.drawable.ic_button_pressed_yellow)
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        binding.hardBtn.setBackgroundResource(R.drawable.ic_button_image_yellow)
                        binding.hardBtn.performClick()
                        return true
                    }
                }
                return false
            }

        })

        //OnClick Event
        binding.easyBtn.setOnClickListener { view: View ->
            val bundle = bundleOf(Pair("questionNo", questionNumber), Pair("mode", 1))
            val soundClick: MediaPlayer? = MediaPlayer.create(context, R.raw.click_sound)
            soundClick?.start()
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment2, bundle)
        }
        binding.normalBtn.setOnClickListener { view: View ->
            val bundle = bundleOf(Pair("questionNo", questionNumber), Pair("mode", 2))
            val soundClick: MediaPlayer? = MediaPlayer.create(context, R.raw.click_sound)
            soundClick?.start()
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment2, bundle)
        }

        binding.hardBtn.setOnClickListener { view: View ->
            val bundle = bundleOf(Pair("questionNo", questionNumber), Pair("mode", 3))
            val soundClick: MediaPlayer? = MediaPlayer.create(context, R.raw.click_sound)
            soundClick?.start()
            binding.hardBtn.setBackgroundResource(R.drawable.ic_button_pressed_yellow)
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment2, bundle)
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.questions_array,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.changeLanguage -> {
                var language = "english"
                language = when (ConfigurationCompat.getLocales(resources.configuration).get(0)
                    .toString()) {
                    "english" -> "bs"
                    else -> "english"
                }
                Log.d("LANGUAGE", "Novi jezik: $language")
                applyLanguage(requireContext(), language)
                val intent = activity?.intent
                startActivity(intent)
                true
            }
            else -> NavigationUI.onNavDestinationSelected(
                item,
                requireView().findNavController()
            )
                    || super.onOptionsItemSelected(item)
        }
    }
}