package com.epam.task3.warehouse;

import com.epam.task3.exception.WarehouseException;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse INSTANCE=new Warehouse();
    private final Map<String, CubeParameter> cubeParameterMap=new HashMap<>();

    public static Warehouse getInstance(){
        return INSTANCE;
    }

    public void putParameters(String id,double volume,double area,double perimeter){
        CubeParameter newCubeParameter=new CubeParameter(perimeter, volume, area);
        INSTANCE.cubeParameterMap.put(id,newCubeParameter);
    }
    public CubeParameter getParameter(String id) throws WarehouseException {
        CubeParameter cubeParameter= INSTANCE.getParameter(id);
        if(cubeParameter==null){
            throw new WarehouseException("wrong id. no such element in warehouse :"+id);
        }
        return cubeParameter;
    }

    public void updateElement(String id,double newVolume,double newArea,double newPerimeter) throws WarehouseException{
        CubeParameter cubeParameter= INSTANCE.getParameter(id);
        if(cubeParameter==null){
            throw new WarehouseException("wrong id. no such element in warehouse :"+id);
        }
        cubeParameter.setPerimeter(newPerimeter);
        cubeParameter.setVolume(newVolume);
        cubeParameter.setArea(newArea);
    }
}
