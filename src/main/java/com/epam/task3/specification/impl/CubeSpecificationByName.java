package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;

public class CubeSpecificationByName implements CubeSpecificationInterface {
    private String desiredName;

    public CubeSpecificationByName(String desiredName) {
        this.desiredName = desiredName;
    }

    @Override
    public boolean specified(Cube cube) {
        return desiredName.equals(cube.getName());
    }
}
