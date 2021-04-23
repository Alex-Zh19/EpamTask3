package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecification;

public class CubeFindSpecificationByVolume implements CubeFindSpecification {
    private int desiredVolumeMin;
    private int desiredVolumeMax;

    public CubeFindSpecificationByVolume(int desiredVolumeMin, int desiredVolumeMax) {
        this.desiredVolumeMin = desiredVolumeMin;
        this.desiredVolumeMax = desiredVolumeMax;
    }

    @Override
    public boolean specified(Cube cube) {
        double volume = Math.pow(cube.getSideLength(), 3);
        return (volume >= desiredVolumeMin) && (volume <= desiredVolumeMax);
    }
}
