package com.epam.task3.repository.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;
import com.epam.task3.factory.CubeFactory;
import com.epam.task3.specification.CubeFindSpecificationInterface;
import com.epam.task3.specification.impl.CubeFindSpecificationById;
import com.epam.task3.specification.impl.CubeSortSpecificationById;
import com.epam.task3.specification.impl.CubeSortSpecificationByName;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class CubeRepositoryTest {


    @Test
    public void testSortingById() throws CubeException {
        StringBuilder name = new StringBuilder("name");
        CubeRepository repositoryExpected = new CubeRepository();
        for (int i = 0; i <= 4; i++) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString(), i + 2, centerPoint);
            repositoryExpected.addCube(newCube);
        }

        CubeRepository repositoryActual = new CubeRepository();
        for (int i = 4; i >= 0; i--) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString(), i + 2, centerPoint);
            repositoryActual.addCube(newCube);

        }

        Comparator<Cube> sort = new CubeSortSpecificationById();
        repositoryActual.sorting(sort);
        assertTrue(isIdSortingWorks(repositoryActual, repositoryExpected));
    }


    @Test
    public void testSortingByName() throws CubeException {
        StringBuilder name = new StringBuilder("name");
        CubeRepository repositoryExpected = new CubeRepository();
        for (int i = 0; i <= 4; i++) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString() + i + i, i + 2, centerPoint);
            repositoryExpected.addCube(newCube);
        }

        CubeRepository repositoryActual = new CubeRepository();
        for (int i = 4; i >= 0; i--) {
            CustomPoint centerPoint = new CustomPoint(i + 1, i + 2, i + 3);
            Cube newCube = new Cube("cube" + i, name.toString() + i + i, i + 2, centerPoint);
            repositoryActual.addCube(newCube);

        }

        Comparator<Cube> sort = new CubeSortSpecificationByName();
        repositoryActual.sorting(sort);
        assertTrue(isNameSortingWorks(repositoryActual, repositoryExpected));

    }

    @Test
    public void testSortingByIdAndName() throws CubeException {
        StringBuilder name = new StringBuilder("name");
        CubeRepository repositoryExpected = new CubeRepository();
        CustomPoint centerPoint = new CustomPoint(3,3,3);
        Cube newCube1 = new Cube("cube1","name1",5,centerPoint);
        Cube newCube2 = new Cube("cube1","name2",5,centerPoint);
        Cube newCube3 = new Cube("cube2","name1",5,centerPoint);
        Cube newCube4 = new Cube("cube2","name2",5,centerPoint);
        repositoryExpected.addCube(newCube1);
        repositoryExpected.addCube(newCube2);
        repositoryExpected.addCube(newCube3);
        repositoryExpected.addCube(newCube4);


        CubeRepository repositoryActual = new CubeRepository();
        Cube newCube5 = new Cube("cube1","name1",5,centerPoint);
        Cube newCube6 = new Cube("cube1","name2",5,centerPoint);
        Cube newCube7 = new Cube("cube2","name1",5,centerPoint);
        Cube newCube8 = new Cube("cube2","name2",5,centerPoint);
        Cube newCube9 = new Cube("cube2","name0",5,centerPoint);
        Cube newCube10 = new Cube("cube1","name0",5,centerPoint);
        repositoryActual.addCube(newCube9);
        repositoryActual.addCube(newCube8);
        repositoryActual.addCube(newCube7);
        repositoryActual.addCube(newCube10);
        repositoryActual.addCube(newCube6);
        repositoryActual.addCube(newCube5);

        Comparator<Cube> sort = new CubeSortSpecificationById();
        repositoryActual.sorting(sort.thenComparing(new CubeSortSpecificationByName()));
        List<Cube>list=repositoryActual.getCubeList();
        for(Cube c:list){
            System.out.println("id :"+c.getId()+"  name: "+c.getName());
        }

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


    private boolean isIdSortingWorks(CubeRepository actual, CubeRepository expected) {
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

    private boolean isNameSortingWorks(CubeRepository actual, CubeRepository expected) {
        List<Cube> listActual = actual.getCubeList();
        List<Cube> listExpected = expected.getCubeList();
        if (listActual.isEmpty() || listExpected.isEmpty()) return false;
        int actualSize = listActual.size();
        if (actualSize != listExpected.size()) return false;
        for (int i = 0; i < actualSize; i++) {
            System.out.println(listActual.get(i).getName() + " and " + listExpected.get(i).getName());
            if (listActual.get(i).getName().equals(listExpected.get(i).getName())) {

            } else {
                return false;
            }
        }
        return true;
    }
}