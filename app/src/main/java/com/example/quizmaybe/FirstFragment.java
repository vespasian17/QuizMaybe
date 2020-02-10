package com.example.quizmaybe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Random;

public class FirstFragment extends Fragment implements View.OnClickListener {

    Score score;
    Button btn1, btn2, btn3, btn4;
    private int rnd1, rnd2, rnd3;
    ArrayList<String> mRndText = new ArrayList<>();
    String one, two, three, four;
    Random random = new Random();

    final Fragment Fragment2 = SecondFragment.newInstance(score);

    public FirstFragment(String one, String two, String three, String four){
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public FirstFragment(){

    }

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
        mRndText.add(one);
        mRndText.add(two);
        mRndText.add(three);
        mRndText.add(four);
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

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(MainActivity.containerid, Fragment2)
                .addToBackStack(null)
                .commit();
        switch (v.getId()) {
            case R.id.btn1: if (btn1.getText().equals(one))
                score.addPoint();
                break;
            case R.id.btn2:  if (btn2.getText().equals(one))
                score.addPoint();
                break;
            case R.id.btn3:  if (btn3.getText().equals(one))
                score.addPoint();
                break;
            case R.id.btn4: if (btn4.getText().equals(one))
                score.addPoint();
                break;
        }
    }
}
