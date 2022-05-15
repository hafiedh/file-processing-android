package com.hafidh.pretest_background_and_file_processing_hafidh.image

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.ActivityHandleImageBinding

class HandleImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandleImageBinding
    private val cameraResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                handleCameraImage(result.data)
            }
        }

    // gallery take result
    private val galleryResult =
        registerForActivityResult(ActivityResultContracts.GetContent()) { result ->
            binding.ivImage.setImageURI(result)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandleImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnChoose.setOnClickListener {
            checkingPermissions()
        }
    }

    private fun checkingPermissions() {
        if (isGranted(
                this,
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )
        ) {
            chooseImageDialog()
        }
    }

    // fun granted permission
    private fun isGranted(
        activity: Activity,
        permissions: Array<String>,
    ): Boolean {
        val permissionCheck = ActivityCompat.checkSelfPermission(activity, permissions[0])
        return if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissions[0])) {
                showPermissionDeniedDialog()
            } else {
                ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE_PERMISSION)
            }
            false
        } else {
            true
        }
    }

    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this)
            .setTitle("Permission Denied")
            .setMessage("Permission is denied, Please allow permissions from App Settings.")
            .setPositiveButton(
                "App Settings"
            ) { _, _ ->
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
            .show()
    }

    // alert dialog for choose image
    private fun chooseImageDialog() {
        AlertDialog.Builder(this)
            .setMessage("Pilih Gambar")
            .setPositiveButton("Gallery") { _, _ -> openGallery() }
            .setNegativeButton("Camera") { _, _ -> openCamera() }
            .show()
    }

    // to open gallery in device
    private fun openGallery() {
        intent.type = "image/*"
        galleryResult.launch("image/*")
    }

    // to open camera in device
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraResult.launch(cameraIntent)
    }

    // handle data from camera to image view
    private fun handleCameraImage(intent: Intent?) {
        val bitmap = intent?.extras?.get("data") as Bitmap
        binding.ivImage.setImageBitmap(bitmap)

    }


    companion object {
        private const val REQUEST_CODE_PERMISSION = 2
    }

}