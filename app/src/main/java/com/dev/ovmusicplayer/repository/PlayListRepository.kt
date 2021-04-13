package com.dev.ovmusicplayer.repository

import androidx.lifecycle.LiveData
import com.dev.ovmusicplayer.db.AppDatabase
import com.dev.ovmusicplayer.model.OVMedia
import javax.inject.Inject

class PlayListRepository @Inject constructor(appDatabase: AppDatabase) {
    private val playlistDAO = appDatabase.playlistdao()

    fun getplaylist(): LiveData<List<OVMedia>> {
        return playlistDAO.showallplaylist()
    }
}