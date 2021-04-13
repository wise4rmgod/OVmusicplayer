package com.dev.ovmusicplayer.ui.playlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.repository.PlayListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayListViewModel @ViewModelInject constructor(
    private val playListRepository: PlayListRepository
) :
    ViewModel() {
    val list: LiveData<List<OVMedia>> = playListRepository.getplaylist()
    var ovMedia: MutableLiveData<OVMedia> = MutableLiveData()

    fun getPlayList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (ovMedia.value != null) {
                    playListRepository.getplaylist()
                }
            }
        }
    }

}