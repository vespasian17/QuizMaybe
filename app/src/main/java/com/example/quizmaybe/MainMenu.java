package com.example.quizmaybe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainMenu extends Fragment{

    Button btnStart;
    Button btnScore;
    ConstraintLayout mainl;
    Score score;
    ArrayList<FirstFragment> fragments = new ArrayList<>();
    FirstFragment Fragment1;


    public static MainMenu newInstance(Score score) {
        MainMenu Fragment = new MainMenu();
        Bundle args = new Bundle();
        args.putSerializable("score", score);
        Fragment.setArguments(args);
        return Fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        score = (Score) getArguments().getSerializable("score");

        fragments.add(new FirstFragment("one", "two", "three", "four").newInstance(score));
        fragments.add(new FirstFragment("ашму", "ышч", "ыумут", "ушпре").newInstance(score));
        Fragment1 = fragments.get(1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        mainl = view.findViewById(R.id.activity_main);
        btnStart = view.findViewById(R.id.btnStart);
        btnScore = view.findViewById(R.id.btnScore);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(MainActivity.containerid, Fragment1)
                        .commit();
            }
        });
        return view;
    }
}
