package com.epam.task3.specification.find_specification.impl;

import com.epam.task3.action.point_action.FindVertexPoint;
import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.specification.find_specification.CubeFindSpecificationInterface;

import java.util.ArrayList;
import java.util.List;

public class CubeFindSpecificationByCoordinates implements CubeFindSpecificationInterface {
    @Override
    public boolean specified(Cube cube) {//for 1st quarter and positive z
        CustomPoint centerPointOfCube = cube.getCenterPoint();

        FindVertexPoint findVertexPoint = new FindVertexPoint();

        double halfOfSideLength = cube.getSideLength() / 2;

        List<CustomPoint> vertexPointList = new ArrayList<>();
        CustomPoint pointOfCube1 = findVertexPoint.findAnotherPoint(centerPointOfCube, halfOfSideLength,
                -1, -1, -1);
        vertexPointList.add(pointOfCube1);

        CustomPoint pointOfCube2 = findVertexPoint.findAnotherPoint(centerPointOfCube, halfOfSideLength,
                1, -1, -1);
        vertexPointList.add(pointOfCube2);

        CustomPoint pointOfCube3 = findVertexPoint.findAnotherPoint(centerPointOfCube, halfOfSideLength,
                -1, 1, -1);
        vertexPointList.add(pointOfCube3);

        CustomPoint pointOfCube4 = findVertexPoint.findAnotherPoint(centerPointOfCube, halfOfSideLength,
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
