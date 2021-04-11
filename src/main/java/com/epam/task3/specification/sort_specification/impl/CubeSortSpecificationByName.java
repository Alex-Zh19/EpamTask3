package com.epam.task3.specification.sort_specification.impl;


import com.epam.task3.entity.Cube;
import com.epam.task3.specification.sort_specification.CubeSortSpecificationInterface;



public class CubeSortSpecificationByName implements CubeSortSpecificationInterface {
    @Override
    public int compare(Cube o1, Cube o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
