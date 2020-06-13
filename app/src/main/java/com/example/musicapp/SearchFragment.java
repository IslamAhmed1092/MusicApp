package com.example.musicapp;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SongsAdapter.ListItemClickListener{

    private SongsAdapter mAdapter;
    private RecyclerView mSongsList;
    private ArrayList<Song> songs;
    private ArrayList<Song> favouriteSongs;
    private ArrayList<Song> found;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        songs = ((MainActivity)getActivity()).getSongs();
        favouriteSongs = ((MainActivity)getActivity()).getFavouriteSongs();

        mSongsList = rootView.findViewById(R.id.rv_songs);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mSongsList.setLayoutManager(layoutManager);

        found = ((MainActivity) getActivity()).getFoundArray();
        mAdapter = new SongsAdapter(found, favouriteSongs, SearchFragment.this);
        mSongsList.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_item, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()) {
                    found.clear();
                    for (Song song : songs) {
                        if (song.getSongName().contains(newText))
                            found.add(song);
                    }

                    mAdapter = new SongsAdapter(found, favouriteSongs, SearchFragment.this);
                    mSongsList.setAdapter(mAdapter);
                }
                else {
                    found.clear();
                    mAdapter = new SongsAdapter(found, favouriteSongs, SearchFragment.this);
                    mSongsList.setAdapter(mAdapter);
                }
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        ((MainActivity)getActivity()).playingSong(clickedItemIndex, 2);
    }
}
