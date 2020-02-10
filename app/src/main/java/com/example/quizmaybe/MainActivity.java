package com.example.quizmaybe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private MediaPlayer sound;
    LinearLayout container;
    Score score;
    static int containerid;

    @Override
    protected void onResume() {
        super.onResume();
        sound.
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty);

        sound = MediaPlayer.create(this, R.raw.maintheme);
        soundPlay(sound);

        Fragment main = MainMenu.newInstance(score);
        container = findViewById(R.id.empty);
        containerid = container.getId();

        FragmentManager fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fm.beginTransaction()
                    .add(containerid, main)
                    .commit();
        }
    }

    public void soundPlay(MediaPlayer sound){
        sound.start();
        sound.setLooping(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sound.pause();
    }

}
