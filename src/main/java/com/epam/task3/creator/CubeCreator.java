package com.epam.task3.creator;

import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {
    List<Cube> cubeList;

    public CubeCreator() {
        cubeList = new ArrayList<>();
    }

    public void createCube(String name, int sideLength, int x, int y, int z) throws CubeException {
        if (name == null) {
            name = "untitled";
        }
        if (sideLength <= 0) {
            throw new CubeException("Cube cannot exist");
        }
        CustomPoint centerPoint = createPoint(x, y, z);
        Cube newCube = new Cube(cubeList.size(), name, sideLength, centerPoint);
        cubeList.add(newCube);
    }

    public void createCube(String name, int sideLength, CustomPoint centerPoint) throws CubeException {
        if (name == null) {
            name = "untitled";
        }
        if (sideLength <= 0) {
            throw new CubeException("Cube cannot exist");
        }
        Cube newCube = new Cube(cubeList.size(), name, sideLength, centerPoint);
        cubeList.add(newCube);
    }

    public void createCube(List<String> nameList, List<int[]> parametersList) throws CubeException {
        if (nameList == null) {
            throw new CubeException("nameList cannot be null");
        }
        if (parametersList == null) {
            throw new CubeException("parameterList cannot be null");
        }
        if (parametersList.isEmpty()) {
            throw new CubeException("parameterList is empty");
        }
        if (nameList.isEmpty()) {
            throw new CubeException("parameterList is empty");
        }
        if (nameList.size() != parametersList.size()) {
            throw new CubeException("part of input data wrong");
        }
        for (int i = 0; i < nameList.size(); i++) {
            String name= nameList.get(i);
            int []parameters= parametersList.get(i);
            int sideLen=parameters[parameters.length-1];
            CustomPoint centerPoint=createPoint(parameters[0],parameters[1],parameters[2]);
            Cube newCube=new Cube(cubeList.size(),name,sideLen,centerPoint);
            cubeList.add(newCube);
        }

    }
    public List<Cube> getCubeList(){
        return new ArrayList<>(cubeList);
    }


    private CustomPoint createPoint(int x, int y, int z) {
        return new CustomPoint(x, y, z);
    }
}
