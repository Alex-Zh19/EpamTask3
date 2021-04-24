package com.epam.task3.repository;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecification;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository {
    boolean addCube(Cube cube);

    boolean addAll(List<Cube> cube);

    boolean removeCube(Cube cube);

    boolean removeAllCube(List<Cube> listOfCube);

    boolean updateCube(int position, Cube cube);

    List<Cube> sort(Comparator<Cube> cubeSortSpecification);

    List<Cube> queryStream(CubeFindSpecification cubeFindSpecification);

    List<Cube> query(CubeFindSpecification cubeFindSpecification);

    //предикат нужен ли

}
