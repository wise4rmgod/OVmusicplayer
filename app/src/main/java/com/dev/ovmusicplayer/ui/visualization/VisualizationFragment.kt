package com.dev.ovmusicplayer.ui.visualization

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dev.ovmusicplayer.R

class VisualizationFragment : Fragment() {

    companion object {
        fun newInstance() = VisualizationFragment()
    }

    private lateinit var viewModel: VisualizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.visualization_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VisualizationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}