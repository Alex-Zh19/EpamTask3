package com.epam.task3.action.cube;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;
import com.epam.task3.factory.CubeFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeCalculationsTest {

    @Test
    public void testCubeAreaCalculation() {
        CubeFactory factory=new CubeFactory();
        CubeCalculation calculations=new CubeCalculation();
        double expectedArea=216.0;
        try {
            Cube testCube=factory.createShape("cube", "name",6,1,2,3);
            double actualArea=calculations.cubeAreaCalculation(testCube);
            Assert.assertEquals(expectedArea,actualArea);
        }catch (CubeException e){

        }

    }

    @Test
    public void testCubeVolumeCalculation() {
        CubeFactory factory=new CubeFactory();
        CubeCalculation calculations=new CubeCalculation();
        double expectedArea=216.0;
        try {
            Cube testCube=factory.createShape("cube", "name",6,1,2,3);
            double actualArea=calculations.cubeVolumeCalculation(testCube);
            Assert.assertEquals(expectedArea,actualArea);
        }catch (CubeException e){

        }
    }

    @Test
    public void testCubePerimeterCalculation() {
        CubeFactory factory=new CubeFactory();
        CubeCalculation calculations=new CubeCalculation();
        double expectedArea=72.0;
        try {
            Cube testCube=factory.createShape("cube", "name",6,1,2,3);
            double actualArea=calculations.cubePerimeterCalculation(testCube);
            Assert.assertEquals(expectedArea,actualArea);
        }catch (CubeException e){

        }
    }
}