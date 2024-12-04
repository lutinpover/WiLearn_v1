package com.example.wilearn_v1.ui.home.firstSemesterSubjects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wilearn_v1.databinding.FragmentProgrammierenEinsBinding

class ProgrammierenEinsFragment : Fragment() {

    private var _binding: FragmentProgrammierenEinsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgrammierenEinsBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}