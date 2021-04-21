package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecificationInterface;

public class CubeFindSpecificationByVolume implements CubeFindSpecificationInterface {
    private int desiredVolumeMin;
    private int desiredVolumeMax;

    public CubeFindSpecificationByVolume(int desiredVolumeMin, int desiredVolumeMax) {
        this.desiredVolumeMin = desiredVolumeMin;
        this.desiredVolumeMax = desiredVolumeMax;
    }

    @Override
    public boolean specified(Cube cube) {
        double volume = cube.getSideLength() *
                cube.getSideLength() *
                cube.getSideLength();
        return (volume >= desiredVolumeMin) && (volume <= desiredVolumeMax);
    }
}
