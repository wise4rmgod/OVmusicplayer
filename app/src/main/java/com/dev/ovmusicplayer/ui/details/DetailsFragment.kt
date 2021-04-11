package com.dev.ovmusicplayer.ui.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.ovmusicplayer.databinding.FragmentDetailsBinding
import com.dev.ovmusicplayer.ui.dashboard.MainActivity
import com.google.android.exoplayer2.Player


class DetailsFragment : Fragment(), Player.EventListener {
    lateinit var binding: FragmentDetailsBinding
    private var sampleUrl =
        "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).binding.customeTab.customTabbarLayout.visibility = View.VISIBLE
        (activity as MainActivity).binding.upnextMenubottom.visibility = View.VISIBLE
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
        //inflater.inflate(R.layout.fragment_details, container, false)
    }


}