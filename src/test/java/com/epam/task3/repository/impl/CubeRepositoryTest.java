package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;
import com.epam.task3.factory.CubeFactory;
import com.epam.task3.specification.find_specification.CubeFindSpecificationInterface;
import com.epam.task3.specification.find_specification.impl.CubeFindSpecificationById;
import com.epam.task3.specification.sort_specification.CubeSortSpecificationInterface;
import com.epam.task3.specification.sort_specification.impl.CubeSortSpecificationById;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CubeRepositoryTest {


    @Test
    public void testSorting() {
        CubeFactory factory = new CubeFactory();
        StringBuilder name = new StringBuilder("name");
        CubeRepository repositoryExpected = new CubeRepository();
        for (int i = 0; i < 4; i++) {
            try {
                Cube newCube = factory.createShape("type", name.append(i).toString(), i + 2, i + 1, i + 2, i + 3);
                repositoryExpected.addCube(newCube);
            } catch (CubeException e) {

            }
        }


        CubeRepository repositoryActual = new CubeRepository();
        for (int i = 4; i >= 0; i--) {
            try {
                Cube newCube = factory.createShape("type", name.append(i).toString(), i + 2, i + 1, i + 2, i + 3);
                repositoryActual.addCube(newCube);
            } catch (CubeException e) {

            }
        }
        CubeSortSpecificationInterface sort = new CubeSortSpecificationById();
        repositoryActual.sorting(sort);
        assertEquals(repositoryActual, repositoryExpected);

    }

    @Test
    public void testQueryStream() {
        CubeFactory factory = new CubeFactory();
        StringBuilder name = new StringBuilder("name");
        CubeRepository repository = new CubeRepository();
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 2) {
                    Cube newCube = factory.createShape("type", name.append(2).toString(), i + 2, i + 1, i + 2, i + 3);
                    repository.addCube(newCube);
                } else {
                    Cube newCube = factory.createShape("type", name.append(3).toString(), i + 2, i + 1, i + 2, i + 3);
                    repository.addCube(newCube);
                }
            } catch (CubeException e) {

            }
        }

        List<Cube> repositoryExpected = new ArrayList<>();
        try {
            Cube newCube = factory.createShape("type", name.append(2).toString(), 2 + 2, 2 + 1, 2 + 2, 2 + 3);
            Cube newCube1 = factory.createShape("type", name.append(2).toString(), 2 + 2, 2 + 1, 2 + 2, 2 + 3);
            repositoryExpected.add(newCube);
            repositoryExpected.add(newCube1);
        } catch (CubeException e) {

        }
        CubeFindSpecificationInterface find = new CubeFindSpecificationById("type2");
        List<Cube> repositoryActual = repository.query(find);
        assertEquals(repositoryActual, repositoryExpected);
    }

    @Test
    public void testQuery() {
        CubeFactory factory = new CubeFactory();
        StringBuilder name = new StringBuilder("name");
        CubeRepository repository = new CubeRepository();
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 2) {
                    Cube newCube = factory.createShape("type", name.append(2).toString(), i + 2, i + 1, i + 2, i + 3);
                    repository.addCube(newCube);
                } else {
                    Cube newCube = factory.createShape("type", name.append(3).toString(), i + 2, i + 1, i + 2, i + 3);
                    repository.addCube(newCube);
                }
            } catch (CubeException e) {

            }
        }

        List<Cube> repositoryExpected = new ArrayList<>();
        try {
            Cube newCube = factory.createShape("type", name.append(2).toString(), 2 + 2, 2 + 1, 2 + 2, 2 + 3);
            Cube newCube1 = factory.createShape("type", name.append(2).toString(), 2 + 2, 2 + 1, 2 + 2, 2 + 3);
            repositoryExpected.add(newCube);
            repositoryExpected.add(newCube1);
        } catch (CubeException e) {

        }
        CubeFindSpecificationInterface find = new CubeFindSpecificationById("type2");
        List<Cube> repositoryActual = repository.query(find);
        assertEquals(repositoryActual, repositoryExpected);
    }
}