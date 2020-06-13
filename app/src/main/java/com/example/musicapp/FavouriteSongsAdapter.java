package com.example.musicapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouriteSongsAdapter extends RecyclerView.Adapter<FavouriteSongsAdapter .FavouriteSongViewHolder> {

    private ArrayList<Song> favouriteSongs;
    final private ListItemClickListener mOnClickListener;


    public FavouriteSongsAdapter (ArrayList<Song> favouriteSongs, ListItemClickListener mOnClickListener) {
        this.favouriteSongs = favouriteSongs;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public int getItemCount() {
        return favouriteSongs.size();
    }

    @Override
    public FavouriteSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_song, parent, false);
        return new FavouriteSongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavouriteSongViewHolder holder, int position) {
        holder.bind(position);
    }

    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }

    public class FavouriteSongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView songImage;
        TextView songName, artistName;

        FavouriteSongViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            songImage = (ImageView)itemView.findViewById(R.id.song_image);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            songName = (TextView) itemView.findViewById(R.id.song_name);

            itemView.setOnClickListener(this);

        }
        void bind(int position) {
            Song song = favouriteSongs.get(position);

            if (song.hasImage()) {
                songImage.setImageResource(song.getImageResourceId());
            }

            artistName.setText(song.getArtistName());
            songName.setText(song.getSongName());
        }
        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClick(getAdapterPosition());
        }
    }

}
