package com.dev.ovmusicplayer.ui.lyrics

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.dev.ovmusicplayer.databinding.FragmentLyricsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.File


class LyricsFragment : Fragment() {
    lateinit var binding: FragmentLyricsBinding
    val viewmodel: LyricsViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLyricsBinding.inflate(inflater, container, false)
        // Request permission from Android local storage access
        viewmodel.requestPermission(binding.root.context as Activity)


        if (viewmodel.checkPermission(binding.root.context as Activity)) {
            binding.customLyricView.setLyricFile(viewmodel.getLyrics())
        }

        /**  if (checkPermission()) {
        val studentExcelFilePath =
        "/storage/Download/dmxlippin.lrc"
        val selectedVideoFile: File = File(studentExcelFilePath)

        val fileName = "dmxlippin" + ".lrc"
        val songlocationFile: File = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        .toString() + "/" + fileName
        )

        binding.customLyricView.setLyricFile(songlocationFile)
        }  **/


        return binding.root
    }


}