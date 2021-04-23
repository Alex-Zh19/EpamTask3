package com.epam.task3.specification.impl;


import com.epam.task3.entity.Cube;

import java.util.Comparator;


public class CubeSortSpecificationByXCoordinate implements Comparator<Cube> {

    @Override
    public int compare(Cube o1, Cube o2) {
        int result = 0;
        if (o1.getCenterPoint().getX() > o1.getCenterPoint().getX()) {
            result = 1;
        } else if (o1.getCenterPoint().getX() < o1.getCenterPoint().getX()) {
            result = -1;
        }
        return result;
    }
}
