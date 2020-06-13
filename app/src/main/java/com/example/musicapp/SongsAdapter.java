package com.example.musicapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

    private ArrayList<Song> songs;
    private ArrayList<Song> favouriteSongs;
    final private ListItemClickListener mOnClickListener;

    public SongsAdapter(ArrayList<Song> songs, ArrayList<Song> favouriteSongs, ListItemClickListener mOnClickListener) {
        this.songs = songs;
        this.favouriteSongs = favouriteSongs;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        holder.bind(position);
    }


    public ArrayList<Song> getFavouriteSongs() {
        return favouriteSongs;
    }

    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }

    public class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView songImage, favouriteImage;
        TextView songName, artistName;

        SongViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            songImage = (ImageView)itemView.findViewById(R.id.song_image);
            favouriteImage = (ImageView) itemView.findViewById(R.id.favourite);
            favouriteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Song song = songs.get(getAdapterPosition());
                    if(song.isFavourite()){
                        favouriteImage.setImageResource(R.drawable.ic_favorite_24dp);
                        song.setFavourite(false);
                        favouriteSongs.remove(song);
                        Toast.makeText(v.getContext(), "Removed from Favourites", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        favouriteImage.setImageResource(R.drawable.ic_favorite_accent_24dp);
                        song.setFavourite(true);
                        favouriteSongs.add(song);
                        Toast.makeText(v.getContext(), "Added To Favourites", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            songName = (TextView) itemView.findViewById(R.id.song_name);

            itemView.setOnClickListener(this);
        }
        void bind(int position) {
            Song song = songs.get(position);

            if (song.hasImage()) {
                songImage.setImageResource(song.getImageResourceId());
            }
            if(song.isFavourite()){
                favouriteImage.setImageResource(R.drawable.ic_favorite_accent_24dp);
            }
            else {
                favouriteImage.setImageResource(R.drawable.ic_favorite_24dp);
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
