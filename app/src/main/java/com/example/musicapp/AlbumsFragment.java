package com.example.musicapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumsFragment extends Fragment {

    private AlbumsAdapter mAdapter;
    private RecyclerView mAlbumsList;
    private ArrayList<Album> albums;

    public AlbumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_albums, container, false);

        albums = new ArrayList<Album>();
        for (int i = 0; i < 20; i++) {
            albums.add(new Album("ِAlbum Name " + i));
        }

        mAlbumsList = rootView.findViewById(R.id.rv_albums);


        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mAlbumsList.setLayoutManager(layoutManager);

        mAlbumsList.setHasFixedSize(true);


        mAdapter = new AlbumsAdapter(albums);
        mAlbumsList.setAdapter(mAdapter);

        return rootView;
    }

}
