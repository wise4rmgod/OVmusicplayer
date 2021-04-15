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
import androidx.fragment.app.viewModels
import com.dev.ovmusicplayer.databinding.VisualizationFragmentBinding
import com.dev.ovmusicplayer.util.MediaPlayerMix

class VisualizationFragment : Fragment() {

    lateinit var binding: VisualizationFragmentBinding
    val viewModel: VisualizationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VisualizationFragmentBinding.inflate(inflater, container, false)

        viewModel.requestPermission(binding.root.context as Activity?)
        if (viewModel.checkPermission(binding.root.context as Activity?)) {
            //get the AudioSessionId from your MediaPlayer and pass it to the visualizer
            val audioSessionId: Int? = MediaPlayerMix.mPlayer?.audioSessionId
            if (audioSessionId != -1) audioSessionId?.let { binding.blast.setAudioSessionId(it) }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.blast.release()
    }
}