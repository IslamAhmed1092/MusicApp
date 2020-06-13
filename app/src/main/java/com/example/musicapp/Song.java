/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.musicapp;

import java.io.Serializable;

public class Song implements Serializable {

    private String mSongName;
    private String mArtistName;
    private boolean isFavourite;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Song(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
        isFavourite = false;
    }

    public Song(String songName, String artistName, int imageResourceId) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        isFavourite = false;
    }

    public String getSongName() {
        return mSongName;
    }

    public void setSongName(String mSongName) {
        this.mSongName = mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String mArtistName) {
        this.mArtistName = mArtistName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}