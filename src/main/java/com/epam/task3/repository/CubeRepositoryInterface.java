package com.epam.task3.repository;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;
import com.epam.task3.specification.impl.CubeSpecificationById;

import java.util.List;

public interface CubeRepositoryInterface {
    void addCube(Cube cube);
    void addCube(List<Cube> cube);
    void removeCube(Cube cube);
    void updateCube(int position,Cube cube);

    List query(CubeSpecificationInterface cubeSpecification);
}
