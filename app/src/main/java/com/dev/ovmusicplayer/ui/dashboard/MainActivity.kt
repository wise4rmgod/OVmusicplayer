package com.dev.ovmusicplayer.ui.dashboard

import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.databinding.ActivityMainBinding
import com.dev.ovmusicplayer.util.MediaPlayerMix
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.hide()
        navController = findNavController(R.id.nav_host_fragment)

        // call the mediaplayer object
        MediaPlayerMix.mPlayer = MediaPlayer.create(this, R.raw.higher)
        //
        MediaPlayerMix.updateSongTime(
            binding.ovButtons.ovSeekbar,
            binding.ovButtons.ovStarttime
        )

        // get the update of seekbar
        val upt = MediaPlayerMix.upd()
        upt.seekBar = binding.ovButtons.ovSeekbar
        upt.start_time = binding.ovButtons.ovStarttime
        upt.updateSongTime

        binding.ovButtons.ovPlay.setOnClickListener {
            MediaPlayerMix.play(
                binding.ovButtons.ovSeekbar,
                binding.ovButtons.ovStarttime,
                binding.ovButtons.ovEndtime,
                binding.ovButtons.ovPause,
                binding.ovButtons.ovPlay
            )
        }

        binding.ovButtons.ovPause.setOnClickListener {
            MediaPlayerMix.pause(
                binding.ovButtons.ovPause,
                binding.ovButtons.ovPlay
            )
        }

        binding.ovButtons.ovForward.setOnClickListener {
            MediaPlayerMix.forward(this, binding.ovButtons.ovPlay)
        }

        binding.ovButtons.ovRewind.setOnClickListener {
            MediaPlayerMix.rewind(this, binding.ovButtons.ovPlay)
        }

        binding.ovButtons.ovSkipback.setOnClickListener { }

        binding.ovButtons.ovSkipnext.setOnClickListener { }

        binding.upnextBtn.setOnClickListener {
            // add animation here before submitting
            navController?.navigate(R.id.playListFragment)
        }
        // seekbar
        binding.ovButtons.ovSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                if (p2) {
                    MediaPlayerMix.mPlayer?.seekTo(progress)

                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        binding.customeTab.item2.setOnClickListener {

            // binding.customeTab.item1.setTextColor(def)
            binding.customeTab.item2.setTextColor(Color.BLACK)
            binding.customeTab.item3.setTextColor(Color.BLACK)
            val size = binding.customeTab.item2.width
            binding.customeTab.select.animate().x(size.toFloat()).duration = 100
            navController?.navigate(R.id.SecondFragment)
        }
        binding.customeTab.item1.setOnClickListener {
            details_animation()

        }

        binding.customeTab.item3.setOnClickListener {
            //  binding.customeTab.item1.setTextColor(def)
            binding.customeTab.item3.setTextColor(Color.BLACK)
            //   binding.customeTab.item2.setTextColor(def)
            val size = binding.customeTab.item2.width * 2
            binding.customeTab.select.animate().x(size.toFloat()).duration = 100
            navController?.navigate(R.id.visualizationFragment)
        }

    }


    fun details_animation() {
        binding.customeTab.select.animate().x(0F).duration = 100
        binding.customeTab.item1.setTextColor(Color.BLACK)
        // binding.customeTab.item2.setTextColor(def)
        // binding.customeTab.item3.setTextColor(def)
        navController?.navigate(R.id.FirstFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStop() {
        super.onStop()
        MediaPlayerMix.mPlayer?.release()
    }

}