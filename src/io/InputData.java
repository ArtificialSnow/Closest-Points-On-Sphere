package io;

import main.Point;

/**
 * Encapsulates the data read from input.
 */
public class InputData {

    private int numPoints;
    private Point[] pointsByLatitude;
    private Point[] pointsByLatitudeCopy;

    public InputData(int numPoints, Point[] pointsByLatitude, Point[] pointsByLatitudeCopy) {
        this.numPoints = numPoints;
        this.pointsByLatitude = pointsByLatitude;
        this.pointsByLatitudeCopy = pointsByLatitudeCopy;
    }

    public int getNumPoints() {
        return numPoints;
    }

    public Point[] getPointsByLatitude() {
        return pointsByLatitude;
    }

    public Point[] getPointsByLatitudeCopy() {
        return pointsByLatitudeCopy;
    }
}
