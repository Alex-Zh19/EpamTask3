package com.epam.task3.util;

public class Util {
    private static int id = 0;

    private Util(){
    }

    public static int getId(){
        return id++;
    }
}
