package io;

import main.Point;

/**
 * Encapsulates the data read from input.
 */
public class InputData {

    int numPoints;
    Point[] pointsByLongitude;
    Point[] pointsByLongitudeCopy;

    public InputData(int numPoints, Point[] pointsByLongitude, Point[] pointsByLongitudeCopy) {
        this.numPoints = numPoints;
        this.pointsByLongitude = pointsByLongitude;
        this.pointsByLongitudeCopy = pointsByLongitudeCopy;
    }


    public int getNumPoints() {
        return numPoints;
    }

    public Point[] getPointsByLongitude() {
        return pointsByLongitude;
    }

    public Point[] getPointsByLongitudeCopy() {
        return pointsByLongitudeCopy;
    }
}
