package com.epam.task3.warehouse;

import com.epam.task3.exception.WarehouseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instanceWarehouse = new Warehouse();
    private static final Logger logger = LogManager.getLogger();
    private final Map<String, CubeParameter> cubeParameterMap = new HashMap<>();

    public static Warehouse getInstance() {
        return instanceWarehouse;
    }

    public void putParameters(String id, double volume, double area, double perimeter) {
        CubeParameter newCubeParameter = new CubeParameter(perimeter, volume, area);
        instanceWarehouse.cubeParameterMap.put(id, newCubeParameter);
    }

    public CubeParameter getParameter(String id) throws WarehouseException {
        CubeParameter cubeParameter = instanceWarehouse.getParameter(id);
        if (cubeParameter == null) {
            logger.log(Level.ERROR, "wrong id. no such element in warehouse : {}", id);
            throw new WarehouseException("wrong id. no such element in warehouse :" + id);
        }
        return cubeParameter;
    }

    public void updateElement(String id, double newVolume, double newArea, double newPerimeter) throws WarehouseException {
        CubeParameter cubeParameter = instanceWarehouse.getParameter(id);
        if (cubeParameter == null) {
            logger.log(Level.ERROR, "wrong id. no such element in warehouse : {}", id);
            throw new WarehouseException("wrong id. no such element in warehouse :" + id);
        }
        cubeParameter.setPerimeter(newPerimeter);
        cubeParameter.setVolume(newVolume);
        cubeParameter.setArea(newArea);
    }
}
