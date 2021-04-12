package com.epam.task3.observer.impl_observer;

import com.epam.task3.action.cube_action.CubeCalculations;

import com.epam.task3.entity.Cube;
import com.epam.task3.exception.CubeException;
import com.epam.task3.exception.WarehouseException;
import com.epam.task3.observer.CubeEvent;
import com.epam.task3.observer.Observer;
import com.epam.task3.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserver implements Observer {
    private final static Logger logger = LogManager.getLogger();
    private final CubeCalculations calculations = new CubeCalculations();

    @Override
    public void parameterChanged(CubeEvent event) {
        double perimeter = 0.0;
        double volume = 0.0;
        double area = 0.0;
        Cube sourceCube=event.getSource();
        try {
            perimeter = calculations.cubePerimeterCalculation(sourceCube);
        } catch (CubeException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

        try {
            volume = calculations.cubeVolumeCalculation(sourceCube);
        } catch (CubeException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

        try {
            area = calculations.cubeAreaCalculation(sourceCube);
        } catch (CubeException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        String id = sourceCube.getId();

        try {
            Warehouse.getInstance().updateElement(id, volume, area, perimeter);
        } catch (WarehouseException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

    }


}
