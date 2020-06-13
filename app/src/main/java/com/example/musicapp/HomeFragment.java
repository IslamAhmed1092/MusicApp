package com.example.musicapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements SongsAdapter.ListItemClickListener{

    private SongsAdapter mAdapter;
    private RecyclerView mSongsList;
    private ArrayList<Song> songs;
    private ArrayList<Song> favouriteSongs;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        songs = ((MainActivity)getActivity()).getSongs();
        favouriteSongs = ((MainActivity)getActivity()).getFavouriteSongs();

        mSongsList = rootView.findViewById(R.id.rv_songs);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mSongsList.setLayoutManager(layoutManager);

        mSongsList.setHasFixedSize(true);


        mAdapter = new SongsAdapter(songs, favouriteSongs, this);
        mSongsList.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        ((MainActivity)getActivity()).playingSong(clickedItemIndex, 0);
    }
}
