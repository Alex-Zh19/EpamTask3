package com.epam.task3.action.cube;

import com.epam.task3.action.point.CustomPointCalculation;
import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CubeCalculation {

    private static final Logger logger = LogManager.getLogger();

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
        double halfSideLen = cube.getSideLength() / 2;
        double x = centerPoint.getX();
        double y = centerPoint.getY();
        double z = centerPoint.getZ();
        if (x - halfSideLen == 0 || y - halfSideLen == 0 || z - halfSideLen == 0) {
            return true;
        }
        return false;
    }

    public String volumeRatio(Cube cube) throws CubeException {
        checkNotNull(cube);
        CustomPoint centerPoint = cube.getCenterPoint();
        double sideLength = cube.getSideLength();
        CustomPointCalculation pointCalculation = new CustomPointCalculation();
        List<CustomPoint> vertexPoints = pointCalculation.findAllVertexPoints(centerPoint, sideLength);
        if (!vertexPoints.isEmpty()) {
            CustomPoint firstDiagonalPoint = vertexPoints.get(0);
            CustomPoint secondDiagonalPoint = vertexPoints.get(7);
            double firstX = firstDiagonalPoint.getX();
            double firstY = firstDiagonalPoint.getY();
            double firstZ = firstDiagonalPoint.getZ();

            double secondX = secondDiagonalPoint.getX();
            double secondY = secondDiagonalPoint.getY();
            double secondZ = secondDiagonalPoint.getZ();

            boolean markXoY = false;
            boolean markXoZ = false;
            boolean markYoZ = false;

            String ratio;

            if (firstX / secondX < 0) {
                markYoZ = true;
            }
            if (firstY / secondY < 0) {
                markXoZ = true;
            }
            if (firstZ / secondZ < 0) {
                markXoY = true;
            }

            if (markXoY && markXoZ && markYoZ) {
                ratio = findRatioThreeAxisCross(vertexPoints);
            } else if (markXoY && markXoZ) {
                ratio = findRatioTwoAxisXoZAndXoYCross(vertexPoints, sideLength);
            } else if (markXoY && markYoZ) {
                ratio = findRatioTwoAxisYoZAndXoYCross(vertexPoints, sideLength);
            } else if (markXoY) {
                ratio = findRatioOneAxisXoY(firstDiagonalPoint, secondDiagonalPoint, sideLength);
            } else if (markXoZ) {
                ratio = findRatioOneAxisXoZ(firstDiagonalPoint, secondDiagonalPoint, sideLength);
            } else if (markYoZ) {
                ratio = findRatioOneAxisYoZ(firstDiagonalPoint, secondDiagonalPoint, sideLength);
            } else {
                ratio = "1";
                logger.log(Level.INFO, "Cube doesn't cross axis {}", cube);
            }
            return ratio;

        } else {
            logger.log(Level.ERROR, "Wrong data input. vertex points cannot be null if center point existed {}"
                    , cube.getCenterPoint());
            throw new CubeException("Wrong data input. vertex points cannot be null if center point existed");
        }
    }
    //one parallel plane
    public double volumeRatio(Cube cube, CustomPoint planePoint) throws CubeException {
        checkNotNull(cube);
        CustomPointCalculation pointCalculation = new CustomPointCalculation();
        CustomPoint centerPoint = cube.getCenterPoint();
        double sideLength = cube.getSideLength();
        List<CustomPoint> vertexPoints = pointCalculation.findAllVertexPoints(centerPoint, sideLength);

        if (!vertexPoints.isEmpty()) {
            CustomPoint firstDiagonalPoint = vertexPoints.get(0);
            CustomPoint secondDiagonalPoint = vertexPoints.get(7);

            int mark = findCoordinateDividesCube(planePoint, firstDiagonalPoint, secondDiagonalPoint);
            double planeX = planePoint.getX();
            double planeY = planePoint.getY();
            double planeZ = planePoint.getZ();
            switch (mark) {
                case 0:
                    return 1;
                case 1:
                    double volume1 = calculateSmallVolume(secondDiagonalPoint.getX() - planeX, sideLength, sideLength);
                    double volume2 = calculateSmallVolume(planeX - firstDiagonalPoint.getX(), sideLength, sideLength);
                    if (volume2 == 0.0) throw new CubeException("calculation Exception. wrong Parameters. ");
                    return volume1 / volume2;
                case 2:
                    volume1 = calculateSmallVolume(sideLength, secondDiagonalPoint.getY() - planeY, sideLength);
                    volume2 = calculateSmallVolume(sideLength, planeY - firstDiagonalPoint.getY(), sideLength);
                    if (volume2 == 0.0) throw new CubeException("calculation Exception. wrong Parameters. ");
                    return volume1 / volume2;
                case 3:
                    volume1 = calculateSmallVolume(sideLength, sideLength, secondDiagonalPoint.getZ() - planeZ);
                    volume2 = calculateSmallVolume(sideLength, sideLength, planeZ - firstDiagonalPoint.getZ());
                    if (volume2 == 0.0) throw new CubeException("calculation Exception. wrong Parameters. ");
                    return volume1 / volume2;
                default:
                    throw new CubeException("Cube with such centerPoint doesn't exist. " + cube);
            }
        }
        throw new CubeException("Cube with such centerPoint doesn't exist. " + cube);
    }

    private String findRatioThreeAxisCross(List<CustomPoint> vertexPoints) {
        CustomPoint currentPoint = vertexPoints.get(0);
        double currentPointX = currentPoint.getX();
        double currentPointY = currentPoint.getY();
        double currentPointZ = currentPoint.getZ();
        double volume0 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(1);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume1 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(2);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume2 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(3);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume3 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(4);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume4 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(5);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume5 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(6);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume6 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(7);
        currentPointX = currentPoint.getX();
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume7 = calculateSmallVolume(currentPointX, currentPointY, currentPointZ);

        StringBuilder result = new StringBuilder();
        result.append(volume0).append(":").append(volume1).append(":").append(volume2).append(":").
                append(volume3).append(":").append(volume4).append(":").append(volume5).append(":").
                append(volume6).append(":").append(volume7);
        return result.toString();
    }

    private String findRatioTwoAxisXoZAndXoYCross(List<CustomPoint> vertexPoints, double sideLength) {
        CustomPoint currentPoint = vertexPoints.get(0);
        double currentPointY = currentPoint.getY();
        double currentPointZ = currentPoint.getZ();
        double volume0 = calculateSmallVolume(sideLength, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(3);
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume1 = calculateSmallVolume(sideLength, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(5);
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume2 = calculateSmallVolume(sideLength, currentPointY, currentPointZ);

        currentPoint = vertexPoints.get(7);
        currentPointY = currentPoint.getY();
        currentPointZ = currentPoint.getZ();
        double volume3 = calculateSmallVolume(sideLength, currentPointY, currentPointZ);

        StringBuilder result = new StringBuilder();
        result.append(volume0).append(":").append(volume1).append(":").
                append(volume2).append(":").append(volume3);
        return result.toString();
    }

    private String findRatioTwoAxisYoZAndXoYCross(List<CustomPoint> vertexPoints, double sideLength) {
        CustomPoint currentPoint = vertexPoints.get(0);
        double currentPointX = currentPoint.getX();
        double currentPointZ = currentPoint.getZ();
        double volume0 = calculateSmallVolume(currentPointX, sideLength, currentPointZ);

        currentPoint = vertexPoints.get(3);
        currentPointX = currentPoint.getX();
        currentPointZ = currentPoint.getZ();
        double volume1 = calculateSmallVolume(currentPointX, sideLength, currentPointZ);

        currentPoint = vertexPoints.get(5);
        currentPointX = currentPoint.getX();
        currentPointZ = currentPoint.getZ();
        double volume2 = calculateSmallVolume(currentPointX, sideLength, currentPointZ);

        currentPoint = vertexPoints.get(7);
        currentPointX = currentPoint.getX();
        currentPointZ = currentPoint.getZ();
        double volume3 = calculateSmallVolume(currentPointX, sideLength, currentPointZ);

        StringBuilder result = new StringBuilder();
        result.append(volume0).append(":").append(volume1).append(":").
                append(volume2).append(":").append(volume3);
        return result.toString();
    }

    private String findRatioOneAxisXoZ(CustomPoint firstDiagonalPoint, CustomPoint secondDiagonalPoint,
                                       double sideLength) {
        double currentPointY = firstDiagonalPoint.getY();
        double volume0 = calculateSmallVolume(sideLength, currentPointY, sideLength);

        currentPointY = secondDiagonalPoint.getY();
        double volume1 = calculateSmallVolume(sideLength, currentPointY, sideLength);

        StringBuilder result = new StringBuilder();
        result.append(volume0).append(":").append(volume1);

        return result.toString();
    }

    private String findRatioOneAxisYoZ(CustomPoint firstDiagonalPoint, CustomPoint secondDiagonalPoint,
                                       double sideLength) {
        double currentPointX = firstDiagonalPoint.getX();
        double volume0 = calculateSmallVolume(currentPointX, sideLength, sideLength);

        currentPointX = secondDiagonalPoint.getX();
        double volume1 = calculateSmallVolume(currentPointX, sideLength, sideLength);

        StringBuilder result = new StringBuilder();
        result.append(volume0).append(":").append(volume1);

        return result.toString();
    }

    private String findRatioOneAxisXoY(CustomPoint firstDiagonalPoint, CustomPoint secondDiagonalPoint,
                                       double sideLength) {
        double currentPointZ = firstDiagonalPoint.getZ();
        double volume0 = calculateSmallVolume(sideLength, sideLength, currentPointZ);

        currentPointZ = secondDiagonalPoint.getZ();
        double volume1 = calculateSmallVolume(sideLength, sideLength, currentPointZ);

        StringBuilder result = new StringBuilder();
        result.append(volume0).append(":").append(volume1);

        return result.toString();
    }

    private double calculateSmallVolume(double length, double width, double height) {
        length = Math.abs(length);
        width = Math.abs(width);
        height = Math.abs(height);
        return length * width * height;
    }



    //1-X,2-Y,3-Z,0-isn't divided
    private int findCoordinateDividesCube(CustomPoint point, CustomPoint diagonalPoint1, CustomPoint diagonalPoint2) {
        if (point.getX() < diagonalPoint2.getX() && point.getX() > diagonalPoint1.getX()) {
            return 1;
        }
        if (point.getY() < diagonalPoint2.getY() && point.getY() > diagonalPoint1.getY()) {
            return 2;
        }
        if (point.getZ() < diagonalPoint2.getZ() && point.getZ() > diagonalPoint1.getZ()) {
            return 3;
        }
        return 0;
    }

    private void checkNotNull(Cube cube) throws CubeException {
        if (cube == null) {
            throw new CubeException("Cube cannot be null");
        }
    }

}
