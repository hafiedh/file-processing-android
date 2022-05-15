package com.hafidh.pretest_background_and_file_processing_hafidh.pdf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.FragmentInternetBinding
import com.hafidh.pretest_background_and_file_processing_hafidh.utils.getPdfUrl
import com.hafidh.pretest_background_and_file_processing_hafidh.utils.getRootDirPath
import java.io.File

class InternetFragment : Fragment() {
    private var _binding: FragmentInternetBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInternetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pbInternet.visibility = View.VISIBLE
        val fileName = "test.pdf"
        downloadPdfInternet(getPdfUrl(), getRootDirPath(requireContext()), fileName)
    }

    private fun downloadPdfInternet(url: String, dirPath: String, fileName: String) {
        PRDownloader.download(
            url,
            dirPath,
            fileName
        ).build()
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    Toast.makeText(context, getString(R.string.toast_download_complete), Toast.LENGTH_LONG)
                        .show()
                    val downloadedFile = File(dirPath, fileName)
                    binding.pbInternet.visibility = View.GONE
                    showPdfFromFile(downloadedFile)
                }


                override fun onError(error: com.downloader.Error?) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.toast_error),
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            })
    }
    // when done then show file pdf
    private fun showPdfFromFile(file: File) {
        binding.pdfInternet.fromFile(file)
            .password(null)
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onPageError { page, _ ->
                Toast.makeText(context, "Error on page $page", Toast.LENGTH_SHORT).show()
            }
            .load()
    }


}