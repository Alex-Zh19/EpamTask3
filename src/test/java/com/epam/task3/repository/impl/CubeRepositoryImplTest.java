package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;
import com.epam.task3.factory.CubeFactory;
import com.epam.task3.specification.CubeFindSpecification;
import com.epam.task3.specification.impl.CubeFindSpecificationById;
import com.epam.task3.specification.impl.CubeSortSpecificationById;
import com.epam.task3.specification.impl.CubeSortSpecificationByIdAndName;
import com.epam.task3.specification.impl.CubeSortSpecificationByName;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class CubeRepositoryImplTest {


    @Test
    public void testSortById() throws CubeException {
        StringBuilder name = new StringBuilder("name");
        CubeRepositoryImpl repositoryExpected = new CubeRepositoryImpl();
        for (int i = 0; i <= 4; i++) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString(), i + 2, centerPoint);
            repositoryExpected.addCube(newCube);
        }

        CubeRepositoryImpl repository = new CubeRepositoryImpl();
        for (int i = 4; i >= 0; i--) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString(), i + 2, centerPoint);
            repository.addCube(newCube);

        }

        Comparator<Cube> sort = new CubeSortSpecificationById();
        CubeRepositoryImpl repositoryActual = repository.sort(sort);
        assertTrue(isIdSortingWorks(repositoryActual, repositoryExpected));
    }


    @Test
    public void testSortingByName() throws CubeException {
        StringBuilder name = new StringBuilder("name");
        CubeRepositoryImpl repositoryExpected = new CubeRepositoryImpl();
        for (int i = 0; i <= 4; i++) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString() + i + i, i + 2, centerPoint);
            repositoryExpected.addCube(newCube);
        }

        CubeRepositoryImpl repository = new CubeRepositoryImpl();
        for (int i = 4; i >= 0; i--) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString() + i + i, i + 2, centerPoint);
            repository.addCube(newCube);

        }

        Comparator<Cube> sort = new CubeSortSpecificationByName();
        CubeRepositoryImpl repositoryActual = repository.sort(sort);
        assertTrue(isNameSortingWorks(repositoryActual, repositoryExpected));

    }

    @Test
    public void testSortingByIdAndName() throws CubeException {
        StringBuilder name = new StringBuilder("name");
        CubeRepositoryImpl repositoryExpected = new CubeRepositoryImpl();
        CustomPoint centerPoint = new CustomPoint(3, 3, 3);
        Cube newCube1 = new Cube("cube1", "name1", 5, centerPoint);
        Cube newCube2 = new Cube("cube1", "name2", 5, centerPoint);
        Cube newCube3 = new Cube("cube2", "name1", 5, centerPoint);
        Cube newCube4 = new Cube("cube2", "name2", 5, centerPoint);
        repositoryExpected.addCube(newCube1);
        repositoryExpected.addCube(newCube2);
        repositoryExpected.addCube(newCube3);
        repositoryExpected.addCube(newCube4);


        CubeRepositoryImpl repository = new CubeRepositoryImpl();
        Cube newCube5 = new Cube("cube1", "name1", 5, centerPoint);
        Cube newCube6 = new Cube("cube1", "name2", 5, centerPoint);
        Cube newCube7 = new Cube("cube2", "name1", 5, centerPoint);
        Cube newCube8 = new Cube("cube2", "name2", 5, centerPoint);
        repository.addCube(newCube8);
        repository.addCube(newCube7);
        repository.addCube(newCube6);
        repository.addCube(newCube5);

        Comparator<Cube> sort = new CubeSortSpecificationByIdAndName();
        CubeRepositoryImpl repositoryActual = repository.sort(sort);
        assertEquals(repositoryActual, repositoryExpected);
    }


    @Test
    public void testQueryStream() {
        CubeFactory factory = new CubeFactory();
        StringBuilder name = new StringBuilder("name");
        CubeRepositoryImpl repository = new CubeRepositoryImpl();
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
        CubeFindSpecification find = new CubeFindSpecificationById("type2");
        List<Cube> repositoryActual = repository.query(find);
        assertEquals(repositoryActual, repositoryExpected);
    }

    @Test
    public void testQuery() {
        CubeFactory factory = new CubeFactory();
        StringBuilder name = new StringBuilder("name");
        CubeRepositoryImpl repository = new CubeRepositoryImpl();
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
        CubeFindSpecification find = new CubeFindSpecificationById("type2");
        List<Cube> repositoryActual = repository.query(find);
        assertEquals(repositoryActual, repositoryExpected);
    }


    private boolean isIdSortingWorks(CubeRepositoryImpl actual, CubeRepositoryImpl expected) {
        List<Cube> listActual = actual.getCubeList();
        List<Cube> listExpected = expected.getCubeList();
        if (listActual.isEmpty() || listExpected.isEmpty()) return false;
        int actualSize = listActual.size();
        if (actualSize != listExpected.size()) return false;
        for (int i = 0; i < actualSize; i++) {
            if (listActual.get(i).getId().equals(listExpected.get(i).getId())) {

            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isNameSortingWorks(CubeRepositoryImpl actual, CubeRepositoryImpl expected) {
        List<Cube> listActual = actual.getCubeList();
        List<Cube> listExpected = expected.getCubeList();
        if (listActual.isEmpty() || listExpected.isEmpty()) return false;
        int actualSize = listActual.size();
        if (actualSize != listExpected.size()) return false;
        for (int i = 0; i < actualSize; i++) {
            if (listActual.get(i).getName().equals(listExpected.get(i).getName())) {

            } else {
                return false;
            }
        }
        return true;
    }
}