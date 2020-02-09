package com.example.quizmaybe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    public static FirstFragment newInstance(Score score) {
        FirstFragment Fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putSerializable("score", score);
        Fragment.setArguments(args);
        return Fragment;
    }
}
