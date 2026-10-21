package com.zarj.ahClickAgain;

import android.util.DisplayMetrics;

public class StaticMetrics {
    static DisplayMetrics displayMetrics = new DisplayMetrics();


    static int width = 0;
    static int height = 0;

    public static void updateMectrics(){
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }
    public static int getWidth(){
        return width;
    }
    public static int getHeight(){
        return width;
    }
}
