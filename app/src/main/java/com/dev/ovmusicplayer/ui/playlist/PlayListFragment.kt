package com.dev.ovmusicplayer.ui.playlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.dev.ovmusicplayer.adapter.PlaylistAdapter
import com.dev.ovmusicplayer.databinding.PlayListFragmentBinding
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.ui.dashboard.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayListFragment : Fragment() {
    lateinit var binding: PlayListFragmentBinding

    val viewModel: PlayListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PlayListFragmentBinding.inflate(inflater, container, false)
        // close Activity custom tabbar
        (activity as MainActivity).binding.customeTab.customTabbarLayout.visibility = View.GONE
        (activity as MainActivity).binding.upnextMenubottom.visibility = View.GONE

        viewModel.getPlayList()
        viewModel.list.observe(viewLifecycleOwner, Observer {
            Log.d("Playlist", it.toString())
            binding.recycleplay.adapter =
                PlaylistAdapter(
                    it as ArrayList<OVMedia>
                )
        })
        binding.playlistClosebtn.setOnClickListener {

            findNavController().popBackStack()
            // startActivity(Intent(activity, MainActivity::class.java))
        }
        return binding.root
    }


}