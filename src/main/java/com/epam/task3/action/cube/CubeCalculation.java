package com.epam.task3.action.cube;

import com.epam.task3.action.point.CustomPointCalculation;
import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;

import java.util.List;

public class CubeCalculation {

    public double cubeAreaCalculation(Cube cube) throws CubeException {
        checkNotNull(cube);
        double result = Math.pow(cube.getSideLength(), 2) * 6;
        return result;
    }

    public double cubeVolumeCalculation(Cube cube) throws CubeException {
        checkNotNull(cube);
        double result = Math.pow(cube.getSideLength(), 3);
        return result;
    }

    public double cubePerimeterCalculation(Cube cube) throws CubeException {
        checkNotNull(cube);
        double result = cube.getSideLength() * 12;
        return result;
    }

    public boolean isCubeOnTheAxis(Cube cube) throws CubeException {
        checkNotNull(cube);
        CustomPoint centerPoint = cube.getCenterPoint();
        double halfSideLen = cube.getSideLength()/2;
        double x = centerPoint.getX();
        double y = centerPoint.getY();
        double z = centerPoint.getZ();
        if (x-halfSideLen==0||y-halfSideLen==0||z-halfSideLen==0){
            return true;
        }
        return false;
    }

    public double volumeRatio(Cube cube) throws CubeException{
        CustomPoint centerPoint=cube.getCenterPoint();
        double sideLength=cube.getSideLength();
        CustomPointCalculation pointCalculation=new CustomPointCalculation();
        List<CustomPoint> vertexPoints=pointCalculation.findAllVertexPoints(centerPoint,sideLength);
        if(!vertexPoints.isEmpty()){
            CustomPoint firstDiagonalPoint=vertexPoints.get(0);
            CustomPoint secondDiagonalPoint=vertexPoints.get(vertexPoints.size()-1);
            double firstX=firstDiagonalPoint.getX();
            double firstY=firstDiagonalPoint.getY();
            double firstZ=firstDiagonalPoint.getZ();

            double secondX=secondDiagonalPoint.getX();
            double secondY=secondDiagonalPoint.getY();
            double secondZ=secondDiagonalPoint.getZ();
            if(firstX/secondX<0){
                //доделать
            }

        }
        else{
            throw new CubeException("Wrong data input. vertex points cannot be null if center point existed");
        }
    }


    private void checkNotNull(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
    }

}
