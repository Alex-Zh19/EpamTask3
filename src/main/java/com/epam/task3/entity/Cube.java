package com.epam.task3.entity;

public class Cube {
    private int id;
    private String name;
    private int sideLength;
    private CustomPoint centerPoint;


    private Cube(int id) {
        this.id = id;
        this.name = "unnamed";
    }

    private Cube(int id, String name) {
        this.id = id;
        this.name = "name";
    }

    public Cube(int id, String name, int sideLength, CustomPoint centerPoint) {
        this.id = id;
        this.name = name;
        this.sideLength = sideLength;
        this.centerPoint = centerPoint;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
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
        Integer sideLen = sideLength;
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
