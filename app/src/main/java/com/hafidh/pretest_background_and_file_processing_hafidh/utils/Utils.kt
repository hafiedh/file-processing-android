package com.hafidh.pretest_background_and_file_processing_hafidh.utils

import android.content.Context
import android.os.Environment
import androidx.core.content.ContextCompat
import java.io.File

fun getPdfUrl(): String = "https://www.kotlinlang.org/assets/kotlin-media-kit.pdf"

fun getPdfFromAssets() = "tata_cara_unggahan.pdf"

fun getRootDirPath(context: Context): String {
    return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
        val file: File = ContextCompat.getExternalFilesDirs(
            context.applicationContext,
            null
        )[0]
        file.absolutePath
    } else {
        context.applicationContext.filesDir.absolutePath
    }
}
