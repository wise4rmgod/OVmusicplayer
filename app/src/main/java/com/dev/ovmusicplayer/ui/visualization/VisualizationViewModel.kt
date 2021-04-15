package com.dev.ovmusicplayer.ui.visualization

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel

class VisualizationViewModel : ViewModel() {

    private val PERMISSION_REQUEST_CODE = 100
    fun checkPermission(activity: Activity?): Boolean {
        val result = activity?.let {
            ContextCompat.checkSelfPermission(
                it,
                android.Manifest.permission.RECORD_AUDIO
            )
        }
        return result == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission(activity: Activity?) {
        activity?.let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                PERMISSION_REQUEST_CODE
            )
        }
    }
}