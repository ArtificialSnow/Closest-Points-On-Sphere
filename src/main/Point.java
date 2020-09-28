package main;

import conversions.AngleMapper;
import conversions.Constants;

/**
 * Represents a point on the surface on the earth.
 *
 * Let R be the radius of the Earth.
 * Consider the axis running from o longitude to 180 longitude, with latitude 0.
 * Depth is a metric running along that axis; a point at the middle of the line has a depth of 0,
 * and a point at either end of the line has a depth of R and -R respectively.
 *
 * If latitude represents the z dimension (up and down), Depth is the y axis (away from you and towards you),
 * (and the x axis would be left to right).
 *
 * The purpose of depth is to provide another metric which we can sort points in a way such that:
 *  1. The difference in depth between two points is a lower bound for the distance between two points.
 *  2. If we have a sorted list of Points by depth, and any three points a,b,c such that the index of a < index of b < index of c
 *     If the difference in depth between (a,b) < difference in depth between (a,c)
 *     Then the distance between (a,b) < distance between (a,c)
 */
public class Point {
    String name;
    double latitude;
    double longitude;
    double depth;

    public Point(String name, double latitudeInDegrees, double longitudeInDegrees){
        this.name = name;
        this.latitude = latitudeInDegrees;
        this.longitude = longitudeInDegrees;
        this.depth = Math.cos(AngleMapper.degreesToRadians(latitudeInDegrees))
                * Math.cos(AngleMapper.degreesToRadians(longitudeInDegrees))
                * Constants.radiusOfEarth;
    }
}
