package com.epam.task3.action.cube_action;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;

public class Calculations {

    public double cubeAreaCalculation(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
        double result = cube.getSideLength() * cube.getSideLength() * 6;
        return result;
    }

    public double cubeVolumeCalculation(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
        double result = cube.getSideLength() *
                cube.getSideLength() *
                cube.getSideLength();
        return result;
    }

    public double cubePerimeterCalculation(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
        double result = cube.getSideLength() * 12;
        return result;
    }

}
