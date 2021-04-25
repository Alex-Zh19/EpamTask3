package com.epam.task3.action.point;

import com.epam.task3.entity.CustomPoint;

import java.util.ArrayList;
import java.util.List;

public class CustomPointCalculation {
    public CustomPoint findVertexPoint(CustomPoint centerPoint, double axisOffset,
                                       double axisMultiplierX, double axisMultiplierY, double axisMultiplierZ) {
        //it will be the same for all axes
        axisMultiplierX = (axisMultiplierX < 0.0) ? (-1) : 1;
        axisMultiplierY = (axisMultiplierY < 0.0) ? (-1) : 1;
        axisMultiplierZ = (axisMultiplierZ < 0.0) ? (-1) : 1;

        double x = centerPoint.getX();
        double y = centerPoint.getY();
        double z = centerPoint.getZ();

        x += axisOffset * axisMultiplierX;
        y += axisOffset * axisMultiplierY;
        z += axisOffset * axisMultiplierZ;

        return new CustomPoint(x, y, z);
    }

    public List<CustomPoint> findAllVertexPoints(CustomPoint centerPoint, double sideLength) {
        List<CustomPoint> vertexPoints = new ArrayList<>();
        double halfSideLength = sideLength / 2;
        // 4 points lower than center point
        double zLow = centerPoint.getZ() - halfSideLength;
        CustomPoint point1 = findFirstPoint(centerPoint, halfSideLength, zLow);
        CustomPoint point2 = findSecondPoint(centerPoint, halfSideLength, zLow);
        CustomPoint point3 = findThirdPoint(centerPoint, halfSideLength, zLow);
        CustomPoint point4 = findFourthPoint(centerPoint, halfSideLength, zLow);

        vertexPoints.add(point1);
        vertexPoints.add(point2);
        vertexPoints.add(point3);
        vertexPoints.add(point4);

        double zHigh = centerPoint.getZ() + halfSideLength;
        CustomPoint point5 = findFirstPoint(centerPoint, halfSideLength, zHigh);
        CustomPoint point6 = findSecondPoint(centerPoint, halfSideLength, zHigh);
        CustomPoint point7 = findThirdPoint(centerPoint, halfSideLength, zHigh);
        CustomPoint point8 = findFourthPoint(centerPoint, halfSideLength, zHigh);

        //first and last points lie on the diagonal
        vertexPoints.add(point5);
        vertexPoints.add(point6);
        vertexPoints.add(point7);
        vertexPoints.add(point8);

        return vertexPoints;
    }

    private CustomPoint findFirstPoint(CustomPoint centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() - halfSideLength;
        double y = centerPoint.getY() - halfSideLength;
        return new CustomPoint(x, y, z);
    }

    private CustomPoint findSecondPoint(CustomPoint centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() + halfSideLength;
        double y = centerPoint.getY() - halfSideLength;
        return new CustomPoint(x, y, z);
    }

    private CustomPoint findThirdPoint(CustomPoint centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() - halfSideLength;
        double y = centerPoint.getY() + halfSideLength;
        return new CustomPoint(x, y, z);
    }

    private CustomPoint findFourthPoint(CustomPoint centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() + halfSideLength;
        double y = centerPoint.getY() + halfSideLength;
        return new CustomPoint(x, y, z);
    }


}
