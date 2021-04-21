package com.epam.task3.specification.impl;


import com.epam.task3.entity.Cube;

import java.util.Comparator;


public class CubeSortSpecificationByName implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
