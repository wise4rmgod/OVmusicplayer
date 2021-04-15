package com.dev.ovmusicplayer.ui.dashboard

import android.content.Context
import android.content.res.Resources
import android.media.MediaPlayer
import android.os.Environment
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.repository.AddSongDetailRepository
import com.dev.ovmusicplayer.util.MediaPlayerMix
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity_Viewmodel @ViewModelInject constructor(
    private val addSongDetailRepository: AddSongDetailRepository
) :
    ViewModel() {
    private var ovModel: MutableLiveData<OVMedia> = MutableLiveData()


    init {
        ovModel.value = OVMedia()
    }

    fun add() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (ovModel.value != null) {

                    ovModel.value.let {
                        val ovM = it
                        /**     ovM?.album_art = "dmx_slippin"
                        ovM?.artist_name = "DMX"
                        ovM?.song_location = "DMX"
                        ovM?.song_year = "1998"
                        ovM?.track_name = "Slippin"
                        ovM?.lyrics_name = "dmxlippin" **/

                        ovM?.album_art = "Speechless_img"
                        ovM?.artist_name = "Dan + Shay"
                        ovM?.song_location = "Speechless"
                        ovM?.song_year = "2018"
                        ovM?.track_name = "Speechless"
                        ovM?.lyrics_name = "speechless"

                        addSongDetailRepository.addPlaylist(ovM)
                    }
                }
            }
        }
    }


}