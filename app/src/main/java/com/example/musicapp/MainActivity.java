package com.example.musicapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Song> songs;
    public static ArrayList<Song> favouriteSongs;
    private ArrayList<Song> found;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setLogo(R.drawable.music_icon_32);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle("  Music Player");
        }

        songs = new ArrayList<Song>();

        songs.add(new Song("Cold (Acoustic)","James Blunt", R.drawable.james_blunt_cold));
        songs.add(new Song("Breathe","Fleurie", R.drawable.fleurie_breathe));
        songs.add(new Song("Ghost Train","Áine", R.drawable.aine_ghost_train));
        songs.add(new Song("damage :(","Naaz", R.drawable.naaz_damage));
        songs.add(new Song("Why","Skinny Living", R.drawable.why_skinny_living));
        songs.add(new Song("It's You","Ali Gatie", R.drawable.ali_gatie_its_you));
        songs.add(new Song("Sorry","Halsey", R.drawable.halsy_sorry));
        songs.add(new Song("Flames(feat. Jungleboi)","R3HAB and ZAYN", R.drawable.r3hab_and_zayn_jungleboi_flames));
        songs.add(new Song("Dance Monkey","Tones and I", R.drawable.tones_and_i_dance_monkey));
        songs.add(new Song("The Box","Roddy Rich", R.drawable.roddy_rich_the_box));
        songs.add(new Song("Heartbreak Hotel","Sophia Ayana (AYANA)", R.drawable.sophia_ayana_heartbreak_hotel));
        songs.add(new Song("HIGHEST IN THE ROOM","Travis Scott", R.drawable.travis_scott_highest_in_the_room));

        favouriteSongs = new ArrayList<Song>();
        found = new ArrayList<Song>();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_accent_24dp);
        tabLayout.getTabAt(0).setText(R.string.tabHome);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_album_24dp);
        tabLayout.getTabAt(1).setText(R.string.tabAlbums);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite_24dp);
        tabLayout.getTabAt(2).setText(R.string.tabFavourites);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_search_24dp);
        tabLayout.getTabAt(3).setText(R.string.tabSearch);

        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.colorAccent);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.tabContentColor);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Song> getFavouriteSongs() {
        return favouriteSongs;
    }

    public void setFavouriteSongs(ArrayList<Song> favouriteSongs) {
        this.favouriteSongs = favouriteSongs;
    }


    public void playingSong(int index, int arrayNo)
    {
        Intent playingActivityIntent = new Intent(MainActivity.this, PlayingActivity.class);
        if(arrayNo == 0)
            playingActivityIntent.putExtra("songs", songs);
        else if(arrayNo == 1)
            playingActivityIntent.putExtra("songs", favouriteSongs);
        else
            playingActivityIntent.putExtra("songs", found);

        playingActivityIntent.putExtra("index", index);
        startActivity(playingActivityIntent);
    }

    public ArrayList<Song> getFoundArray() {
        return found;
    }
}
