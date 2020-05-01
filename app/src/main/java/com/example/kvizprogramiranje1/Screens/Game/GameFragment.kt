package com.example.kvizprogramiranje1.screens.game

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory
    private lateinit var binding: FragmentGameBinding
    private var CLICK_A = 0
    private var CLICK_B = 0
    private var CLICK_C = 0
    private var CLICK_D = 0


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflate(inflater, R.layout.fragment_game, container, false)

        val numofQuestion = arguments?.getInt("questionNo") ?: 4
        val modeOfGame = arguments?.getInt("mode") ?: 4
        viewModelFactory = GameViewModelFactory(numofQuestion, modeOfGame)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(GameViewModel::class.java)

        binding.submitBtn.setOnClickListener {onClickSubmit()}
        binding.givupBtn.setOnClickListener { view: View -> endGame(view)}


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
                        val soundClick: MediaPlayer? = MediaPlayer.create(context, R.raw.click_sound)
                        soundClick?.start()
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
                        val soundClick: MediaPlayer? = MediaPlayer.create(context, R.raw.click_sound)
                        soundClick?.start()
                        return true
                    }
                }
                return false
            }

        })


        binding.answerABtn.setOnClickListener{onClickA()}
        binding.answerBBtn.setOnClickListener{onClickB()}
        binding.answerCBtn.setOnClickListener{onClickC()}
        binding.answerDBtn.setOnClickListener{onClickD()}


        updateQuestionText()
        updateScoreText()
        resetLayout()
        updateLayout()

        return binding.root
    }


    private fun onClickA(){
        CLICK_A++
        if(CLICK_A == 2){
            CLICK_A = 0
            binding.radioGroupA.clearCheck()
        }
    }
    private fun onClickB(){
        CLICK_B++
        if(CLICK_B == 2){
            CLICK_B = 0
            binding.radioGroupB.clearCheck()
        }
    }
    private fun onClickC(){
        CLICK_C++
        if(CLICK_C == 2){
            CLICK_C = 0
            binding.radioGroupC.clearCheck()
        }
    }
    private fun onClickD(){
        CLICK_D++
        if(CLICK_D == 2){
            CLICK_D = 0
            binding.radioGroupD.clearCheck()
        }
    }



    private fun onClickSubmit() {
        viewModel.onCheckAnswers(sendAnswers())
        if(gameFinished()){
            endGame(binding.root)
        }
        updateScoreText()
        updateQuestionText()
        resetLayout()
        updateLayout()
    }

    private fun sendAnswers(): ArrayList<String>{
        val answers = arrayListOf<String>()
        if (binding.answerABtn.isChecked) {
            answers.add(binding.answerABtn.text as String)
        }
        if(binding.answerBBtn.isChecked){
            answers.add(binding.answerABtn.text as String)
        }
        if(binding.answerCBtn.isChecked){
            answers.add(binding.answerCBtn.text as String)
        }
        if(binding.answerDBtn.isChecked){
            answers.add(binding.answerDBtn.text as String)
        }

        if(binding.answerText.visibility == View.VISIBLE){
            val text: String = binding.answerText.text.toString()
            answers.add(text)
        }
        return answers

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
       // val ims: InputStream = binding.root.context.assets.open("easy2.png")
       // val d = Drawable.createFromStream(ims, null)
       // binding.imageView.setImageDrawable(d)
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
            binding.answerCBtn.text = viewModel.question?.possibleAnswers?.elementAt(2)
            binding.answerDBtn.text = viewModel.question?.possibleAnswers?.elementAt(3)

        }
    }

    private fun updateTextInput(){
        binding.answerText.visibility = View.VISIBLE
    }

    private fun resetLayout(){
        binding.answerText.visibility = View.INVISIBLE
        binding.answerABtn.visibility = View.INVISIBLE
        binding.answerBBtn.visibility = View.INVISIBLE
        binding.answerCBtn.visibility = View.INVISIBLE
        binding.answerDBtn.visibility = View.INVISIBLE

        binding.radioGroupA.clearCheck()
        binding.radioGroupB.clearCheck()
        binding.radioGroupC.clearCheck()
        binding.radioGroupD.clearCheck()

        binding.imageView.visibility = View.INVISIBLE

    }

    private fun updateQuestionText() {
        binding.questionText.text = viewModel.question?.questionText.toString()


    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }

    //Treba implementirati
    private fun gameFinished(): Boolean {
        if(viewModel.questionsList.isEmpty()) {
            return true
        }
        return false
    }

    private fun endGame(view: View){
        val bundle = bundleOf(Pair("score", score))
        view.findNavController().navigate(R.id.action_gameFragment_to_score_fragment, bundle)
    }

}
