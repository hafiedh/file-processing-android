package com.hafidh.pretest_background_and_file_processing_hafidh.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.ActivityMainBinding
import com.hafidh.pretest_background_and_file_processing_hafidh.image.HandleImageActivity
import com.hafidh.pretest_background_and_file_processing_hafidh.pdf.HandlePdfActivity
import com.hafidh.pretest_background_and_file_processing_hafidh.utils.AirPlaneMode
import com.hafidh.pretest_background_and_file_processing_hafidh.video.HandleVideoActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var airPlane: AirPlaneMode
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        airPlaneMode()
        pdfClick()
        imageClick()
        videoClick()
    }

    private fun pdfClick() {
        binding.btnPdfHandle.setOnClickListener {
            Intent(this, HandlePdfActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun imageClick() {
        binding.btnImageHandle.setOnClickListener {
            Intent(this, HandleImageActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun airPlaneMode() {
        airPlane = AirPlaneMode()
        IntentFilter().also {
            it.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            registerReceiver(airPlane, it)
        }
    }

    private fun videoClick() {
        binding.btnVideoHandle.setOnClickListener {
            Intent(this, HandleVideoActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airPlane)
    }
}