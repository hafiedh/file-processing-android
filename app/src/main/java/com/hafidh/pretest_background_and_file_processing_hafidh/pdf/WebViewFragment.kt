package com.hafidh.pretest_background_and_file_processing_hafidh.pdf

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.FragmentWebViewBinding
import com.hafidh.pretest_background_and_file_processing_hafidh.utils.getPdfUrl

class WebViewFragment : Fragment() {
    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
            webView.settings.setSupportZoom(true)
            val url = getPdfUrl()
            val embeddedUrl = "https://docs.google.com/gview?embedded=true&url=$url"
            webView.loadUrl(embeddedUrl)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}