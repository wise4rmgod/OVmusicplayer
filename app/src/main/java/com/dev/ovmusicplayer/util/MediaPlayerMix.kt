package com.dev.ovmusicplayer.util

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import com.dev.ovmusicplayer.R
import java.util.*
import java.util.concurrent.TimeUnit

object MediaPlayerMix {
    var mPlayer: MediaPlayer? = null
    private var oTime = 0
    private var sTime: Int = 0
    private var eTime: Int = 0
    private var fTime: Int = 5000
    private var bTime: Int = 5000
    private val hdlr: Handler = Handler()

    fun play(
        seekBar: SeekBar?,
        start_time: TextView?,
        song_time: TextView?,
        pausebtn: ImageView?,
        playbtn: ImageView?
    ) {

        mPlayer?.start()
        eTime = mPlayer?.duration?.toLong()!!.toInt()
        sTime = mPlayer?.currentPosition?.toLong()!!.toInt()

        if (oTime == 0) {
            seekBar?.max = eTime
            oTime = 1
        }

        song_time?.text = String.format(
            "%d min, %d sec", java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(eTime.toLong()),
            java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(eTime.toLong()) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(
                java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(eTime.toLong())
            )
        )

        start_time?.text = String.format(
            "%d min, %d sec", java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(sTime.toLong()),
            java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(sTime.toLong()) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(
                java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(sTime.toLong())
            )
        )

        seekBar?.progress = sTime
        // hdlr.postDelayed(updateSongTime, 100)
        pausebtn?.visibility = View.VISIBLE
        playbtn?.visibility = View.GONE

    }

    fun pause(pausebtn: ImageView?, playbtn: ImageView?) {
        mPlayer?.pause()
        pausebtn?.visibility = View.GONE
        playbtn?.visibility = View.VISIBLE
    }

    fun forward(context: Context, playbtn: ImageView?) {
        if (sTime + fTime <= eTime) {
            sTime += fTime
            mPlayer?.seekTo(sTime)
        } else {
            Toast.makeText(
                context,
                "Cannot jump forward 5 seconds",
                Toast.LENGTH_SHORT
            ).show()
        }
        if (!playbtn?.isEnabled!!) {
            playbtn.isEnabled = true
        }
    }

    fun rewind(context: Context, playbtn: ImageView?) {

        if (sTime - bTime > 0) {
            sTime -= bTime
            mPlayer!!.seekTo(sTime)
        } else {
            Toast.makeText(
                context,
                "Cannot jump backward 5 seconds",
                Toast.LENGTH_SHORT
            ).show()
        }
        if (!playbtn?.isEnabled!!) {
            playbtn.isEnabled = true
        }

    }

    fun skip_next(navController: NavController) {
        navController.navigate(R.id.SecondFragment)
    }

    fun skip_back(navController: NavController) {
        navController.navigate(R.id.SecondFragment)
    }

    fun seekbar_progress(context: Context, seekBar: SeekBar?) {

        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                if (p2) {
                    mPlayer?.seekTo(progress)

                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        mPlayer?.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                try {
                    mPlayer?.start()
                    seekBar?.progress = sTime
                    mPlayer?.isLooping = true
                } catch (e: Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    fun updateSongTime(
        seekBar: SeekBar?,
        start_time: TextView?
    ) {

    }

    class upd {
        var seekBar: SeekBar? = null
        var start_time: TextView? = null
        val updateSongTime: Runnable = object : Runnable {
            override fun run() {
                sTime = mPlayer?.currentPosition!!
                start_time!!.text = String.format(
                    "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime.toLong()),
                    TimeUnit.MILLISECONDS.toSeconds(sTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(sTime.toLong())
                    )
                )
                seekBar?.progress = sTime
                hdlr.postDelayed(this, 100)
            }
        }
    }


}