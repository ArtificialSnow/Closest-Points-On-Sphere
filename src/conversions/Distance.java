package conversions;

import main.Point;

import static conversions.AngleMapper.degreesToRadians;

public class Distance {

    /**
     * @return The great circle distance between points a and b.
     * The great circle distance between two points is the distance along the surface of the sphere.
     */
    public static double greatCircleDistance(Point a, Point b) {
        double aPhi = degreesToRadians(a.getLatitude());
        double bPhi = degreesToRadians(b.getLatitude());
        double deltaPhi = degreesToRadians(b.getLatitude() - a.getLatitude());
        double deltaLambda = degreesToRadians(b.getLongitude() - a.getLongitude());

        double component1 = Math.sin(deltaPhi/2.0);
        double component2 = Math.sin(deltaLambda/2.0);

        double x = (component1 * component1) + (Math.cos(aPhi) * Math.cos(bPhi) * component2 * component2);
        double c = Math.atan2(Math.sqrt(x), Math.sqrt(1-x));

        return Constants.radiusOfEarth * 2 * c;
    }
}
