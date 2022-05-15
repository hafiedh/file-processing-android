package com.hafidh.pretest_background_and_file_processing_hafidh.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.ActivityMainBinding
import com.hafidh.pretest_background_and_file_processing_hafidh.pdf.HandlePdfActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pdfClick()
    }

    private fun pdfClick(){
        binding.btnPdfHandle.setOnClickListener {
            Intent(this, HandlePdfActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}