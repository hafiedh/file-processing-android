package com.hafidh.pretest_background_and_file_processing_hafidh.pdf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.ActivityHandlePdfBinding

class HandlePdfActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandlePdfBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlePdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  set up nav controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}