package io;

import main.Point;

/**
 * Encapsulates the data to be written to output.
 */
public class OutputData {

    private Point pointA;
    private Point pointB;
    private Double distance;

    public OutputData(Point pointA, Point pointB, Double distance) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.distance = distance;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Double getDistance() {
        return distance;
    }
}
