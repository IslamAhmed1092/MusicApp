package com.example.musicapp;

public class Album {

    private String mAlbumName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Album(String albumName) {
        this.mAlbumName = albumName;
    }

    public Album(String albumName, int imageResourceId) {
        this.mImageResourceId = imageResourceId;
        this.mAlbumName = albumName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
