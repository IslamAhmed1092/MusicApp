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
public class FavouritesFragment extends Fragment implements FavouriteSongsAdapter.ListItemClickListener{

    private FavouriteSongsAdapter mAdapter;
    private RecyclerView mFavouriteSongsList;
    ArrayList<Song> favouriteSongs;
    public FavouritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);

        favouriteSongs = ((MainActivity)getActivity()).getFavouriteSongs();

        mFavouriteSongsList = rootView.findViewById(R.id.rv_songs);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mFavouriteSongsList.setLayoutManager(layoutManager);

        mFavouriteSongsList.setHasFixedSize(true);


        mAdapter = new FavouriteSongsAdapter(favouriteSongs, this);
        mFavouriteSongsList.setAdapter(mAdapter);

        return rootView;
    }
    @Override
    public void onListItemClick(int clickedItemIndex) {
        ((MainActivity)getActivity()).playingSong(clickedItemIndex, 1);

    }
}
