package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;

import java.util.Comparator;

public class CubeSortSpecificationByIdAndName implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        CubeSortSpecificationById cubeSortSpecificationById=new CubeSortSpecificationById();
        CubeSortSpecificationByName cubeSortSpecificationByName=new CubeSortSpecificationByName();
        Comparator<Cube> cubeSortSpecificationByIdAndName =cubeSortSpecificationById.thenComparing(cubeSortSpecificationByName);
        return  cubeSortSpecificationByIdAndName.compare(o1,o2);
    }
}
