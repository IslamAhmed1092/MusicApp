package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity {

    int index;
    ArrayList<Song> songs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        songs = (ArrayList<Song>)getIntent().getSerializableExtra("songs");
        index = getIntent().getIntExtra("index", 0);

        final TextView songName = (TextView)findViewById(R.id.song_name);
        final TextView artist = (TextView)findViewById(R.id.artist_name);
        final ImageView songImage = (ImageView)findViewById(R.id.song_image);
        final ImageView playingIcon = (ImageView)findViewById(R.id.playing_icon);
        ImageView nextIcon = (ImageView)findViewById((R.id.right_arrow));
        ImageView previousIcon = (ImageView)findViewById(R.id.left_arrow);


        songName.setText(songs.get(index).getSongName());
        artist.setText(songs.get(index).getArtistName());
        if(songs.get(index).hasImage())
            songImage.setImageResource(songs.get(index).getImageResourceId());

        playingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playingIcon.getContentDescription().equals(getString(R.string.pause))) {

                    playingIcon.setImageResource(R.drawable.ic_play_circle_filled_72dp);
                    playingIcon.setContentDescription(getString(R.string.play));

                } else {

                    playingIcon.setImageResource(R.drawable.ic_pause_circle_filled_72dp);
                    playingIcon.setContentDescription(getString(R.string.pause));

                }
            }
        });

        nextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index != (songs.size() - 1))
                {
                    index++;
                    songName.setText(songs.get(index).getSongName());
                    artist.setText(songs.get(index).getArtistName());
                    if(songs.get(index).hasImage())
                        songImage.setImageResource(songs.get(index).getImageResourceId());
                }
            }
        });

        previousIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index != 0)
                {
                    index--;
                    songName.setText(songs.get(index).getSongName());
                    artist.setText(songs.get(index).getArtistName());
                    if(songs.get(index).hasImage())
                        songImage.setImageResource(songs.get(index).getImageResourceId());
                }
            }
        });
    }
}
