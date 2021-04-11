package com.dev.ovmusicplayer.di

import android.content.Context
import androidx.room.Room
import com.dev.ovmusicplayer.db.AppDatabase
import com.dev.ovmusicplayer.db.PlayListDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "ovmedia.db"
        )
            .build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): PlayListDAO {
        return database.playlistdao()
    }
}