package com.dev.ovmusicplayer.repository

import com.dev.ovmusicplayer.db.AppDatabase
import com.dev.ovmusicplayer.model.OVMedia

class AddSongDetailRepository(appDatabase: AppDatabase) {
    private val playlistDAO = appDatabase.playlistdao()

    fun addPlaylist(ovMedia: OVMedia?) {
        playlistDAO.insert(ovMedia)
    }
}