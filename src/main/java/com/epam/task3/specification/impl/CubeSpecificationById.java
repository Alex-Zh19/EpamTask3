package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;

public class CubeSpecificationById implements CubeSpecificationInterface {
    private int desiredId;

    public CubeSpecificationById(int desiredId){
        this.desiredId=desiredId;
    }

    @Override
    public boolean specified(Cube cube) {
        return cube.getId()==desiredId;
    }
}
