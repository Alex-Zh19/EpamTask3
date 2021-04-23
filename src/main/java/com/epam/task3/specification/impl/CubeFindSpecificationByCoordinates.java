package com.epam.task3.specification.impl;

import com.epam.task3.action.point.CustomPointCalculation;
import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.specification.CubeFindSpecification;

import java.util.ArrayList;
import java.util.List;

public class CubeFindSpecificationByCoordinates implements CubeFindSpecification {
    @Override
    public boolean specified(Cube cube) {//for 1st quarter and positive z
        CustomPoint centerPointOfCube = cube.getCenterPoint();

        CustomPointCalculation customPointCalculation = new CustomPointCalculation();

        double halfOfSideLength = cube.getSideLength() / 2;

        List<CustomPoint> vertexPointList = new ArrayList<>();
        CustomPoint pointOfCube1 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                -1, -1, -1);
        vertexPointList.add(pointOfCube1);

        CustomPoint pointOfCube2 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                1, -1, -1);
        vertexPointList.add(pointOfCube2);

        CustomPoint pointOfCube3 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                -1, 1, -1);
        vertexPointList.add(pointOfCube3);

        CustomPoint pointOfCube4 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                1, 1, -1);
        vertexPointList.add(pointOfCube4);

        for (CustomPoint currentPoint : vertexPointList) {
            if (!isFirstQuarter(currentPoint)) return false;
        }
        return true;
    }

    private boolean isFirstQuarter(CustomPoint point) {
        return point.getX() > 0.0 && point.getY() > 0.0 && point.getZ() >= 0.0;
    }
}
