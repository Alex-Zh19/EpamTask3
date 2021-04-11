package com.epam.task3.specification.sort_specification.impl;


import com.epam.task3.entity.Cube;
import com.epam.task3.specification.sort_specification.CubeSortSpecificationInterface;



public class CubeSortSpecificationByXCoordinate implements CubeSortSpecificationInterface {

    @Override
    public int compare(Cube o1, Cube o2) {
        int x1=(int)Math.round(o1.getCenterPoint().getX());
        int x2=(int)Math.round(o2.getCenterPoint().getX());
        return x1-x2;
    }
}
