package com.epam.task3.repository;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecificationInterface;

import java.util.Comparator;
import java.util.List;

public interface CubeRepositoryInterface {
    boolean addCube(Cube cube);

    boolean addCube(List<Cube> cube);

    boolean removeCube(Cube cube);

    boolean removeAllCube(List<Cube> listOfCube);

    boolean updateCube(int position, Cube cube);

    void sorting(Comparator<Cube> cubeSortSpecification);

    List queryStream(CubeFindSpecificationInterface cubeFindSpecification);

    List query(CubeFindSpecificationInterface cubeFindSpecification);

}
