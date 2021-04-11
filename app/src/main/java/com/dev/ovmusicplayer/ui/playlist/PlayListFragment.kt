package com.dev.ovmusicplayer.ui.playlist

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.databinding.PlayListFragmentBinding
import com.dev.ovmusicplayer.ui.dashboard.MainActivity

class PlayListFragment : Fragment() {
    lateinit var binding: PlayListFragmentBinding

    private lateinit var viewModel: PlayListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PlayListFragmentBinding.inflate(inflater, container, false)
        // close Activity custom tabbar
        (activity as MainActivity).binding.customeTab.customTabbarLayout.visibility = View.GONE
        (activity as MainActivity).binding.upnextMenubottom.visibility = View.GONE
        binding.playlistClosebtn.setOnClickListener {

            findNavController().popBackStack()
            // startActivity(Intent(activity, MainActivity::class.java))
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}