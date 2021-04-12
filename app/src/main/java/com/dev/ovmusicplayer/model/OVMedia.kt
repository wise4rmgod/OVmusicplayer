package com.dev.ovmusicplayer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ovmedia")
data class OVMedia(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var artist_name: String? = null,
    var track_name: String? = null,
    var album_art: String? = null,
    var song_year: String? = null,
    var song_location: String? = null,
    var lyrics_location: String? = null
)

