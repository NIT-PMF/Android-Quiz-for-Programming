package com.example.kvizprogramiranje1.screens.score

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kvizprogramiranje1.R
import com.example.kvizprogramiranje1.databinding.ScoreFragmentBinding
import com.example.kvizprogramiranje1.logic.showToast

class ScoreFragment : Fragment() {

    private val SHARE_SCORE = 1;
    private lateinit var binding: ScoreFragmentBinding
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
        joker = arguments?.getBoolean("joker") ?: false

        val correct = arguments?.getInt("rightQuestions") ?: 0
        val numQ = arguments?.getInt("questionNumber") ?: 0

        binding = inflate(inflater, R.layout.score_fragment, container, false)

        binding.scoreView.text = score.toString()
        binding.correctQuestion.text = "$correct / $numQ"

        if (joker) {
            binding.jokerView.text = getString(R.string.joker_used)
        } else {
            binding.jokerView.text = getString(R.string.joker_not_used)
        }
        binding.easyBtn.setOnClickListener { view: View ->
            val bundle = bundleOf(Pair("score", score))
            view.findNavController().navigate(R.id.action_score_fragment_to_menuFragment, bundle)
        }
        binding.hardBtn.setOnClickListener { shereClick() }

        return binding.root
    }

    private fun shereClick() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {
            showToast(requireContext(), getString(R.string.permission))
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                    Manifest.permission.READ_CONTACTS)) {
                showToast(requireContext(), getString(R.string.denied_permission))
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE), SHARE_SCORE)
            }
        } else {
            startActivityShare()
        }
    }

    private fun startActivityShare() {
        startActivity(
            ShareCompat.IntentBuilder.from(binding.root.context as Activity)
                .setText(
                    getString(R.string.end_game) + " " + getString(R.string.app_name) + " " + getString(
                        R.string.your_score
                    ) + " " + score.toString()
                )
                .setType("text/plain")
                .intent
        )
    }

}
