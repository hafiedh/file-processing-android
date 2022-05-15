package com.hafidh.pretest_background_and_file_processing_hafidh.pdf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.FragmentStorageBinding

class StorageFragment : Fragment() {
    private var _binding : FragmentStorageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStorageBinding.inflate(inflater, container, false)
        return binding.root
    }


}