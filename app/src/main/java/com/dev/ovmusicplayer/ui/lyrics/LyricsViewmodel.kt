package com.dev.ovmusicplayer.ui.lyrics

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import java.io.File

class LyricsViewmodel @ViewModelInject constructor() : ViewModel() {
    private val PERMISSION_REQUEST_CODE = 100

    // get lyrics location in Android locl storage
    fun getLyrics(): File {

        val fileName = "dmxlippin" + ".lrc"
        val songlocationFile: File = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .toString() + "/" + fileName
        )
        return songlocationFile
    }

    fun checkPermission(activity: Activity?): Boolean {
        val result = activity?.let {
            ContextCompat.checkSelfPermission(
                it,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
        return result == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }

}