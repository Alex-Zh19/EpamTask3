package com.epam.task3.action.point;

import com.epam.task3.entity.CustomPoint;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomPointCalculationTest {

    @Test
    public void testFindAnotherPoint() {
        CustomPoint centerPoint = new CustomPoint(1, 1, 1);
        CustomPoint pointExpected = new CustomPoint(0, 0, 0);
        CustomPointCalculation customPointCalculation = new CustomPointCalculation();
        CustomPoint pointActual = customPointCalculation.
                findVertexPoint(centerPoint, 1, -1, -1, -1);
        assertEquals(pointActual, pointExpected);
    }

    @Test
    public void testFindAllVertexPoints() {
        CustomPoint centerPoint = new CustomPoint(1, 1, 1);
        double sideLength = 2;

        List<CustomPoint> pointsExpected = new ArrayList<>();
        CustomPoint point1 = new CustomPoint(0, 0, 0);
        CustomPoint point2 = new CustomPoint(2, 0, 0);
        CustomPoint point3 = new CustomPoint(0, 2, 0);
        CustomPoint point4 = new CustomPoint(2, 2, 0);

        CustomPoint point5 = new CustomPoint(0, 0, 2);
        CustomPoint point6 = new CustomPoint(2, 0, 2);
        CustomPoint point7 = new CustomPoint(0, 2, 2);
        CustomPoint point8 = new CustomPoint(2, 2, 2);

        pointsExpected.add(point1);
        pointsExpected.add(point2);
        pointsExpected.add(point3);
        pointsExpected.add(point4);
        pointsExpected.add(point5);
        pointsExpected.add(point6);
        pointsExpected.add(point7);
        pointsExpected.add(point8);

        CustomPointCalculation calculation = new CustomPointCalculation();
        List<CustomPoint> pointsActual = calculation.findAllVertexPoints(centerPoint, sideLength);

        assertEquals(pointsActual, pointsExpected);
    }
}