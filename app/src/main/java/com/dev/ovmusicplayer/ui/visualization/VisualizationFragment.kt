package com.dev.ovmusicplayer.ui.visualization

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.dev.ovmusicplayer.databinding.VisualizationFragmentBinding
import com.dev.ovmusicplayer.util.MediaPlayerMix

class VisualizationFragment : Fragment() {

    lateinit var binding: VisualizationFragmentBinding
    private lateinit var viewModel: VisualizationViewModel
    private val PERMISSION_REQUEST_CODE = 100
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VisualizationFragmentBinding.inflate(inflater, container, false)
        requestPermission()
        if (checkPermission()) {
            //get the AudioSessionId from your MediaPlayer and pass it to the visualizer
            val audioSessionId: Int? = MediaPlayerMix.mPlayer?.audioSessionId
            if (audioSessionId != -1) audioSessionId?.let { binding.blast.setAudioSessionId(it) }
        }

        return binding.root
    }

    fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            binding.root.context as Activity,
            android.Manifest.permission.RECORD_AUDIO
        )
        return result == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(
            binding.root.context as Activity,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            PERMISSION_REQUEST_CODE
        )
    }
}