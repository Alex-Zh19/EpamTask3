package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.repository.CubeRepositoryInterface;
import com.epam.task3.specification.CubeSpecificationInterface;
import com.epam.task3.specification.impl.CubeSpecificationById;

import java.util.ArrayList;
import java.util.List;

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
    public void addCube(Cube cube) {
        cubeList.add(cube);
    }

    @Override
    public void addCube(List<Cube> listOfCube) {
        cubeList.addAll(listOfCube);
    }

    @Override
    public void removeCube(Cube cube) {
        cubeList.remove(cube);
    }

    @Override
    public void updateCube(int position, Cube cube) {
        if (position >= 0 && position < cubeList.size()) {
            cubeList.add(position, cube);
        }
    }

    @Override
    public List query(CubeSpecificationInterface cubeSpecification) {
        List<Cube> specifiedCubeList = new ArrayList<>();

        return null;
    }
}
