package com.epam.task3.warehouse;


public class CubeParameter {
    private double perimeter;
    private double volume;
    private double area;

    public CubeParameter( double volume, double area,double perimeter) {
        this.volume = volume;
        this.area = area;
        this.perimeter = perimeter;
    }

    public CubeParameter(CubeParameter cubeBaseParameter) {
        this.area = cubeBaseParameter.area;
        this.perimeter = cubeBaseParameter.perimeter;
        this.volume = cubeBaseParameter.volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeParameter that = (CubeParameter) o;
        return Double.compare(that.perimeter, perimeter) == 0 &&
                Double.compare(that.volume, volume) == 0 && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        Double p = perimeter;
        Double v = volume;
        Double a = area;
        int result =p.hashCode()+v.hashCode()+a.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder("CubeParameter{ perimeter= ").append(perimeter).
                append(", volume= ").append(volume).append(", area= ").append(area).append("}");
        return result.toString();
    }
}
