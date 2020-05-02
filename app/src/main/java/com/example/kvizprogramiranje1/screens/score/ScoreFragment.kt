package com.example.kvizprogramiranje1.screens.score

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil.*
import androidx.navigation.findNavController

import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ActivityMainBinding.inflate
import com.example.kvizprogramiranje1.databinding.ScoreFragmentBinding

class ScoreFragment : Fragment() {


    private lateinit var binding : ScoreFragmentBinding
    var score: Int = 0
    var joker: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        score = arguments?.getInt("score") ?: 0
        joker = arguments?.getBoolean("joker")?:false
        val correct = arguments?.getInt("rightQuestions")?:0
        val numQ = arguments?.getInt("questionNumber")?:0
        binding = inflate(inflater, R.layout.score_fragment, container, false)

        binding.scoreView.text = score.toString()
        binding.correctQuestion.text = correct.toString() + "/" +numQ.toString()

        if(joker){
            binding.jokerView.text = getString(R.string.joker_used)
        }else{
            binding.jokerView.text = getString(R.string.joker_not_used)
        }
        binding.easyBtn.setOnClickListener{view:View ->
        val bundle = bundleOf(Pair("score",score))
        view.findNavController().navigate(R.id.action_score_fragment_to_menuFragment, bundle)}
        binding.hardBtn.setOnClickListener{shereClick()}

        return binding.root
    }

    private fun shereClick(){
        startActivity(ShareCompat.IntentBuilder.from(binding.root.context as Activity)
            .setText(getString(R.string.end_game) + " "+ getString(R.string.app_name) + " " + getString(R.string.your_score) +" " + score.toString() )
            .setType("text/plain")
            .intent)
    }

}
