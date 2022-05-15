package com.hafidh.pretest_background_and_file_processing_hafidh.pdf

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.FragmentMenuBinding

class MenuFragment : Fragment(){
    private var _binding : FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnWebViewClickListener()
        setOnAssetsClickListener()
    }

    private fun setOnWebViewClickListener(){
        binding.buttonWebView.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_webViewFragment)
        }
    }

    private fun setOnAssetsClickListener(){
        binding.buttonAssets.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_assetFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}