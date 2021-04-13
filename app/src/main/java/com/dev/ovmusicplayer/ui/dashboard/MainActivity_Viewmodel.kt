package com.dev.ovmusicplayer.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.repository.AddSongDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                        /**   ovM?.album_art = R.drawable.dmx_slippin
                        ovM?.artist_name = "DMX"
                        ovM?.song_location = R.raw.dmxslippin
                        ovM?.song_year = "1998"
                        ovM?.track_name = "Slippin"
                        ovM?.lyrics_name = "dmxlippin" **/

                        ovM?.album_art = R.drawable.speechless
                        ovM?.artist_name = "Dan + Shay"
                        ovM?.song_location = R.raw.speechless
                        ovM?.song_year = "2018"
                        ovM?.track_name = "Speechless"
                        ovM?.lyrics_name = "speechless"

                        addSongDetailRepository.addPlaylist(it)
                    }
                }
            }
        }
    }
}