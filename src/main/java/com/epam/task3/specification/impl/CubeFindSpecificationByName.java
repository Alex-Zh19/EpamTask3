package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecification;

public class CubeFindSpecificationByName implements CubeFindSpecification {
    private String desiredName;

    public CubeFindSpecificationByName(String desiredName) {
        this.desiredName = desiredName;
    }

    @Override
    public boolean specified(Cube cube) {
        return desiredName.equals(cube.getName());
    }
}
