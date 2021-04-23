package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecification;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository implements com.epam.task3.repository.CubeRepository {

    private List<Cube> cubeList;

    public CubeRepository() {
        cubeList = new ArrayList<>();
    }

    public CubeRepository(List<Cube> baseCubeList) {
        cubeList = new ArrayList<>(baseCubeList);
    }

    public List<Cube> getCubeList() {
        return new ArrayList<>(cubeList);
    }

    @Override
    public boolean addCube(Cube cube) {
        return cubeList.add(cube);
    }

    @Override
    public boolean addCube(List<Cube> listOfCube) {
        return cubeList.addAll(listOfCube);
    }

    @Override
    public boolean removeCube(Cube cube) {
        return cubeList.remove(cube);
    }

    @Override
    public boolean removeAllCube(List<Cube> listOfCube) {
        return cubeList.removeAll(listOfCube);
    }

    @Override
    public boolean updateCube(int position, Cube cube) {
        if (position >= 0 && position < cubeList.size()) {
            cubeList.add(position, cube);
            return true;
        }
        return false;
    }

    @Override
    public CubeRepository sorting(Comparator<Cube> cubeSortSpecification) {
         return new CubeRepository(cubeList.stream().sorted(cubeSortSpecification).collect(Collectors.toList()));
    }


    @Override
    public List<Cube> queryStream(CubeFindSpecification cubeSpecification) {
        List<Cube> specifiedCubeList = cubeList.stream().filter(cube -> cubeSpecification.specified(cube)).
                collect(Collectors.toList());
        return specifiedCubeList;
    }

    @Override
    public List<Cube> query(CubeFindSpecification cubeSpecification) {
        List<Cube> specifiedCubeList = new ArrayList<>();
        for (Cube currentCubeIntList : cubeList) {
            if (cubeSpecification.specified(currentCubeIntList)) {
                specifiedCubeList.add(currentCubeIntList);
            }
        }
        return specifiedCubeList;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeRepository that = (CubeRepository) o;
        return that.cubeList.equals(this.cubeList);
    }
}
