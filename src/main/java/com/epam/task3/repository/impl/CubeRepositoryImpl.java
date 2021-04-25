package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.repository.CubeRepository;
import com.epam.task3.specification.CubeFindSpecification;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepositoryImpl implements CubeRepository {

    private static final CubeRepository repositoryInstance = new CubeRepositoryImpl();
    private final List<Cube> cubeList = new ArrayList<>();


    private CubeRepositoryImpl() {
    }

    public static CubeRepository getRepositoryInstance() {
        return repositoryInstance;
    }


    @Override
    public boolean addCube(Cube cube) {
        return cubeList.add(new Cube(cube));
    }

    @Override
    public boolean addAll(List<Cube> listOfCube) {
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
            cubeList.add(position, new Cube(cube));
            return true;
        }
        return false;
    }

    @Override
    public List<Cube> sort(Comparator<Cube> cubeSortSpecification) {
        return cubeList.stream().sorted(cubeSortSpecification).collect(Collectors.toList());
    }


    @Override
    public List<Cube> queryStream(CubeFindSpecification cubeSpecification) {
        List<Cube> specifiedCubeList = cubeList.stream().filter(cubeSpecification::specified).
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeRepositoryImpl that = (CubeRepositoryImpl) o;
        return that.cubeList.equals(this.cubeList);
    }
}
