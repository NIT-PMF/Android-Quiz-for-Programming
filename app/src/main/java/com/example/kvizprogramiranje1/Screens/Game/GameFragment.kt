package com.example.kvizprogramiranje1.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentGameBinding
import kotlinx.android.synthetic.*

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.submitBtn.setOnClickListener {onClickSubmit()}
        updateWordText()
        updateScoreText()
        resetLayout()
        updateLayout()
        return binding.root
    }


    /** Methods for buttons presses **/

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }
    private fun onClickSubmit() {
        viewModel.onSkip()
        updateScoreText()
        updateWordText()
        resetLayout()
        updateLayout()
    }

    private fun updateLayout(){
        if(viewModel.question?.isImageQuestion!!){
            updateImageLayout()
        }
        if(viewModel.question?.possibleAnswers != null){
            updateMultipleChoice()
        }else{
            updateTextInput()
        }
    }

    private fun updateImageLayout(){
        binding.imageView.visibility = View.VISIBLE
        if(viewModel.question?.possibleAnswers != null){
            updateMultipleChoice()
        }
    }

    private fun  updateMultipleChoice(){
        if(viewModel.question?.possibleAnswers?.size == 2){
            binding.answerABtn.visibility = View.VISIBLE
            binding.answerBBtn.visibility = View.VISIBLE

            binding.answerABtn.text = viewModel.question?.possibleAnswers?.elementAt(0)
            binding.answerBBtn.text = viewModel.question?.possibleAnswers?.elementAt(1)

        }else if(viewModel.question?.possibleAnswers?.size == 3){
            binding.answerABtn.visibility = View.VISIBLE
            binding.answerBBtn.visibility = View.VISIBLE
            binding.answerCBtn.visibility = View.VISIBLE

            binding.answerABtn.text = viewModel.question?.possibleAnswers?.elementAt(0)
            binding.answerBBtn.text = viewModel.question?.possibleAnswers?.elementAt(1)
            binding.answerCBtn.text = viewModel.question?.possibleAnswers?.elementAt(2)

        }else if(viewModel.question?.possibleAnswers?.size == 4){
            binding.answerABtn.visibility = View.VISIBLE
            binding.answerBBtn.visibility = View.VISIBLE
            binding.answerCBtn.visibility = View.VISIBLE
            binding.answerDBtn.visibility = View.VISIBLE


            binding.answerABtn.text = viewModel.question?.possibleAnswers?.elementAt(0)
            binding.answerBBtn.text = viewModel.question?.possibleAnswers?.elementAt(1)
            binding.answerCBtn.text = viewModel.question?.possibleAnswers?.elementAt(3)
            binding.answerDBtn.text = viewModel.question?.possibleAnswers?.elementAt(4)

        }
    }

    private fun updateTextInput(){
        binding.answerText.visibility = View.VISIBLE
    }
    /** Methods for updating the UI **/

    private fun resetLayout(){
        binding.answerText.visibility = View.INVISIBLE
        binding.answerABtn.visibility = View.INVISIBLE
        binding.answerBBtn.visibility = View.INVISIBLE
        binding.answerCBtn.visibility = View.INVISIBLE
        binding.answerDBtn.visibility = View.INVISIBLE
        binding.imageView.visibility = View.INVISIBLE
    }

    private fun updateWordText() {
        binding.questionText.text = viewModel.question?.questionText.toString()


    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }
}
