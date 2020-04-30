package com.example.kvizprogramiranje1.screens.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.ViewModelProvider

import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: FragmentGameBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflate(inflater, R.layout.fragment_game, container, false)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.submitBtn.setOnClickListener {onClickSubmit()}

        //OnTouchListener za Izgled Dugmadi (Ne diraj)
        binding.givupBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        binding.givupBtn.setBackgroundResource(R.drawable.ic_button_pressed_yellow)
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        binding.givupBtn.setBackgroundResource(R.drawable.ic_button_image_yellow)
                        binding.givupBtn.performClick()
                        return true
                    }
                }
                return false
            }

        })
        binding.submitBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        binding.submitBtn.setBackgroundResource(R.drawable.ic_button_pressed_yellow)
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        binding.submitBtn.setBackgroundResource(R.drawable.ic_button_image_yellow)
                        binding.submitBtn.performClick()
                        return true
                    }
                }
                return false
            }

        })


        /** Broj Pitanja iz Menu Fragmenta **/
        val questionNumber = arguments?.getInt("questionNo") ?: 4
        Log.d("BROJPITANJA", "BROJ U GAME FRAGMENTU: $questionNumber")

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
