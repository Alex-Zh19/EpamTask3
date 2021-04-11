package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;

public class CubeSpecificationByVolume implements CubeSpecificationInterface {
    private int desiredVolumeMin;
    private int desiredVolumeMax;
    public CubeSpecificationByVolume(int desiredVolumeMin,int desiredVolumeMax){
        this.desiredVolumeMin=desiredVolumeMin;
        this.desiredVolumeMax=desiredVolumeMax;
    }

    @Override
    public boolean specified(Cube cube) {
        int volume = cube.getSideLength() *
                cube.getSideLength() *
                cube.getSideLength();
        return (volume>=desiredVolumeMin)&&(volume<=desiredVolumeMax);
    }
}
