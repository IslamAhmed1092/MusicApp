package com.example.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {

    private ArrayList<Album> albums;

    public AlbumsAdapter(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.bind(position);
    }



    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView albumImage;
        TextView albumName;

        AlbumViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            albumImage = (ImageView)itemView.findViewById(R.id.album_image);
            albumName = (TextView) itemView.findViewById(R.id.album_name);

        }
        void bind(int position) {
            Album album = albums.get(position);

            if (album.hasImage()) {
                albumImage.setImageResource(album.getImageResourceId());
            }
            albumName.setText(album.getAlbumName());
        }

        @Override
        public void onClick(View v) {

        }
    }

}
