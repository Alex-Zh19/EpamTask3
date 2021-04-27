package com.epam.task3.entity;

import com.epam.task3.exception.CubeException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeTest {

    @Test
    public void testGetCenterPoint() throws CubeException {
        CustomPoint centerPoint = new CustomPoint(1, 1, 1);
        Cube cube = new Cube("FuckCube", "name", 5, centerPoint);
        Cube c=cube.clone();
        System.out.println(c);
    }
}