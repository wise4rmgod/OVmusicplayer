package com.dev.ovmusicplayer.repository

import com.dev.ovmusicplayer.db.AppDatabase

class PlayListRepository(appDatabase: AppDatabase) {
    private val playlistDAO = appDatabase.playlistdao()

    fun getplaylist() = playlistDAO.showallplaylist()
}