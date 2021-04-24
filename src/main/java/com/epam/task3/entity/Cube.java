package com.epam.task3.entity;

import com.epam.task3.exception.CubeException;
import com.epam.task3.observer.CubeEvent;
import com.epam.task3.observer.Observable;
import com.epam.task3.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Observable {
    private String id;
    private String name;
    private double sideLength;
    private CustomPoint centerPoint;
    private List<Observer> observers = new ArrayList<>();


    public Cube(String id, String name, double sideLength, CustomPoint centerPoint) throws CubeException {
        if (sideLength <= 0) {
            throw new CubeException("wrong data input. side length cannot be less than 0 :" + sideLength);
        }
        this.id = id;
        this.name = name;
        this.sideLength = sideLength;
        this.centerPoint = centerPoint;
    }

    public Cube(Cube base){
        this.id=base.id;
        this.name=base.name;
        this.sideLength= base.sideLength;
        this.centerPoint=base.getCenterPoint();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) throws CubeException {
        if (sideLength <= 0) {
            throw new CubeException("wrong data input. side length cannot be less than 0 :" + sideLength);
        }
        this.sideLength = sideLength;
        notifyObservers();
    }

    public CustomPoint getCenterPoint() {
        return new CustomPoint(centerPoint);
    }

    public void setCenterPoint(CustomPoint centerPoint) {
        this.centerPoint = centerPoint;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass() || o == null) return false;
        Cube other = (Cube) o;
        return other.id.equals(id)&&other.name.equals(name)&&other.centerPoint.equals(centerPoint) && sideLength == other.sideLength;
    }

    @Override
    public int hashCode() {
        int result = 9;
        Double sideLen = sideLength;
        result = result + centerPoint.hashCode() + sideLen.hashCode() + name.hashCode() + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Cube{ id= ");
        result.append(id).append("name= ").
                append(name).append("sideLength= ").append(sideLength).
                append(", centerPoint= ").append(centerPoint).append("}");
        return result.toString();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (!observers.isEmpty()) {
            CubeEvent cubeEvent = new CubeEvent(this);
            for (Observer observer : observers) {
                observer.parameterChanged(cubeEvent);
            }
        }
    }
}
