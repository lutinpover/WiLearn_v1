package com.example.wilearn_v1.ui.home.firstSemesterSubjects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wilearn_v1.databinding.FragmentEinfWinfBinding
import com.example.wilearn_v1.databinding.FragmentProgrammierenEinsBinding

class EinfWinfFragment : Fragment() {

    private var _binding: FragmentEinfWinfBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEinfWinfBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}