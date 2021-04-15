package com.dev.ovmusicplayer.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dev.ovmusicplayer.MyApplication
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.repository.PlayListRepository
import com.dev.ovmusicplayer.ui.playlist.PlayListViewModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var playlistDao: PlayListDAO
    private lateinit var db: AppDatabase
    lateinit var playListViewModel: PlayListViewModel
    lateinit var playListRepository: PlayListRepository


    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<MyApplication>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        playlistDao = db.playlistdao()
        playListRepository = PlayListRepository(db)
        playListViewModel = PlayListViewModel(playListRepository)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        db.close()
    }

    @Test
    fun addSongs() = runBlocking {
        val addsong = OVMedia(
            1, "john", "joli", "madli",
            "1998", "devicestorage", "joli lyrics"
        )
        val you = playlistDao.insert(addsong)

        assertNotNull("this onject is not null", you)
    }

    @Test
    fun getPlaylist() {

       // val getp = playlistDao.showallplaylist()
        playListRepository.getplaylist()
        playListViewModel.list.observeForever {
            assertNull(it)
        }
       // assertNotNull(getp)
        // assertSame("expect a list of value", playlist_songs, getp)
    }
}