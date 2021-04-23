package com.epam.task3.action.cube;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;

public class CubeCalculation {

    public double cubeAreaCalculation(Cube cube) throws CubeException {
        checkNotNull(cube);
        double result = Math.pow(cube.getSideLength(), 2) * 6;
        return result;
    }

    public double cubeVolumeCalculation(Cube cube) throws CubeException {
        checkNotNull(cube);
        double result = Math.pow(cube.getSideLength(), 3);
        return result;
    }

    public double cubePerimeterCalculation(Cube cube) throws CubeException {
        checkNotNull(cube);
        double result = cube.getSideLength() * 12;
        return result;
    }


    private void checkNotNull(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
    }

}
