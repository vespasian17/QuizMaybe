package com.example.quizmaybe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Random;

public class FirstFragment extends Fragment {

    Score score;
    public Button btn1, btn2, btn3, btn4;
    int rnd1, rnd2, rnd3, rnd4;
    ArrayList<String> mRndText = new ArrayList<>();
    Random random = new Random();

    public static FirstFragment newInstance(Score score) {
        FirstFragment Fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putSerializable("score", score);
        Fragment.setArguments(args);
        return Fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        score = (Score) getArguments().getSerializable("score");
        mRndText.add("Найс");
        mRndText.add("Моды");
        mRndText.add("Мусор");
        mRndText.add("Жирный");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        btn1 =  view.findViewById(R.id.btn1);
        btn2 =  view.findViewById(R.id.btn2);
        btn3 =  view.findViewById(R.id.btn3);
        btn4 =  view.findViewById(R.id.btn4);

        rnd1 = random.nextInt(4);
        btn1.setText(mRndText.get(rnd1));
        mRndText.remove(rnd1);

        rnd2 = random.nextInt(3);
        btn2.setText(mRndText.get(rnd2));
        mRndText.remove(rnd2);

        rnd3 = random.nextInt(2);
        btn3.setText(mRndText.get(rnd3));
        mRndText.remove(rnd3);

        btn4.setText(mRndText.get(0));

        final Fragment Fragment2 = SecondFragment.newInstance(score);

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.layout.first_fragment, Fragment2)
                        .addToBackStack(null)
                        .commit();
                switch (v.getId()) {
                    case R.id.btn1: if (btn1.getText().equals("Жирный"))
                        score.addPoint();
                        break;
                    case R.id.btn2:  break;
                    case R.id.btn3:  break;
                    case R.id.btn4:  break;
                }
            }
        });
        return view;
    }
}
