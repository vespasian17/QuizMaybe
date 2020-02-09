package com.example.quizmaybe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    Score score;
    public Button btn1, btn2, btn3, btn4;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        btn1 =  view.findViewById(R.id.btn1);

        final Fragment Fragment2 = SecondFragment.newInstance(score);

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.layout.first_fragment, Fragment2)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

}
