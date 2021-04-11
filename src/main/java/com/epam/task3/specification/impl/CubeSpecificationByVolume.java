package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;

public class CubeSpecificationByVolume implements CubeSpecificationInterface {
    @Override
    public boolean specified(Cube cube) {
        return false;
    }
}
