package com.hafidh.pretest_background_and_file_processing_hafidh.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.ActivityHandleVideoBinding

class HandleVideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandleVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandleVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}