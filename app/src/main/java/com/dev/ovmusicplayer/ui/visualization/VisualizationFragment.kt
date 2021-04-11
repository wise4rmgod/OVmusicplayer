package com.dev.ovmusicplayer.ui.visualization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.databinding.VisualizationFragmentBinding
import com.dev.ovmusicplayer.util.MediaPlayerMix

class VisualizationFragment : Fragment() {

    lateinit var binding: VisualizationFragmentBinding
    private lateinit var viewModel: VisualizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VisualizationFragmentBinding.inflate(inflater, container, false)

        //get the AudioSessionId from your MediaPlayer and pass it to the visualizer
    
        return binding.root
    }


}