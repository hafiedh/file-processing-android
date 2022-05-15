package com.hafidh.pretest_background_and_file_processing_hafidh.video

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util
import com.hafidh.pretest_background_and_file_processing_hafidh.R
import com.hafidh.pretest_background_and_file_processing_hafidh.databinding.ActivityHandleVideoBinding

class HandleVideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandleVideoBinding
    private var player: ExoPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandleVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build()
            .also {
                binding.exoView.player = it
                it.playWhenReady = true
                it.setMediaSource(buildMediaSource())
                it.prepare()
            }
    }

    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    public override fun onResume() {
        super.onResume()
        hideSystemUi()
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer()
        }
    }

    public override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }


    public override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }

    private fun buildMediaSource(): MediaSource {
        val dataSource = DefaultHttpDataSource.Factory()
        return ProgressiveMediaSource.Factory(dataSource).createMediaSource(MediaItem.fromUri(URI))
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.exoView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun releasePlayer() {
        if (player == null) {
            return
        }
        player?.release()
        player = null
    }

    companion object {
        const val URI =
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    }
}