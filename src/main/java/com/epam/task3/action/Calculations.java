package com.epam.task3.action;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;

public class Calculations {

    public int cubeAreaCalculation(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
        int result = cube.getSideLength() * cube.getSideLength() * 6;
        return result;
    }

    public int cubeVolumeCalculation(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
        int result = cube.getSideLength() *
                cube.getSideLength() *
                cube.getSideLength();
        return result;
    }

    public int cubePerimeterCalculation(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
        int result = cube.getSideLength() * 12;
        return result;
    }

}
