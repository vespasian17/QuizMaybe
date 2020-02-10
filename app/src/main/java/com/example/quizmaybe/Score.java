package com.example.quizmaybe;

import java.io.Serializable;

public class Score implements Serializable {

    public byte score = 0;

    public byte addPoint(){
        return score++;
    }
}
