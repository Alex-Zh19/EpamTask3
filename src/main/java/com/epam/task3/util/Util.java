package com.epam.task3.util;

public class Util {
    private static int id = 0;

    private Util(){
    }

    public static String createId(String type){
        StringBuilder createId = new StringBuilder(type).append(id++);
        return createId.toString();
    }
}
