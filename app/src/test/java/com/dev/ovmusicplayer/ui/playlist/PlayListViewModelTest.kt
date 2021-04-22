package com.dev.ovmusicplayer.ui.playlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.dev.ovmusicplayer.MyApplication
import com.dev.ovmusicplayer.db.AppDatabase
import com.dev.ovmusicplayer.model.OVMedia
import com.dev.ovmusicplayer.repository.PlayListRepository
import com.dev.ovmusicplayer.utils.observeOnce
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

// @RunWith(JUnit4::class)
class PlayListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var playListViewModel: PlayListViewModel
    lateinit var playListRepository: PlayListRepository
    private lateinit var db: AppDatabase
    val addsong = OVMedia()

    @Before
    fun setUp() {
        val context = MyApplication()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        playListRepository = PlayListRepository(db)
        playListViewModel = PlayListViewModel(playListRepository)
        db.playlistdao().insert(addsong)
    }

   // @Test
    fun getPlayList() {
        addsong.apply {
            id = 1
            artist_name = "john"
            track_name = "joli"
            album_art = "madli"
            song_location = "devicestorage"
            song_year = "1798"
            lyrics_name = "joli"
        }
        runBlocking {
            playListRepository.getplaylist()
            playListViewModel.list.observeOnce {

                assertNull(it)
            }
        }

    }

    @After
    fun tearDown() {
    }
}