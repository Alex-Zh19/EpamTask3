package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;

public class CubeSpecificationByVolume implements CubeSpecificationInterface {
    private int desiredVolume;
    public CubeSpecificationByVolume(int desiredVolume){
        this.desiredVolume=desiredVolume;
    }

    @Override
    public boolean specified(Cube cube) {
        int volume = cube.getSideLength() *
                cube.getSideLength() *
                cube.getSideLength();
        return volume==desiredVolume;
    }
}
