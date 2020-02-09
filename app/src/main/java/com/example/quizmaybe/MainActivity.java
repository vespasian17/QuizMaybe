package com.example.quizmaybe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnStart;
    Button btnScore;
    private MediaPlayer sound;
    Score score;
    ConstraintLayout mainl;

    Fragment Fragment1 = FirstFragment.newInstance(score);

    @Override
    protected void onResume() {
        super.onResume();
        sound.start();
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainl = findViewById(R.id.main_menu);

        btnStart = findViewById(R.id.btnStart);
        btnScore = findViewById(R.id.btnScore);
        sound = MediaPlayer.create(this, R.raw.maintheme);
        soundPlay(sound);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        btnStart.setOnClickListener(this);
        btnStart.setText("It's worked");
        getSupportFragmentManager().beginTransaction()
                .add(mainl.getId(), Fragment1)
                .commit();
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
