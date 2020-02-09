package com.example.quizmaybe;

import java.io.Serializable;

public class Score implements Serializable {

    public static byte Score = 0;

    public byte addPoint(){
        return Score++;
    }
}
