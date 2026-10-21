package com.zarj.ahClickAgain.utils;

public class Errors {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void error(String s){
        System.out.println(ANSI_RED+"[ERROR] "+s+ANSI_RESET);
    }
    public static void info(String s){System.out.println(ANSI_BLUE+"[INFO] "+s+ANSI_RESET);}
}
