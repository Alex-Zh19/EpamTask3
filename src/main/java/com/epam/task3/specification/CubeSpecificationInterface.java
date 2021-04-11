package com.epam.task3.specification;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CustomPointException;

public interface CubeSpecificationInterface {
    boolean specified(Cube cube) throws CustomPointException;
}
