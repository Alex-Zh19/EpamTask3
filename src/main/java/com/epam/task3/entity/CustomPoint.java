package com.epam.task3.entity;

public class CustomPoint {
    private int x, y, z;

    public CustomPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint that = (CustomPoint) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        int result = 9;
        Integer x = this.x;
        Integer y = this.y;
        Integer z = this.z;
        result += x.hashCode() + y.hashCode() + z.hashCode();
        return result;
    }

    @Override
    public String toString() {
        Integer x = this.x;
        Integer y = this.y;
        Integer z = this.z;
        return "Point (" +
                x.toString() + ";" +
                y.toString() + ";" +
                z.toString() + ")";
    }
}
