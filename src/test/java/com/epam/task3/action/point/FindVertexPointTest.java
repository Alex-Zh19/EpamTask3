package com.epam.task3.action.point;

import com.epam.task3.entity.CustomPoint;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindVertexPointTest {

    @Test
    public void testFindAnotherPoint() {
        CustomPoint centerPoint=new CustomPoint(1,1,1);
        CustomPoint pointExpected=new CustomPoint(0,0,0);
        FindVertexPoint findVertexPoint=new FindVertexPoint();
        CustomPoint pointActual=findVertexPoint.
                findAnotherPoint(centerPoint,1,-1,-1,-1);
        assertEquals(pointActual,pointExpected);
    }
}