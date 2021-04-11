package com.dev.ovmusicplayer.db

import androidx.room.*
import com.dev.ovmusicplayer.model.OVMedia

@Dao
interface PlayListDAO {
    @Query("SELECT * FROM ovmedia")
    fun showallplaylist(): List<OVMedia>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ovmedia: OVMedia?)

    @Delete
    fun delete(ovmedia: OVMedia)
}