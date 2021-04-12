package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.repository.CubeRepositoryInterface;
import com.epam.task3.specification.find_specification.CubeFindSpecificationInterface;
import com.epam.task3.specification.sort_specification.CubeSortSpecificationInterface;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository implements CubeRepositoryInterface {

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
    public void sorting(CubeSortSpecificationInterface cubeSortSpecification) {
        Collections.sort(cubeList,cubeSortSpecification);
    }


    @Override
    public List queryStream(CubeFindSpecificationInterface cubeSpecification) {
        List<Cube> specifiedCubeList = cubeList.stream().filter(cube -> cubeSpecification.specified(cube)).
                collect(Collectors.toList());
        return specifiedCubeList;
    }

    @Override
    public List query(CubeFindSpecificationInterface cubeSpecification) {
        List<Cube> specifiedCubeList = new ArrayList<>();
        for (Cube currentCubeIntList : cubeList) {
            if (cubeSpecification.specified(currentCubeIntList)) {
                specifiedCubeList.add(currentCubeIntList);
            }
        }
        return specifiedCubeList;
    }
}
