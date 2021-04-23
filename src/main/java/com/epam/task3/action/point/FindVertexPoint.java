package com.epam.task3.action.point;

import com.epam.task3.entity.CustomPoint;

public class FindVertexPoint {
    public CustomPoint findAnotherPoint(CustomPoint centerPoint, double axisOffset,
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
}
