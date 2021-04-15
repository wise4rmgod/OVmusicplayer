package com.dev.ovmusicplayer.adapter

import android.content.Context
import android.os.Environment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.dev.ovmusicplayer.databinding.ListPlaylistBinding
import com.dev.ovmusicplayer.model.OVMedia
import java.io.File

class PlaylistAdapter(
    private var dataList: List<OVMedia>
) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPlaylistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(
            binding
        )

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)



        holder.artist_name.text = dataModel.artist_name
        holder.song_title.text = dataModel.track_name
        dataModel.album_art?.let {
            val fileName = it + ".png"
            val imglocationFile: File = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString() + "/" + fileName
            )
            holder.album_image.load(imglocationFile.absoluteFile)
        }

        holder.itemView.setOnClickListener {

            val bundle = bundleOf()
            dataModel.id?.let { it1 -> bundle.putInt("id", it1) }

            //  holder.itemView.findNavController()
            //   .navigate(R.id.action_navigation_home_to_detailsViewFragment, bundle)
        }

    }

    class ViewHolder(binding: ListPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {
        var artist_name: TextView = binding.artistName
        var song_title: TextView = binding.songTitle
        var album_image: ImageView = binding.playlistImage
    }


}
