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
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.databinding.FragmentLyricsBinding
import java.io.File


class LyricsFragment : Fragment() {
    lateinit var binding: FragmentLyricsBinding
    private val PERMISSION_REQUEST_CODE = 100
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLyricsBinding.inflate(inflater, container, false)
        // Request permission from Android local storage access
        requestPermission()

        // get lyrics location in Android locl storage
        if (checkPermission()) {
            val studentExcelFilePath =
                "/storage/Download/dmxlippin.lrc"
            val selectedVideoFile: File = File(studentExcelFilePath)

            val fileName = "dmxlippin" + ".lrc"
            val songlocationFile: File = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString() + "/" + fileName
            )

            binding.customLyricView.setLyricFile(songlocationFile)
        }


        return binding.root
    }

    fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            binding.root.context as Activity,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(
            binding.root.context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }
}