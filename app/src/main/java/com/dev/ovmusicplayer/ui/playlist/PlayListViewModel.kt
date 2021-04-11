package com.dev.ovmusicplayer.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.repository.PlayListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayListViewModel : ViewModel() {
    private val playListRepository: PlayListRepository? = null
    var ovMedia: MutableLiveData<OVMedia> = MutableLiveData()

    init {
        ovMedia.value = OVMedia()
    }

    fun getPlayList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }
        }
    }
}