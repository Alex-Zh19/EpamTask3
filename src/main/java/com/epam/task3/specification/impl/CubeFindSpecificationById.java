package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecification;

public class CubeFindSpecificationById implements CubeFindSpecification {
    private String desiredId;

    public CubeFindSpecificationById(String desiredId) {
        this.desiredId = desiredId;
    }

    @Override
    public boolean specified(Cube cube) {
        return (cube.getId().equals(desiredId));
    }
}
