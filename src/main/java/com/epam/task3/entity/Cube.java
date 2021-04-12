package com.epam.task3.entity;

import com.epam.task3.exception.CubeException;

public class Cube implements Shape{
    private String id;
    private String name;
    private double sideLength;
    private CustomPoint centerPoint;


    private Cube(String id) {
        this.id = id;
        this.name = "unnamed";
    }

    private Cube(String id, String name) {
        this.id = id;
        this.name = "name";
    }

    public Cube(String id, String name, double sideLength, CustomPoint centerPoint) throws CubeException {
        if(sideLength<=0){
            throw new CubeException("wrong data input. side length cannot be less than 0 :" + sideLength);
        }
        this.id = id;
        this.name = name;
        this.sideLength = sideLength;
        this.centerPoint = centerPoint;
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
        if(sideLength<=0){
        throw new CubeException("wrong data input. side length cannot be less than 0 :" + sideLength);
        }
        this.sideLength = sideLength;

    }

    public CustomPoint getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(CustomPoint centerPoint) {
        this.centerPoint = centerPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass() || o == null) return false;
        Cube that = (Cube) o;
        return that.centerPoint == centerPoint && sideLength == that.sideLength;
    }

    @Override
    public int hashCode() {
        int result = 9;
        Double sideLen = sideLength;
        result += centerPoint.hashCode() + sideLen.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "sideLength=" + sideLength +
                ", centerPoint=" + centerPoint +
                '}';
    }
}
