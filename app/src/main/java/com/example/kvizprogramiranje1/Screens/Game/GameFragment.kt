package com.example.kvizprogramiranje1.screens.game

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.FragmentGameBinding
import com.example.kvizprogramiranje1.logic.showToast
import com.example.kvizprogramiranje1.screens.MainQuizActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.drawer_header.view.*
import java.io.InputStream
import java.lang.reflect.Field


class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory
    private lateinit var binding: FragmentGameBinding
    private var numbQuestion = 4
    private var CLICK_A = 0
    private var CLICK_B = 0
    private var CLICK_C = 0
    private var CLICK_D = 0


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, R.layout.fragment_game, container, false)

        numbQuestion = arguments?.getInt("questionNo") ?: 4
        val gameDifficulty = arguments?.getInt("mode") ?: 1

        viewModelFactory = GameViewModelFactory(numbQuestion, gameDifficulty)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(GameViewModel::class.java)

        if (viewModel.popUpClicked) {
            binding.jokerBtn.setBackgroundResource(R.drawable.glassis)
        }

        binding.submitBtn.setOnClickListener { onClickSubmit() }
        binding.givupBtn.setOnClickListener { view: View -> endGame(view) }
        binding.jokerBtn.setOnClickListener { showPopUp() }

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
                        val soundClick: MediaPlayer? =
                            MediaPlayer.create(context, R.raw.click_sound)
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
                        val soundClick: MediaPlayer? =
                            MediaPlayer.create(context, R.raw.click_sound)
                        soundClick?.start()
                        return true
                    }
                }
                return false
            }

        })


        binding.answerABtn.setOnClickListener { onClickA() }
        binding.answerBBtn.setOnClickListener { onClickB() }
        binding.answerCBtn.setOnClickListener { onClickC() }
        binding.answerDBtn.setOnClickListener { onClickD() }

        updateQuestionText()
        updateScoreText()
        resetLayout()
        updateLayout()

        (activity as MainQuizActivity).supportActionBar?.title =
            getString(R.string.question_no_title) + (numbQuestion - viewModel.questionRemain())

        return binding.root
    }


    private fun showPopUp() {
        if (!viewModel.popUpClicked) {
            val dialogBuilder = AlertDialog.Builder(context, R.style.quizDialogTheme)
            dialogBuilder.setMessage(getString(R.string.call_dialog))
            dialogBuilder.setPositiveButton("CALL A FRIEND",
                DialogInterface.OnClickListener { dialog, which -> callButton() })
            dialogBuilder.setNegativeButton("SMS SOMEONE",
                DialogInterface.OnClickListener { dialog, whichButton -> smsButton() })
            val b = dialogBuilder.create()
            b.show()
        }
    }

    private fun callButton() {
        binding.jokerBtn.setBackgroundResource(R.drawable.glassis)

        viewModel.popUpClicked = true
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:0123456789")
        startActivity(intent)
    }

    private fun smsButton() {
        if (viewModel.question?.isImageQuestion!!) {
            showToast(binding.root.context, getString(R.string.cant_use_for_image))
        } else {
            binding.jokerBtn.setBackgroundResource(R.drawable.glassis)

            viewModel.popUpClicked = true

            var possibleAnswers = ""
            if (viewModel.question!!.possibleAnswers != null) {
                for (answer in viewModel.question?.possibleAnswers!!) {
                    possibleAnswers += "->"
                    possibleAnswers += answer
                    possibleAnswers += "\n"
                }
            }

            startActivity(
                ShareCompat.IntentBuilder.from(binding.root.context as Activity)
                    .setText(getString(R.string.need_help) + "\n" + viewModel.question?.questionText.toString() + "\n" + possibleAnswers)
                    .setType("text/plain")
                    .intent
            )
        }
    }

    private fun onClickA() {
        CLICK_A++
        if (CLICK_A == 2) {
            CLICK_A = 0
            binding.radioGroupA.clearCheck()
        }
    }

    private fun onClickB() {
        CLICK_B++
        if (CLICK_B == 2) {
            CLICK_B = 0
            binding.radioGroupB.clearCheck()
        }
    }

    private fun onClickC() {
        CLICK_C++
        if (CLICK_C == 2) {
            CLICK_C = 0
            binding.radioGroupC.clearCheck()
        }
    }

    private fun onClickD() {
        CLICK_D++
        if (CLICK_D == 2) {
            CLICK_D = 0
            binding.radioGroupD.clearCheck()
        }
    }


    private fun onClickSubmit() {
        viewModel.onCheckAnswers(sendAnswers())
        if (gameFinished()) {
            endGame(binding.root)
        }
        updateScoreText()
        updateQuestionText()
        resetLayout()
        updateLayout()
    }

    private fun sendAnswers(): ArrayList<String> {
        val answers = arrayListOf<String>()
        if (binding.answerABtn.isChecked) {
            answers.add(viewModel.question?.possibleAnswers?.elementAt(0) as String)
        }
        if (binding.answerBBtn.isChecked) {
            answers.add(viewModel.question?.possibleAnswers?.elementAt(1) as String)
        }
        if (binding.answerCBtn.isChecked) {
            answers.add(viewModel.question?.possibleAnswers?.elementAt(2) as String)
        }
        if (binding.answerDBtn.isChecked) {
            answers.add(viewModel.question?.possibleAnswers?.elementAt(3) as String)
        }

        if (binding.answerText.visibility == View.VISIBLE) {
            val text: String = binding.answerText.text.toString()
            answers.add(text)
        }
        return answers

    }


    private fun updateLayout() {
        if (viewModel.question?.isImageQuestion!!) {
            updateImageLayout()
        }
        if (viewModel.question?.possibleAnswers != null) {
            updateMultipleChoice()
        } else {
            updateTextInput()
        }
        Log.d("TEST", "BROJ PITANJA: " + numbQuestion.toString() + ". BROJ PREOSTALIH: " + viewModel.questionRemain().toString())
        (activity as MainQuizActivity).supportActionBar?.title =
            getString(R.string.question_no_title) + (numbQuestion - viewModel.questionRemain())

    }

    private fun updateImageLayout() {
        val ims: InputStream =
            binding.root.context.assets.open("quiz_code_images/" + viewModel.question?.questionImage)
        val d = Drawable.createFromStream(ims, null)
        binding.imageView.setImageDrawable(d)
        binding.imageView.visibility = View.VISIBLE
        if (viewModel.question?.possibleAnswers != null) {
            updateMultipleChoice()
        }
    }

    private fun updateMultipleChoice() {
        if (viewModel.question?.possibleAnswers?.size == 2) {
            binding.answerABtn.visibility = View.VISIBLE
            binding.answerBBtn.visibility = View.VISIBLE
            val a = viewModel.question?.possibleAnswers?.elementAt(0).toString()
            val b = viewModel.question?.possibleAnswers?.elementAt(1)
            val ra = resources.getString(resources.getIdentifier(a, "string", "com.example.kvizprogramiranje1"))
            val rb = resources.getString(resources.getIdentifier(b, "string", "com.example.kvizprogramiranje1"))
            binding.answerABtn.text = ra
            binding.answerBBtn.text = rb

        } else if (viewModel.question?.possibleAnswers?.size == 3) {
            binding.answerABtn.visibility = View.VISIBLE
            binding.answerBBtn.visibility = View.VISIBLE
            binding.answerCBtn.visibility = View.VISIBLE

            val a = viewModel.question?.possibleAnswers?.elementAt(0).toString()
            val b = viewModel.question?.possibleAnswers?.elementAt(1).toString()
            val c  = viewModel.question?.possibleAnswers?.elementAt(2).toString()
            val ra = resources.getString(resources.getIdentifier(a, "string", "com.example.kvizprogramiranje1"))
            val rb = resources.getString(resources.getIdentifier(b, "string", "com.example.kvizprogramiranje1"))
            val rc = resources.getString(resources.getIdentifier(c, "string", "com.example.kvizprogramiranje1"))

            binding.answerABtn.text = ra
            binding.answerBBtn.text = rb
            binding.answerCBtn.text = rc

        } else if (viewModel.question?.possibleAnswers?.size == 4) {
            binding.answerABtn.visibility = View.VISIBLE
            binding.answerBBtn.visibility = View.VISIBLE
            binding.answerCBtn.visibility = View.VISIBLE
            binding.answerDBtn.visibility = View.VISIBLE

            val a = viewModel.question?.possibleAnswers?.elementAt(0).toString()
            val b = viewModel.question?.possibleAnswers?.elementAt(1).toString()
            val c  = viewModel.question?.possibleAnswers?.elementAt(2).toString()
            val d = viewModel.question?.possibleAnswers?.elementAt(3).toString()
            val ra = resources.getString(resources.getIdentifier(a, "string", "com.example.kvizprogramiranje1"))
            val rb = resources.getString(resources.getIdentifier(b, "string", "com.example.kvizprogramiranje1"))
            val rc = resources.getString(resources.getIdentifier(c, "string", "com.example.kvizprogramiranje1"))
            val rd = resources.getString(resources.getIdentifier(d, "string", "com.example.kvizprogramiranje1"))

            binding.answerABtn.text = ra
            binding.answerBBtn.text = rb
            binding.answerCBtn.text = rc
            binding.answerDBtn.text = rd

        }
    }

    private fun updateTextInput() {
        binding.answerText.visibility = View.VISIBLE
    }

    private fun resetLayout() {
        binding.answerText.visibility = View.GONE
        binding.answerABtn.visibility = View.INVISIBLE
        binding.answerBBtn.visibility = View.INVISIBLE
        binding.answerCBtn.visibility = View.INVISIBLE
        binding.answerDBtn.visibility = View.INVISIBLE

        binding.radioGroupA.clearCheck()
        binding.radioGroupB.clearCheck()
        binding.radioGroupC.clearCheck()
        binding.radioGroupD.clearCheck()

        binding.imageView.visibility = View.GONE

    }

    private fun updateQuestionText() {
        val q = viewModel.question?.questionText.toString()
        val r = resources.getString(resources.getIdentifier(q, "string", "com.example.kvizprogramiranje1"))
        binding.questionText.text = r

    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }


    private fun gameFinished(): Boolean {
        if (viewModel.questionsList.isEmpty()) {
            return true
        }
        return false
    }

    private fun endGame(view: View) {
        val bundle = bundleOf(
            Pair("score", score),
            Pair("joker", viewModel.popUpClicked),
            Pair("rightQuestions", viewModel.numOfQuestionRight),
            Pair("questionNumber", numbQuestion)
        )
        view.findNavController().navigate(R.id.action_gameFragment_to_score_fragment, bundle)
    }


}
