package com.example.wilearn_v1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wilearn_v1.R
import com.example.wilearn_v1.databinding.FragmentFirstSemesterSubjectsBinding

class FirstSemesterSubjectsFragment : Fragment() {

    private var _binding: FragmentFirstSemesterSubjectsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstSemesterSubjectsBinding.inflate(inflater, container, false)

        // Set click listeners for each subject
        binding.subject1.setOnClickListener {
            // Navigate to externes rechnungswesen
            findNavController().navigate(R.id.action_firstSemesterSubjectsFragment_to_subject1Fragment)
        }

        binding.subject2.setOnClickListener {
            // Navigate to wiss arbeiten
            findNavController().navigate(R.id.action_firstSemesterSubjectsFragment_to_subject2Fragment)
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}