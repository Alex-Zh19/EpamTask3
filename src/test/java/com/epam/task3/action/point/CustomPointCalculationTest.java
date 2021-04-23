package com.epam.task3.action.point;

import com.epam.task3.entity.CustomPoint;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomPointCalculationTest {

    @Test
    public void testFindAnotherPoint() {
        CustomPoint centerPoint=new CustomPoint(1,1,1);
        CustomPoint pointExpected=new CustomPoint(0,0,0);
        CustomPointCalculation customPointCalculation =new CustomPointCalculation();
        CustomPoint pointActual= customPointCalculation.
                findVertexPoint(centerPoint,1,-1,-1,-1);
        assertEquals(pointActual,pointExpected);
    }
}