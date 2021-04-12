package com.epam.task3.specification.sort_specification.impl;


import com.epam.task3.entity.Cube;
import com.epam.task3.specification.sort_specification.CubeSortSpecificationInterface;

import java.util.Comparator;

/*
FINISH CLASS
 */
public class CubeSortSpecificationByIdThenName implements CubeSortSpecificationInterface {
    @Override
    public int compare(Cube o1, Cube o2) {
        Comparator.comparing(Cube::getId).thenComparing(Cube::getName);
        return 0;//this class isnt ended.
    }

}
