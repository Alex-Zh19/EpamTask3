package com.epam.task3.warehouse;

import com.epam.task3.action.cube.CubeCalculation;
import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;
import com.epam.task3.exception.WarehouseException;
import com.epam.task3.factory.CubeFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WarehouseTest {

    @Test
    public void testGetParameter() {
        CubeFactory factory = new CubeFactory();
        CubeCalculation calculations = new CubeCalculation();
        try {
            Cube testCube = factory.createShape("type1", "name", 4, 1, 2, 3);
            double volume = calculations.cubeVolumeCalculation(testCube);
            double perimeter = calculations.cubePerimeterCalculation(testCube);
            double area = calculations.cubeAreaCalculation(testCube);
            double volumeExpected=8;
            Warehouse.getInstance().putParameters("type1", volume, area, perimeter);
            testCube.setSideLength(2);
            try {
                CubeParameter parameterActual = Warehouse.getInstance().getParameter("type1");
                assertEquals(parameterActual.getVolume(),volumeExpected);

            } catch (WarehouseException e) {

            }
        } catch (CubeException e) {

        }
    }

}