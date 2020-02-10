package com.example.quizmaybe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Random;

public class MainMenu extends Fragment{

    Button btnStart;
    Button btnScore;
    ConstraintLayout mainl;
    private int rand1, rand2, rand3, rand4, rand5, rand6, rand7, rand8;
    Score score;
    ArrayList<FirstFragment> fragments = new ArrayList<>();
    ArrayList<FirstFragment> objects = new ArrayList<>();
    FirstFragment Fragment1, Fragment2;
    Random random = new Random();


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
        fragments.add(new FirstFragment("ашму", "ышч", "ыумут", "ушпре").newInstance(score));
        fragments.add(new FirstFragment("ашму", "ышч", "ыумут", "ушпре").newInstance(score));
        rand1 = random.nextInt(4);
        Fragment1 = fragments.get(rand1);
        fragments.remove(rand1);

        rand2 = random.nextInt(3);
        Fragment2 = fragments.get(rand2);
        fragments.remove(rand2);

        objects.add(Fragment1);
        objects.add(Fragment2);
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
                        .replace(MainActivity.containerid, objects.get(random.nextInt(1)))
                        .commit();
            }
        });
        return view;
    }
}
