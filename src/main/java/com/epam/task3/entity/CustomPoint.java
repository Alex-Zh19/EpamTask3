package com.epam.task3.entity;

public class CustomPoint {
    private double x, y, z;

    public CustomPoint(){
    }

    public CustomPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CustomPoint(CustomPoint basePoint) {
        this.x = basePoint.x;
        this.y = basePoint.y;
        this.z = basePoint.z;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint other = (CustomPoint) o;
        return x == other.x && y == other.y && z == other.z;
    }

    @Override
    public int hashCode() {
        int result = 9;
        Double x = this.x;
        Double y = this.y;
        Double z = this.z;
        result = result + x.hashCode() + y.hashCode() + z.hashCode();
        return result;
    }

    @Override
    public String toString() {
        Double x = this.x;
        Double y = this.y;
        Double z = this.z;
        StringBuilder result = new StringBuilder("Point (");
        result.append(x).append(";")
                .append(y).append(";").append(z).append(")");
        return result.toString();
    }
}
