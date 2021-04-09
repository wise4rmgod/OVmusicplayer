package com.dev.ovmusicplayer.ui.dashboard

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.dev.ovmusicplayer.R
import com.dev.ovmusicplayer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var def: ColorStateList? = null
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.hide()
        navController = findNavController(R.id.nav_host_fragment)

        binding.customeTab.item2.setOnClickListener {

            // binding.customeTab.item1.setTextColor(def)
            binding.customeTab.item2.setTextColor(Color.BLACK)
            binding.customeTab.item3.setTextColor(Color.BLACK)
            val size = binding.customeTab.item2.width
            binding.customeTab.select.animate().x(size.toFloat()).duration = 100
            navController?.navigate(R.id.SecondFragment)
        }
        binding.customeTab.item1.setOnClickListener {

            binding.customeTab.select.animate().x(0F).duration = 100
            binding.customeTab.item1.setTextColor(Color.BLACK)
            // binding.customeTab.item2.setTextColor(def)
            // binding.customeTab.item3.setTextColor(def)
            navController?.navigate(R.id.FirstFragment)
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

}