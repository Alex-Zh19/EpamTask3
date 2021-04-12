package com.epam.task3.specification.find_specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.find_specification.CubeFindSpecificationInterface;

public class CubeFindSpecificationById implements CubeFindSpecificationInterface {
    private String desiredId;

    public CubeFindSpecificationById(String desiredId){
        this.desiredId=desiredId;
    }

    @Override
    public boolean specified(Cube cube) {
        return (cube.getId().equals(desiredId));
    }
}
