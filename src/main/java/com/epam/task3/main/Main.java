package com.epam.task3.main;

import com.epam.task3.exception.CubeException;

public class Main {
    private static final String REG_TO_CREATE_ARRAY_FOR_POINT = "[,]|[;]";
    public static void main(String[] args) throws CubeException {
        String string="name   :   (43 ;45,  56),    1122    ";
        String name = string.substring(0, string.indexOf(':'));
        name = name.trim();
        String valueForCenter=string.substring(string.indexOf('(')+1,string.indexOf(')'));
        System.out.println(name+"heh");
        System.out.println(valueForCenter);

        int sideLen=findSideLengthInString(string);
        String [] stringNumeralsForPoint=valueForCenter.split(REG_TO_CREATE_ARRAY_FOR_POINT);
        int[]numeralsForPoint=new int[4];
        for(int i=0;i<3;i++){
            numeralsForPoint[i]=Integer.parseInt(stringNumeralsForPoint[i].trim());
        }
        numeralsForPoint[numeralsForPoint.length-1]=sideLen;
        for(int i=0;i<numeralsForPoint.length;i++){
            System.out.println(numeralsForPoint[i]+" xd");
        }
    }
    private static int findSideLengthInString(String string) throws CubeException {
        String lastSymbolsWithSideLength=string.substring(string.indexOf(')')+1);
        int positionOfFirstSymbolOfRadius=0;
        for(int i=lastSymbolsWithSideLength.length()-1;i>=0;i--){
            if(lastSymbolsWithSideLength.charAt(i)==';'||lastSymbolsWithSideLength.charAt(i)==','){
                positionOfFirstSymbolOfRadius=i;
            }
        }
        String value=lastSymbolsWithSideLength.substring(positionOfFirstSymbolOfRadius+1);
        value=value.trim();
        Integer sideLength=Integer.parseInt(value);
        return sideLength;
    }


}
